package JUnit.supportRequest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import supportRequest.HttpController;
import supportRequest.RequestForm;

/**
 * Класс проверки методов HttpController
 */
public class HttpControllerTest {

    /**
     * Проверка метода PostSend() с инициализированными данными
     * @throws Exception
     */
    @Test
    void testPostSendWithData() throws Exception {

        RequestForm requestForm = new RequestForm();
        requestForm.setDepartment("Обжиговый цех");
        requestForm.setPosition("Мол");
        requestForm.setAgreement("1");

        HttpController.PostSend(requestForm);
    }

    /**
     * Проверка метода PostSend() с отправкой пустого объекта
     */
    @Test
    void testPostSendWithoutData() {
        RequestForm requestForm = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            HttpController.PostSend(requestForm);
        });
    }
}