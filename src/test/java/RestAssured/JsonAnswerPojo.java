package RestAssured;

/**
 * Pojo ????? Json ??????
 */
public class JsonAnswerPojo {
    private String statusCode;

    public JsonAnswerPojo(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
