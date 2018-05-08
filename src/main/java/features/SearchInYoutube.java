package features;

import Client.Client;
import microservices.SearchService;
import models.SearchResponse.SearchResult;
import retrofit2.Response;
import utils.PropertyFileReader;

import java.io.IOException;

public class SearchInYoutube {
    private static PropertyFileReader propertyFileReader = new PropertyFileReader();
    private static Response<SearchResult> response;
    private static SearchResult searchResult;
    private String query;

    public SearchInYoutube(String query) {
        this.query = query;
    }

    public static SearchResult getSearchResult() {
        searchResult = response.body();
        return searchResult;
    }

    public static Response<SearchResult> getSearchServiceResponse(String query) throws IOException {
        response = Client.getService(SearchService.class)
                .searchWithQuery(
                        "snippet",
                        propertyFileReader.getApikey(),
                        query,
                        "video",
                        10)
                .execute();
        return response;
    }
}
