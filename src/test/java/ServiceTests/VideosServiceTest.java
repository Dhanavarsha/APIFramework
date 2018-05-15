package ServiceTests;

import features.VideoDetails;
import models.ratingResponse.Rating;
import models.videoResponse.Video;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class VideosServiceTest {

    @Test
    public void testGetVideo() throws IOException {
        VideoDetails videoDetails = new VideoDetails("TMuno5RZNeE");

        Response<Video> video = videoDetails.getVideoInfo();

        Assert.assertEquals(video.code(), 200);
        Assert.assertEquals(video.message(), "OK");
    }

    @Test(groups = "videoRating")
    public void testLikeAVideo() throws IOException {
        VideoDetails videoDetails = new VideoDetails("FepIkIILumA");
        videoDetails.removeRating();

        Response<Void> rate = videoDetails.likeVideo();

        Assert.assertEquals(rate.code(), 204);
        Assert.assertEquals(rate.message(), "No Content");
    }

    @Test(groups = "videoRating")
    public void testDislikeAVideo() throws IOException {
        VideoDetails videoDetails = new VideoDetails("S9KxqRUcnCU");
        videoDetails.removeRating();
        Response<Void> rate = videoDetails.dislikeVideo();

        Assert.assertEquals(rate.code(), 204);
        Assert.assertEquals(rate.message(), "No Content");
    }

    @Test(groups = "videoRating")
    public void testGetRatingOfVideo() throws IOException {
        VideoDetails videoDetails = new VideoDetails("hYirFqEc8Tg");
        videoDetails.removeRating();
        Response<Rating> rating = videoDetails.getVideoRating();

        Assert.assertEquals(rating.code(), 200);
        Assert.assertEquals(rating.message(), "OK");
        Assert.assertTrue(rating.body().getItems().get(0).getRating().toString().equals("none"));
    }
}
