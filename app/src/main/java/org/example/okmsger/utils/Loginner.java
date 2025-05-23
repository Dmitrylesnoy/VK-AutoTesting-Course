package org.example.okmsger.utils;

import com.codeborne.selenide.Selenide;
import org.example.okmsger.pages.MainPage;
import java.util.logging.Logger;

public class Loginner {
    private static final MainPage mainPage = new MainPage();
    private static final Logger logger = Logger.getLogger(Loginner.class.getName());

    public Loginner() {
        // mainPage = new MainPage();
    }

    public boolean login() {
        return login(new UserCredentials(System.getenv("OK_NAME"), System.getenv("OK_PASSWORD")));
    }

    public boolean login(UserCredentials credentials) {
        try {
            mainPage.open();
            logger.info("Attempting login with email: " + credentials.getEmail());
            mainPage.setEmail(credentials.getEmail())
                    .setPassword(credentials.getPassword())
                    .loginClick();
            Selenide.Wait().until(driver -> driver.getCurrentUrl().contains(mainPage.getUrl()));
            mainPage.validatePostLoginElements();
            logger.info("Login successful, redirected to feed page");
            return true;
        } catch (Exception e) {
            logger.severe("Login failed: " + e.getMessage());
            logger.severe("Current URL: " + Selenide.webdriver().driver().getCurrentFrameUrl());
            return false;
        }
    }

    public boolean logout() {
        try {
            mainPage.open();
            logger.info("Attempting logout");
            mainPage.profileClick()
                    .logoutClick();
            Selenide.Wait().until(driver -> driver.getCurrentUrl().contains(mainPage.getUrl()));
            logger.info("Logout successful");
            return true;
        } catch (Exception e) {
            logger.severe("Logout failed: " + e.getMessage());
            return false;
        }
    }
}