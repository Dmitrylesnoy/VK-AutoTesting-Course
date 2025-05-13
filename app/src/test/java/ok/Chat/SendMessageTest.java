package ok.Chat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class SendMessageTest extends OpenChatTest {

    @ParameterizedTest
    @Tag("Messaging")
    @MethodSource("ok.utils.TestDataProvider#provideMessages")
    @DisplayName("Test sending a message in chat")
    public void sendMessage(String message) {
        feedPage.clickChat();
        feedPage.validateChatElements();
        feedPage.sendMessage(message);
        logger.info("Message sent: " + message);
    }

    @AfterEach
    public void end() {
        loginner.logout();
    }
}