package JUnit.gmail;

import gmail.GmailApiController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * ����� �������� ������� ������ GmailApiController
 */
public class GmailApiControllerTest {

    /**
     * �������� ������ printMessageTo()
     * @throws GeneralSecurityException
     * @throws IOException
     */
    @Test
    void testPrintMessagesTo() throws GeneralSecurityException, IOException {
        GmailApiController.printMessageTo();
    }

    /**
     * �������� ������ printMessageFrom()
     * @throws GeneralSecurityException
     * @throws IOException
     */
    @Test
    void testPrintMessagesFrom() throws GeneralSecurityException, IOException {
        GmailApiController.printMessageFrom();
    }

    /**
     * �������� ������ listMessages()
     * @throws GeneralSecurityException
     * @throws IOException
     */
    @Test
    void testListMessages() throws GeneralSecurityException, IOException {
        GmailApiController.listMessages();
    }


    //�������� �� ������ ����. ������� ��� ������ �� ����� ����� ���������

//    /**
//     * �������� �������� printMessageTo() ��� �����
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
//     * �������� �������� printMessageFrom() ��� �����
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
//     * �������� �������� listMessage() ��� �����
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
