package org.example.okmsger.utils;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import java.time.Duration;
import java.util.logging.Logger;

import com.codeborne.selenide.Selenide;
public class Navigator {
    private static final Logger logger = Logger.getLogger(Navigator.class.getName());

    public static void openUrl(String URL) {
        Selenide.open(URL);
        checkUrl(URL);
        logger.info("Opened url: " + URL);
    }

    public static boolean checkUrl(String URL) {
        webdriver().shouldHave(url(URL), Duration.ofSeconds(5));
        return true;
        // return WebDriverRunner.url().contains(URL);
    }
}
