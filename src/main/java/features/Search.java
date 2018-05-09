package features;

import Client.Client;
import microservices.SearchService;
import models.SearchResponse.SearchResult;
import retrofit2.Response;

import java.io.IOException;

public class Search {
    private final String query;

    public Search(String query) {
        this.query = query;
    }

    public Response<SearchResult> getSearchServiceResponse() throws IOException {
        return Client.getService(SearchService.class)
                .searchWithQuery(
                        "snippet",
                        query,
                        "video",
                        10)
                .execute();
    }
}
