import gmail.GmailApiController;
import supportRequest.HttpController;
import supportRequest.RequestForm;


public class GmailAPI {

    public static void main(String[] args) throws Exception {
        //Задание 1 и 3
        GmailApiController.listMessages();

        //Задание 2
        RequestForm requestForm = new RequestForm();
        requestForm.setDepartment("Обжиговый цех");
        requestForm.setPosition("Мол");
        requestForm.setAgreement("1");
        HttpController.PostSend(requestForm);
    }


}
