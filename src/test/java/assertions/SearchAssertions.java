package assertions;

import models.searchResponse.SearchResult;
import org.testng.Assert;
import retrofit2.Response;

public class SearchAssertions {

    public static void assertVideoTitleAtIndex(int index, String expectedTitle, Response<SearchResult> response) {
        Assert.assertEquals(response.body().getItems().get(index).getSnippet().getTitle().trim(), expectedTitle);
    }
}
