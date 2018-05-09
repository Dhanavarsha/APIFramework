package features;


import Client.Client;
import microservices.VideosService;
import models.VideoResponse.Video;
import retrofit2.Response;
import utils.PropertyFileReader;

import java.io.IOException;

public class VideoDetails {
    private PropertyFileReader propertyFileReader;
    private Response<Video> response;
    private String id;

    public VideoDetails(String id) {
        this.id = id;
        this.propertyFileReader = new PropertyFileReader();
    }

    public Video getVideo() throws IOException {
        return response.body();
    }


    public Response<Video> getVideosServiceResponse() throws IOException {
        this.response = Client.getService(VideosService.class)
                .getVideoUsingId("id,contentDetails,snippet,statistics",
                        propertyFileReader.getApikey(),
                        id)
                .execute();
        return response;
    }
}
