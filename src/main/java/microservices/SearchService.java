package microservices;

import models.searchResponse.SearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface SearchService {
    @GET("search")
    @Headers("Auth:API_KEY")
    Call<SearchResult> searchWithQuery(@Query("part") String part,
                                       @Query("q") String query,
                                       @Query("type") String type,
                                       @Query("maxResults") int maxResults);
}
