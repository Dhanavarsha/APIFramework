package microservices;

import models.VideoResponse.Video;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VideosService {
    @GET("videos")
    Call<Video> getVideoUsingId(@Query("part") String part,
                                @Query("key") String apikey,
                                @Query("id") String videoId);
}
