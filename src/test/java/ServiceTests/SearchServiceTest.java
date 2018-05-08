package ServiceTests;

import Client.Client;
import microservices.SearchService;
import models.SearchResponse.SearchResult;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;
import utils.PropertyFileReader;

import java.io.IOException;

public class SearchServiceTest {
    @Test
    public void testSearchForSuccess() throws IOException {
        PropertyFileReader propertyFileReader = new PropertyFileReader();

        SearchService searchService = Client.getService(SearchService.class);

        Response<SearchResult> result = searchService.searchWithQuery(
                "snippet",
                propertyFileReader.getApikey(),
                "uncle bob",
                "video",
                10).execute();

        Assert.assertEquals(result.code(), 200);
        Assert.assertEquals(result.message(), "OK");
    }
}
