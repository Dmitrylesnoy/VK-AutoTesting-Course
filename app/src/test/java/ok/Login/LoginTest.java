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
        credentials = new UserCredentials(System.getenv("OK_NAME"), System.getenv("OK_PASSWORD"));
        loginner.login(credentials);
        logger.info("Successfully logged in");
    }
}