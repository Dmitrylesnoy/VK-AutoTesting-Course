import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.okmsger.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OpenMessagePageTest {
  private MainPage mainPage;

  @BeforeEach
  public void setUp() {
    browser = "chrome";
    mainPage = new MainPage();
  }

  @AfterEach
  public void tearDown() {
    closeWebDriver();
  }

  @Test
  public void openMessagePage() {
    mainPage.open()
        .clickLogo()
        .clickMessagesButton()
        .verifyChatWindowIsOpened();
    assertTrue(mainPage.getChatWindow().isDisplayed());
  }
}