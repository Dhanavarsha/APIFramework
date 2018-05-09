package ServiceTests;

import features.VideoDetails;
import models.VideoResponse.Video;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class VideosServiceTest {
    @Test
    public void testGetVideo() throws IOException {
        VideoDetails videoDetails = new VideoDetails("TMuno5RZNeE");

        Response<Video> video = videoDetails.getVideosServiceResponse();

        Assert.assertEquals(video.code(), 200);
        Assert.assertEquals(video.message(), "OK");
    }
}
