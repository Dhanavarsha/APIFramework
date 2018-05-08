package ServiceTests;

import features.SearchInYoutube;
import models.SearchResponse.SearchResult;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class SearchServiceTest {

    @Test
    public void testSearchUsingQuery() throws IOException {
        Response<SearchResult> result = SearchInYoutube.getSearchServiceResponse("uncle bob");
        Assert.assertEquals(result.code(), 200);
        Assert.assertEquals(result.message(), "OK");
        Assert.assertEquals(SearchInYoutube.getSearchResult().getItems().get(0).getSnippet().getTitle().trim(),
                "Bob Martin   SOLID Principles of Object Oriented and Agile Design");
    }
}
