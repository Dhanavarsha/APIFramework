package OAuth2;

import fi.iki.elonen.NanoHTTPD;
import models.OAuthResponse.Token;
import org.apache.http.client.utils.URIBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.PropertyFileReader;

import java.io.IOException;
import java.net.URISyntaxException;

public class AuthorizationServer extends NanoHTTPD {
    private PropertyFileReader propertyFileReader;

    public AuthorizationServer(int port) throws IOException {
        super(port);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        propertyFileReader = new PropertyFileReader();
        System.out.println("\n Authorization Server Running! Point your browsers to http://localhost:" + port + "/ \n");
    }

    @Override
    public Response serve(IHTTPSession session) {

        String msg = "<html><body><a href=" + getAuthorizationRequestURL() + ">Give Authorizaton</a>";

        if ("/oauth2".equals(session.getUri())) {
            String code = session.getParms().get("code");
            msg += "<h4>Code: " + code + "</h4>" +
                    "<h4>Access Token : " + requestToken(code) + "</h4>";
        }

        return newFixedLengthResponse(msg +
                "</body></html>\n");
    }

    private String getAuthorizationRequestURL() {
        try {
            return new URIBuilder().setPath("https://accounts.google.com/o/oauth2/v2/auth")
                    .addParameter("scope", "https://www.googleapis.com/auth/youtube")
                    .addParameter("access_type", "offline")
                    .addParameter("include_granted_scopes", "true")
                    .addParameter("redirect_uri", "http://localhost:8081/oauth2")
                    .addParameter("response_type", "code")
                    .addParameter("client_id", propertyFileReader.getClientId())
                    .build()
                    .toString();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    private String requestToken(String code) {
        String token = "";
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.googleapis.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            retrofit2.Response<Token> tokenResponse = retrofit.create(OAuth2AccessTokenService.class)
                    .requestToken(
                            code,
                            propertyFileReader.getClientId(),
                            propertyFileReader.getClientSecret(),
                            "http://localhost:8081/oauth2",
                            "authorization_code")
                    .execute();

            token = tokenResponse.body().getAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public static void main(String[] args) throws IOException {
        new AuthorizationServer(8081);
    }
}
