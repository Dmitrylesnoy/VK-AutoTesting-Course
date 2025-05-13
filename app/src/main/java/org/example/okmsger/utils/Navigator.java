package org.example.okmsger.utils;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import java.time.Duration;
import java.util.logging.Logger;

public class Navigator {
    private static final Logger logger = Logger.getLogger(Navigator.class.getName());

    public static void openUrl(String URL) {
        try {
            open(URL);
            // Selenide.open(URL);
            checkUrl(URL);
            logger.info("Opened url: " + URL);
        } catch (Exception e) {
            e.getStackTrace();
            logger.warning(e.toString());
        }
    }

    public static boolean checkUrl(String URL) {
        webdriver().shouldHave(url(URL), Duration.ofSeconds(5));
        return true;
    }

    public static String getUrl() {
        return webdriver().driver().getCurrentFrameUrl();
    }

    public static boolean isUrlEquals(String url1, String url2) {
        String cleanUrl1 = url1.toLowerCase()
                .replaceFirst("^https?://(www\\.)?", "")
                .split("[?#]")[0]
                .replaceAll("/$", "");
        String cleanUrl2 = url2.toLowerCase()
                .replaceFirst("^https?://(www\\.)?", "")
                .split("[?#]")[0]
                .replaceAll("/$", "");

        return cleanUrl1.equals(cleanUrl2);
    }
}
