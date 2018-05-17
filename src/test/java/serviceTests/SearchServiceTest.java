package serviceTests;

import assertions.ResponseStatus;
import assertions.SearchAssertions;
import features.Search;
import models.searchResponse.SearchResult;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class SearchServiceTest {

    @Test
    public void testSearchUsingQuery() throws IOException {
        Search search = new Search("uncle bob");
        Response<SearchResult> result = search.getSearchServiceResponse();
        ResponseStatus.OK.assertResponse(result);
        SearchAssertions.assertVideoTitleAtIndex(
                0,
                "Bob Martin   SOLID Principles of Object Oriented and Agile Design",
                result);
    }
}
