package org.example.okmsger.utils;

import com.codeborne.selenide.Selenide;

import java.util.logging.Logger;

import org.example.okmsger.pages.MainPage;

public class Loginner {
    private final MainPage mainPage;
    private static final Logger logger = Logger.getLogger(MainPage.class.getName());


    public Loginner() {
        mainPage = Navigator.openMainPage();
    }
    
    public boolean login(String email, String password) {
        try {
            mainPage.isLoaded();
            logger.info("Attempting login with email: " + email);
            mainPage.setEmail(email)
                    .setPassword(password)
                    .loginClick();
            Selenide.Wait().until(driver -> driver.getCurrentUrl().contains(mainPage.getUrl()));
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
