package ServiceTests;

import Client.Client;
import microservices.VideosService;
import models.VideoResponse.Video;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;
import utils.PropertyFileReader;

import java.io.IOException;

public class VideosServiceTest {
    @Test
    public void testVideoDetails() throws IOException {
        PropertyFileReader propertyFile = new PropertyFileReader();

        VideosService videosService = Client.getService(VideosService.class);

        Response<Video> video = videosService.getVideoUsingId(
                "id,contentDetails,snippet,statistics",
                propertyFile.getApikey(),
                "TMuno5RZNeE").execute();

        Assert.assertEquals(video.code(), 200);
        Assert.assertEquals(video.message(), "OK");
    }
}
