package assertions;

import org.testng.Assert;
import retrofit2.Response;

public enum ResponseStatus {
    OK("OK", 200),
    NO_CONTENT("No Content", 204);

    private String message;
    private int code;

    ResponseStatus(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public <T> void assertResponse(Response<T> response) {
        Assert.assertEquals(response.code(), this.code);
        Assert.assertEquals(response.message(), this.message);
    }
}
