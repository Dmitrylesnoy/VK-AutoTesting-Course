package ok.functionTest;
import static com.codeborne.selenide.Condition.*;

import org.example.okmsger.pages.FeedPage;
import org.example.okmsger.utils.Loginner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import ok.BaseTest;

public class OpenMessagePageTest extends BaseTest{
  private FeedPage feedPage;
  private String name, password;
  private Loginner loginner = new Loginner();;

  @BeforeEach
  public void pages() {
    feedPage = new FeedPage();
    // loginner = new Loginner();
    name = System.getenv("OK_NAME");
    password = System.getenv("OK_PASSWORD");
    loginner.login(name, password);
    logger.info("Succesfully log in");
  }

    @Test
    @Tag("Messaging")
    @DisplayName("Test opening message page")
    public void openMessagePage() {
      feedPage.open().clickMessagesButton();
      logger.info("Message button clicked");
      feedPage.getChatWindow().should(be(visible));
    }
  
    @AfterEach
    public void logout() {
        loginner.logout();
        // closeWebDriver();
    }
    
}