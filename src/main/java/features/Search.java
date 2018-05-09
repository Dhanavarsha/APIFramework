package features;

import Client.Client;
import microservices.SearchService;
import models.SearchResponse.SearchResult;
import retrofit2.Response;
import utils.PropertyFileReader;

public class Search {
    private final String query;
    private PropertyFileReader propertyFileReader;
    private Response<SearchResult> response;

    public Search(String query) {
        this.query = query;
        this.propertyFileReader = new PropertyFileReader();
    }

    public SearchResult getSearchResult() {
        return response.body();
    }

    public Response<SearchResult> getSearchServiceResponse() {
        try {
            this.response = Client.getService(SearchService.class)
                    .searchWithQuery(
                            "snippet",
                            propertyFileReader.getApikey(),
                            query,
                            "video",
                            10)
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
