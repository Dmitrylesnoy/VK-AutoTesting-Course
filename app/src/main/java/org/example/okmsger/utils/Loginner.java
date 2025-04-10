package org.example.okmsger.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class Loginner {
    
    // Login page elements
    private static final String LOGIN_PAGE_URL = "https://ok.ru";
    private static final SelenideElement EMAIL_INPUT = $("input[name='st.email']");
    private static final SelenideElement PASSWORD_INPUT = $("input[name='st.password']");
    private static final SelenideElement LOGIN_BUTTON = $("input[data-l='t,sign_in']");
    
    // Logout elements
    private static final SelenideElement PROFILE_MENU = $("div[data-l='t,userPage']");
    private static final SelenideElement LOGOUT_BUTTON = $("a[data-l='t,logout']");
    
    /**
     * Logs in to ok.ru with provided credentials
     * @param email User email/phone
     * @param password User password
     * @return true if login successful, false otherwise
     */
    public static boolean login(String email, String password) {
        try {
            // Open login page
            Selenide.open(LOGIN_PAGE_URL);
            
            // Fill credentials
            EMAIL_INPUT.shouldBe(visible).setValue(email);
            PASSWORD_INPUT.shouldBe(visible).setValue(password);
            
            // Click login button
            LOGIN_BUTTON.shouldBe(visible).click();
            
            // Verify login success by checking if we're redirected from login page
            Selenide.Wait().until(driver -> !driver.getCurrentUrl().contains("ok.ru"));
            return true;
        } catch (Exception e) {
            System.err.println("Login failed: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Logs out from ok.ru account
     * @return true if logout successful, false otherwise
     */
    public static boolean logout() {
        try {
            // Open profile menu
            PROFILE_MENU.shouldBe(visible).click();
            
            // Click logout button
            LOGOUT_BUTTON.shouldBe(visible).click();
            
            // Verify logout by checking if we're back to login page
            Selenide.Wait().until(driver -> driver.getCurrentUrl().contains("ok.ru"));
            return true;
        } catch (Exception e) {
            System.err.println("Logout failed: " + e.getMessage());
            return false;
        }
    }
}
