package org.example.okmsger.utils;

import org.example.okmsger.pages.MainPage;
import org.example.okmsger.pages.RecoveryPage;
import org.example.okmsger.pages.SearchPage;
import org.example.okmsger.pages.FeedPage;
import org.example.okmsger.pages.HelpPage;

import java.util.logging.Logger;

public class Navigator {
    private static final Logger logger = Logger.getLogger(Navigator.class.getName());

    public static MainPage openMainPage() {
        logger.info("Navigating to MainPage");
        return new MainPage().open();
    }

    public static RecoveryPage openRecoveryPage() {
        logger.info("Navigating to RecoveryPage");
        return new RecoveryPage().open();
    }

    public static SearchPage openSearchPage() {
        logger.info("Navigating to SearchPage");
        return new SearchPage().open();
    }

    public static FeedPage openFeedPage() {
        logger.info("Navigating to FeedPage");
        return new FeedPage().open();
    }

    public static HelpPage openHelpPage() {
        logger.info("Navigating to HelpPage");
        return new HelpPage().open();
    }
}