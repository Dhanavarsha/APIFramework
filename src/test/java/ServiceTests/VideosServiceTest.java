package ServiceTests;

import features.VideoDetails;
import models.RatingResponse.Rating;
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

    @Test
    public void testRateAVideo() throws IOException {
        VideoDetails videoDetails = new VideoDetails("FepIkIILumA");

        Response<Void> rate = videoDetails.rateAVideo("like");

        Assert.assertEquals(rate.code(), 204);
        Assert.assertEquals(rate.message(), "No Content");
    }

    @Test
    public void testGetRating() throws IOException {
        VideoDetails videoDetails = new VideoDetails("FepIkIILumA");

        Response<Rating> rating = videoDetails.getVideoRating();

        Assert.assertEquals(rating.code(), 200);
        Assert.assertEquals(rating.message(), "OK");
        Assert.assertTrue(rating.body().getItems().get(0).getRating().equals("like"));
    }
}
