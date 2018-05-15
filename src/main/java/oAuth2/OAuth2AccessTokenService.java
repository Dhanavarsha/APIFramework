package oAuth2;

import models.oAuthResponse.Token;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OAuth2AccessTokenService {
    @FormUrlEncoded
    @POST("/oauth2/v4/token")
    Call<Token> requestToken(@Field("code") String code,
                             @Field("client_id") String clientId,
                             @Field("client_secret") String clientSecret,
                             @Field("redirect_uri") String redirectURI,
                             @Field("grant_type") String grantType);
}
