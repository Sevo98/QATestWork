package JUnit.gmail;

import gmail.GmailConnector;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Класс проверки методов класса GmailConnector
 */
public class GmailConnectorTest {
    /**
     * Проверка метода получения токена getAccessToken()
     */
    @Test
    void testGetAccess() {
        GmailConnector.getAccessToken();
    }

    /**
     * Проверка методоа авторизации GmailConnector.auth()
     * @throws GeneralSecurityException
     * @throws IOException
     */
    @Test
    void testAuth() throws GeneralSecurityException, IOException {
        GmailConnector.auth();
    }
}
