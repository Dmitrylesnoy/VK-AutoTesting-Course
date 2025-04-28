package ok;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class BaseTest {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 2000;
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}