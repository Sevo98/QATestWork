package supportRequest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HttpControllerTest {

    @Test
    void testPostSendWithData() throws Exception {

        RequestForm requestForm = new RequestForm();
        requestForm.setDepartment("Обжиговый цех");
        requestForm.setPosition("Мол");
        requestForm.setAgreement("1");

        HttpController.PostSend(requestForm);
    }

    @Test
    void testPostSendWithoutData() {
        RequestForm requestForm = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            HttpController.PostSend(requestForm);
        });
    }
}