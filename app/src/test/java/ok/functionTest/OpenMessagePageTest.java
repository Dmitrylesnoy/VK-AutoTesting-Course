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

public class OpenMessagePageTest extends BaseTest {
  private FeedPage feedPage;
  private Loginner loginner;
  private String name, password;

  @BeforeEach
  public void start() {
    name = System.getenv("OK_NAME");
    password = System.getenv("OK_PASSWORD");
    loginner = new Loginner();
    loginner.login(name, password);
    logger.info("Successfully logged in");
    feedPage = new FeedPage();
  }

  @Test
  @Tag("Messaging")
  @DisplayName("Test opening message page")
  public void openMessagePage() {
    feedPage.clickMessagesButton();
    logger.info("Messages button clicked");
    feedPage.getChatWindow().shouldBe(visible);
    logger.info("Chat window is visible");
  }

  @AfterEach
  public void end() {
    loginner.logout();
    logger.info("Successfully logged out");
  }
}