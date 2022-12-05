package JUnit.gmail;

import gmail.GmailApiController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Класс проверки методов класса GmailApiController
 */
public class GmailApiControllerTest {

    /**
     * Проверка метода printMessageTo()
     * @throws GeneralSecurityException
     * @throws IOException
     */
    @Test
    void testPrintMessagesTo() throws GeneralSecurityException, IOException {
        GmailApiController.printMessageTo();
    }

    /**
     * Проверка метода printMessageFrom()
     * @throws GeneralSecurityException
     * @throws IOException
     */
    @Test
    void testPrintMessagesFrom() throws GeneralSecurityException, IOException {
        GmailApiController.printMessageFrom();
    }

    /**
     * Проверка метода listMessages()
     * @throws GeneralSecurityException
     * @throws IOException
     */
    @Test
    void testListMessages() throws GeneralSecurityException, IOException {
        GmailApiController.listMessages();
    }


    //Проверка на пустой ящик. Удалить все письма из ящика перед проверкой

//    /**
//     * Проверка методода printMessageTo() без писем
//     * @throws GeneralSecurityException
//     * @throws IOException
//     */
//    @Test
//    void testPrintMessagesToNoLetters() {
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            GmailApiController.printMessageTo();
//        });
//
//    }
//
//    /**
//     * Проверка методода printMessageFrom() без писем
//     * @throws GeneralSecurityException
//     * @throws IOException
//     */
//    @Test
//    void testPrintMessagesFromToNoLetters() {
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            GmailApiController.printMessageFrom();
//        });
//
//    }
//
//    /**
//     * Проверка методода listMessage() без писем
//     * @throws GeneralSecurityException
//     * @throws IOException
//     */
//    @Test
//    void testListMessagesToNoLetters() {
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            GmailApiController.listMessages();
//        });
//    }
}
