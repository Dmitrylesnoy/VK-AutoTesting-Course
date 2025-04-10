package org.example.okmsger.utils;

import com.codeborne.selenide.Selenide;
import org.example.okmsger.pages.MainPage;

public class Loginner {
    private final MainPage mainPage;

    public Loginner() {
        mainPage = new MainPage();
        mainPage.open();
    }
    
    public boolean login(String email, String password) {
        try {
            mainPage.setEmail(email)
                    .setPassword(password)
                    .loginClick();
            Selenide.Wait().until(driver -> !driver.getCurrentUrl().contains(mainPage.getUrl()));
            return true;
        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
            return false;
        }
    }
    
    public boolean logout() {
        try {
            mainPage.profileClick()
                .logoutClick();
            Selenide.Wait().until(driver -> driver.getCurrentUrl().contains(mainPage.getUrl()));
            return true;
        } catch (Exception e) {
            System.err.println("Logout failed: " + e.getMessage());
            return false;
        }
    }
}
