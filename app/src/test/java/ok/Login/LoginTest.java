package ok.Login;

import org.example.okmsger.utils.Loginner;
import org.example.okmsger.utils.UserCredentials;
import org.junit.jupiter.api.BeforeEach;
import ok.BaseTest;

public class LoginTest extends BaseTest {
    protected Loginner loginner;
    protected UserCredentials credentials;

    @BeforeEach
    public void start() {
        loginner = new Loginner();
        loginner.login();
        logger.info("Successfully logged in");
    }
}