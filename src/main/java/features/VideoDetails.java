package features;


import client.Client;
import microservices.VideosService;
import models.ratingResponse.Rating;
import models.videoResponse.Video;
import retrofit2.Response;

import java.io.IOException;

public class VideoDetails {
    private String id;

    public VideoDetails(String id) {
        this.id = id;
    }

    public Response<Video> getVideoInfo() throws IOException {
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

    public Response<Void> removeRating() throws IOException {
        return Client.getService(VideosService.class)
                .rateAVideo(id, "none")
                .execute();
    }

    public Response<Void> likeVideo() throws IOException {
        return Client.getService(VideosService.class)
                .rateAVideo(id, "like")
                .execute();
    }

    public Response<Void> dislikeVideo() throws IOException {
        return Client.getService(VideosService.class)
                .rateAVideo(id, "dislike")
                .execute();
    }
}
