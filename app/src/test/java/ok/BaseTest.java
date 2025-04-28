package ok;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.example.okmsger.utils.Navigator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.logging.Logger;

public class BaseTest {
    protected final Logger logger = Logger.getLogger(getClass().getName());
    protected Navigator navigator;

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void initNavigator() {
        navigator = new Navigator();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}