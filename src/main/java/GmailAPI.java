import gmail.GmailApiController;
import supportRequest.HttpController;

import java.io.*;
import java.security.GeneralSecurityException;

public class GmailAPI {


    public static void main(String[] args) throws Exception {
        //������� 1 � 3
        GmailApiController.listMessages();

        //������� 2
        HttpController.PostSend("hello world");
    }


}
