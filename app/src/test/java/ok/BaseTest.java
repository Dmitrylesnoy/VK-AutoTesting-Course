package ok;

import static com.codeborne.selenide.Selenide.*;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;

public class BaseTest {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
    }

    @AfterAll
    public static void tearDown() {
        closeWebDriver();
    }
}
