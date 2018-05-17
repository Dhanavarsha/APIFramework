package assertions;

import models.ratingResponse.Rating;
import org.testng.Assert;
import retrofit2.Response;

public class VideosAssertions {
    public static void assertRatingAsNone(Response<Rating> response) {
        Assert.assertEquals(response.body().getItems().get(0).getRating(), "none");
    }
}
