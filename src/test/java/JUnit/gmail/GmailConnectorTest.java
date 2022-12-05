package JUnit.gmail;

import gmail.GmailConnector;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class GmailConnectorTest {
    @Test
    void testGetAccess() {
        GmailConnector.getAccessToken();
    }

    @Test
    void testAuth() throws GeneralSecurityException, IOException {
        GmailConnector.auth();
    }
}
