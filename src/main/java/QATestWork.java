import gmail.GmailApiController;
import supportRequest.HttpController;
import supportRequest.RequestForm;


public class QATestWork {

    public static void main(String[] args) throws Exception {
        //������� 1 � 3
        GmailApiController.listMessages();

        //������� 2
        RequestForm requestForm = new RequestForm();
        requestForm.setDepartment("��������� ���");
        requestForm.setPosition("���");
        requestForm.setAgreement("1");
        HttpController.PostSend(requestForm);
    }
}