package ServiceTests;

import features.Search;
import models.SearchResponse.SearchResult;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class SearchServiceTest {

    @Test(groups = "smoke")
    public void testSearchUsingQuery() throws IOException {
        Search search = new Search("uncle bob");

        Response<SearchResult> result = search.getSearchServiceResponse();

        Assert.assertEquals(result.code(), 200);
        Assert.assertEquals(result.message(), "OK");
        Assert.assertEquals(result.body().getItems().get(0).getSnippet().getTitle().trim(),
                "Bob Martin   SOLID Principles of Object Oriented and Agile Design");
    }
}
