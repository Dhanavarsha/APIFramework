package serviceTests;

import assertions.ResponseStatus;
import assertions.VideosAssertions;
import features.VideoDetails;
import models.ratingResponse.Rating;
import models.videoResponse.Video;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class VideosServiceTest {

    @Test
    public void testGetVideo() throws IOException {
        VideoDetails videoDetails = new VideoDetails("TMuno5RZNeE");
        Response<Video> video = videoDetails.getVideoInfo();
        ResponseStatus.OK.assertResponse(video);
    }

    @Test(groups = "videoRating")
    public void testLikeAVideo() throws IOException {
        VideoDetails videoDetails = new VideoDetails("FepIkIILumA");
        videoDetails.removeRating();
        Response<Void> rate = videoDetails.likeVideo();
        ResponseStatus.NO_CONTENT.assertResponse(rate);
    }

    @Test(groups = "videoRating")
    public void testDislikeAVideo() throws IOException {
        VideoDetails videoDetails = new VideoDetails("S9KxqRUcnCU");
        videoDetails.removeRating();
        Response<Void> rate = videoDetails.dislikeVideo();
        ResponseStatus.NO_CONTENT.assertResponse(rate);
    }

    @Test(groups = "videoRating")
    public void testGetRatingOfVideo() throws IOException {
        VideoDetails videoDetails = new VideoDetails("hYirFqEc8Tg");
        videoDetails.removeRating();
        Response<Rating> rating = videoDetails.getVideoRating();
        ResponseStatus.OK.assertResponse(rating);
        VideosAssertions.assertRatingAsNone(rating);
    }
}
