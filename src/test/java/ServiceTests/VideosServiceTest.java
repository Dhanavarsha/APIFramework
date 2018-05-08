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
        Response<Video> video = VideoDetails.getVideosServiceResponse("TMuno5RZNeE");
        Assert.assertEquals(video.code(), 200);
        Assert.assertEquals(video.message(), "OK");
    }
}
