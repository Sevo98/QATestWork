import gmail.GmailApiController;
import supportRequest.HttpController;

import java.io.*;
import java.security.GeneralSecurityException;

public class GmailAPI {


    public static void main(String[] args) throws Exception {
        //Задание 1 и 3
        GmailApiController.listMessages();

        //Задание 2
        HttpController.PostSend("hello world");
    }


}
