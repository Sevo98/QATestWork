package JUnit.gmail;

import gmail.GmailApiController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class GmailApiControllerTest {

    @Test
    void testPrintMessagesTo() throws GeneralSecurityException, IOException {
        GmailApiController.printMessageTo();
    }

    @Test
    void testPrintMessagesFrom() throws GeneralSecurityException, IOException {
        GmailApiController.printMessageFrom();
    }

    @Test
    void testListMessages() throws GeneralSecurityException, IOException {
        GmailApiController.listMessages();
    }


    //Проверка на пустой ящик. Удалить все письма из ящика перед проверкой

//    @Test
//    void testPrintMessagesToNoLetters() {
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            GmailApiController.printMessageTo();
//        });
//
//    }
//
//    @Test
//    void testPrintMessagesFromToNoLetters() {
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            GmailApiController.printMessageFrom();
//        });
//
//    }
//
//    @Test
//    void testListMessagesToNoLetters() {
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            GmailApiController.listMessages();
//        });
//    }
}
