package ServiceTests;

import microservices.SearchService;
import models.SearchResponse.SearchResult;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.PropertyFileReader;

import java.io.IOException;

public class SearchServiceTest {
    @Test
    public void testSearchForSuccess() throws IOException {
        PropertyFileReader propertyFileReader = new PropertyFileReader();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(propertyFileReader.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        SearchService searchService = retrofit.create(SearchService.class);
        Call<SearchResult> call = searchService.searchWithQuery(
                "snippet",
                propertyFileReader.getApikey(),
                "uncle bob",
                "video",
                10);

        Response<SearchResult> result = call.execute();
        Assert.assertEquals(result.code(), 200);
        Assert.assertEquals(result.message(), "OK");
    }
}
