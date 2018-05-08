package microservices;

import models.SearchResponse.SearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchService {
    @GET("search")
    Call<SearchResult> searchResultWithQuery(@Query("part") String part,
                                             @Query("key") String apikey,
                                             @Query("q") String query,
                                             @Query("type") String type,
                                             @Query("maxResults") int maxResults);
}
