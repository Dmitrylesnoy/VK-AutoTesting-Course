import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.okmsger.pages.FeedPage;
import org.example.okmsger.utils.Loginner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("messaging")
@DisplayName("Message Page Tests")
public class OpenMessagePageTest {
  private FeedPage feedPage;
  private String name, password;

  @BeforeEach
  public void setUp() {
    browser = "chrome";
    feedPage = new FeedPage();
    Loginner loginer = new Loginner();
    name = System.getenv("OK_NAME");
    name = System.getenv("OK_PASSWORD");
    loginer.login(name,password);
  }

    @Test
    @DisplayName("Test opening message page")
    public void openMessagePage() {
      feedPage.open()
          .clickLogo()
          .clickMessagesButton();
      feedPage.getChatWindow().should(be(visible));
    }
  
    @AfterEach
    public void tearDown() {
      // Loginner.logout();
      closeWebDriver();
    }
}