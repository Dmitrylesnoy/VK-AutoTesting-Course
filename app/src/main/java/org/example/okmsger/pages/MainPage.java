package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.example.okmsger.utils.WebElementWrapper;
import org.openqa.selenium.By;

public class MainPage extends Page {
    private static final By email_inp = By.cssSelector("input[name='st.email']");
    private static final By password_inp = By.cssSelector("input[name='st.password']");
    private static final By login_btn = By.cssSelector("input[data-l='t,sign_in']");
    private static final By profile_menu = By.xpath("//*[@id='hook_Block_ToolbarUserDropdown']/div/button");
    private static final By logout_btn = By.cssSelector("a[data-l='t,logout']");
    private static final By forgotButton = By.xpath("//a[@data-l='t,restore']");
    private static final By downHelpButton = By.xpath("//a[text()='Помощь']");
    private static final String URL = "https://ok.ru/";

    public MainPage clickForgotButton() {
        new WebElementWrapper(forgotButton, "Forgot button").click();
        return this;
    }

    public MainPage clickHelpButton() {
        new WebElementWrapper(downHelpButton, "Down help button").click();
        return this;
    }

    public MainPage setEmail(String email) {
        new WebElementWrapper(email_inp, "email input").setValue(email);
        return this;
    }

    public MainPage setPassword(String password) {
        new WebElementWrapper(password_inp, "password input").setValue(password);
        return this;
    }

    public MainPage loginClick() {
        new WebElementWrapper(login_btn, "login button").click();
        return this;
    }

    public MainPage profileClick() {
        new WebElementWrapper(profile_menu, "profile menu").click();
        return this;
    }

    public MainPage logoutClick() {
        new WebElementWrapper(login_btn, "Logout button").click();
        return this;
    }

    public void validatePageElements() {
        logger.info("Validating login page elements");
        $(email_inp).shouldBe(visible);
        logger.info("Email input is correct");
        $(password_inp).shouldBe(visible);
        logger.info("Password input is correct");
        $(login_btn).shouldBe(visible);
        logger.info("Login button is correct");
        $(forgotButton).shouldBe(visible);
        logger.info("Forgot button is correct");
        $(downHelpButton).shouldBe(visible);
        logger.info("Help button is correct");
        logger.info("All login page elements are visible");
    }

    public void validatePostLoginElements() {
        logger.info("Validating post-login page elements");
        $(profile_menu).shouldBe(visible);
        logger.info("Profile menu is correct");
        $(logout_btn).shouldBe(hidden);
        logger.info("Logout button is correct");
        logger.info("All post-login elements are visible");
    }
}