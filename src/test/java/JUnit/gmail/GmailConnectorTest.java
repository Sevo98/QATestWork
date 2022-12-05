package JUnit.gmail;

import gmail.GmailConnector;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * ����� �������� ������� ������ GmailConnector
 */
public class GmailConnectorTest {
    /**
     * �������� ������ ��������� ������ getAccessToken()
     */
    @Test
    void testGetAccess() {
        GmailConnector.getAccessToken();
    }

    /**
     * �������� ������� ����������� GmailConnector.auth()
     * @throws GeneralSecurityException
     * @throws IOException
     */
    @Test
    void testAuth() throws GeneralSecurityException, IOException {
        GmailConnector.auth();
    }
}
