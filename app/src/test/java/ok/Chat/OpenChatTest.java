package ok.Chat;

import org.example.okmsger.pages.FeedPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ok.Login.LoginTest;

public class OpenChatTest extends LoginTest {
    protected FeedPage feedPage;

    @BeforeEach
    public void setUpChat() {
        feedPage = new FeedPage();
        // Page page = PageFactory.createCurrentPage(Navigator.getUrl());
        // assertEquals(FeedPage.class, page.getClass());
        // feedPage = (FeedPage) page;
    }

    @Test
    @Tag("Messaging")
    @DisplayName("Test opening chat dialog")
    public void openChatDialog() {
        feedPage.clickMessagesButton();
        feedPage.checkChatWinrow();
        logger.info("Chat window is visible");
    }
}