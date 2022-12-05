package Selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * Базовый класс для создания теста Selenide
 */
abstract public class BaseTest {

    /**
     * Метод установки драйвера браузера, в котором будет проходить тест
     */
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    /**
     * Инициализация браузера
     */
    @BeforeAll
    public void init() {
        setUp();
    }

    /**
     * Закрытие браузера
     */
    @AfterAll
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
