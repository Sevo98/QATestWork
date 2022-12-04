package gmail;

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
}
