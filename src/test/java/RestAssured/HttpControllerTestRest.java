package RestAssured;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Класс проверки Rest запросов по заданному url. Провека на status 200 во всех запросах
 */
public class HttpControllerTestRest {

    private final static String url = "https://gtest.dev.mk.ugmk.com/0200/api-mobile/v1";

    /**
     * Проверка на наличие statusCode 400 в Json ответе
     */
    @Test
    void PostStatus400inJson() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecificationOK200());

        String statusCode = "400";

        RequestFormPojo request = new RequestFormPojo("Обжиговый цех", "Мол", "1");

        JsonAnswerPojo JsonAnswer = given()
                .body(request)
                .when()
                .post("/support/")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(JsonAnswerPojo.class);

        Assertions.assertEquals(statusCode, JsonAnswer.getStatusCode());
    }

    /**
     * Проверка на несопвпадение со statusCode 400 в Json ответе
     */
    @Test
    void PostStatus200inJson() {
        Specifications.installSpecification(Specifications.requestSpecification(url), Specifications.responseSpecificationOK200());

        String statusCode = "200";

        RequestFormPojo request = new RequestFormPojo("Обжиговый цех", "Мол", "1");

        JsonAnswerPojo JsonAnswer = given()
                .body(request)
                .when()
                .post("/support/")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(JsonAnswerPojo.class);
        Assertions.assertNotEquals(statusCode, JsonAnswer.getStatusCode());
    }
}
