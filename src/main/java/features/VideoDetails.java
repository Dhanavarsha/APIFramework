package features;


import Client.Client;
import microservices.VideosService;
import models.RatingResponse.Rating;
import models.VideoResponse.Video;
import retrofit2.Response;

import java.io.IOException;

public class VideoDetails {
    private String id;

    public VideoDetails(String id) {
        this.id = id;
    }

    public Response<Video> getVideosServiceResponse() throws IOException {
        return Client.getService(VideosService.class)
                .getVideoUsingId("id,contentDetails,snippet,statistics",
                        id)
                .execute();
    }

    public Response<Void> rateAVideo(String rating) throws IOException {
        return Client.getService(VideosService.class)
                .rateAVideo(id, rating)
                .execute();
    }

    public Response<Rating> getVideoRating() throws IOException {
        return Client.getService(VideosService.class)
                .getVideoRating(id)
                .execute();
    }

}
