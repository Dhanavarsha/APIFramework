package ServiceTests;

import microservices.VideosService;
import models.VideoResponse.Video;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.PropertyFileReader;

import java.io.IOException;

public class VideosServiceTest {
    @Test
    public void testVideoDetails() throws IOException {
        PropertyFileReader propertyFile = new PropertyFileReader();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(propertyFile.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VideosService videosService = retrofit.create(VideosService.class);
        Call<Video> call = videosService.getVideoUsingId(
                "id,contentDetails,snippet,statistics",
                propertyFile.getApikey(),
                "TMuno5RZNeE");

        Response<Video> video = call.execute();
        Assert.assertEquals(video.code(), 200);
        Assert.assertEquals(video.message(), "OK");
    }
}
