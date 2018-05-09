package microservices;

import models.RatingResponse.Rating;
import models.VideoResponse.Video;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface VideosService {
    @GET("videos")
    @Headers("Auth:API_KEY")
    Call<Video> getVideoUsingId(@Query("part") String part,
                                @Query("id") String videoId);

    @POST("videos/rate")
    @Headers("Auth:ACCESS_TOKEN")
    Call<Void> rateAVideo(@Query("id") String videoId,
                          @Query("rating") String rating);

    @GET("videos/getRating")
    @Headers("Auth:ACCESS_TOKEN")
    Call<Rating> getVideoRating(@Query("id") String videoId);
}
