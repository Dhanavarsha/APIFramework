
package models.VideoResponse;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PageInfo {

    @SerializedName("resultsPerPage")
    private Long mResultsPerPage;
    @SerializedName("totalResults")
    private Long mTotalResults;

    public Long getResultsPerPage() {
        return mResultsPerPage;
    }

    public void setResultsPerPage(Long resultsPerPage) {
        mResultsPerPage = resultsPerPage;
    }

    public Long getTotalResults() {
        return mTotalResults;
    }

    public void setTotalResults(Long totalResults) {
        mTotalResults = totalResults;
    }

}
