package JUnit.supportRequest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import supportRequest.HttpController;
import supportRequest.RequestForm;

/**
 * ����� �������� ������� HttpController
 */
public class HttpControllerTest {

    /**
     * �������� ������ PostSend() � ������������������� �������
     * @throws Exception
     */
    @Test
    void testPostSendWithData() throws Exception {

        RequestForm requestForm = new RequestForm();
        requestForm.setDepartment("��������� ���");
        requestForm.setPosition("���");
        requestForm.setAgreement("1");

        HttpController.PostSend(requestForm);
    }

    /**
     * �������� ������ PostSend() � ��������� ������� �������
     */
    @Test
    void testPostSendWithoutData() {
        RequestForm requestForm = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            HttpController.PostSend(requestForm);
        });
    }
}