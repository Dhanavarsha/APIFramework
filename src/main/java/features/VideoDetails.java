package features;


import Client.Client;
import microservices.VideosService;
import models.VideoResponse.Video;
import retrofit2.Response;
import utils.PropertyFileReader;

import java.io.IOException;

public class VideoDetails {
    private static PropertyFileReader propertyFileReader = new PropertyFileReader();
    private static Response<Video> response;
    private static Video video;
    private String id;

    public VideoDetails(String id) {
        this.id = id;
    }

    public static Video getVideo() throws IOException {
        video = response.body();
        return video;
    }


    public static Response<Video> getVideosServiceResponse(String id) throws IOException {
        response = Client.getService(VideosService.class)
                .getVideoUsingId("id,contentDetails,snippet,statistics",
                        propertyFileReader.getApikey(),
                        id)
                .execute();
        return response;
    }
}
