package ServiceTests;

import microservices.SearchService;
import models.SearchResponse.SearchResult;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class SearchServiceTest {
    @Test
    public void testSearchForSuccess() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        SearchService searchService = retrofit.create(SearchService.class);
        Call<SearchResult> call = searchService.searchWithQuery(
                "snippet",
                "AIzaSyAT4Uso-Cwn0q78KXDAju67nR4tg4pJKnA",
                "uncle bob",
                "video",
                10);

        Response<SearchResult> result = call.execute();
        Assert.assertEquals(result.code(), 200);
        Assert.assertEquals(result.message(), "OK");
    }
}
