package Client;

import okhttp3.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.PropertyFileReader;

public class Client {
    private static PropertyFileReader propertyFileReader = new PropertyFileReader();
    private static final String BASE_URL = "https://www.googleapis.com/youtube/v3/";

    private static Retrofit getRetrofit() {

        Interceptor interceptor = chain -> {
            Request request = chain.request();

            if ("API_KEY".equals(request.header("Auth"))) {
                HttpUrl url = request
                        .url()
                        .newBuilder()
                        .addQueryParameter(
                                "key", propertyFileReader.getApikey())
                        .build();
                request = request
                        .newBuilder()
                        .url(url)
                        .build();
                return chain.proceed(request);
            } else if ("ACCESS_TOKEN".equals(request.header("Auth"))) {
                Request newRequest = request
                        .newBuilder()
                        .addHeader("Authorization", propertyFileReader.getAccessToken())
                        .build();
                return chain.proceed(newRequest);
            }
            return chain.proceed(request);
        };

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static <T> T getService(Class<T> serviceClass) {
        return getRetrofit().create(serviceClass);
    }
}
