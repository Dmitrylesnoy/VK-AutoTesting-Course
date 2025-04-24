package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage extends Page {
    private final SelenideElement email_inp = $("input[name='st.email']");
    private final SelenideElement password_inp = $("input[name='st.password']");
    private final SelenideElement login_btn = $("input[data-l='t,sign_in']");

    private final SelenideElement profile_menu = $("//*[@id=\"hook_Block_ToolbarUserDropdown\"]/div/button");
    private final SelenideElement logout_btn = $("a[data-l='t,logout']");

    private final SelenideElement forgotButton = $(By.xpath("//a[@data-l='t,restore']"));
    private final SelenideElement downHelpButton = $(By.xpath("//a[text()='Помощь']"));
    private final String URL = "https://ok.ru/";

    public boolean isHaveHelpButton() {
        boolean isDisplayed = $(forgotButton).isDisplayed();
        logger.info("Checking if help button is displayed: " + isDisplayed);
        return isDisplayed;
    }

    public MainPage clickForgotButton() {
        logger.info("Clicking forgot button");
        $(forgotButton).click();
        return this;
    }

    public MainPage clickHelpButton() {
        logger.info("Clicking help button");
        $(downHelpButton).click();
        return this;
    }

    public String getUrl() {
        return URL;
    }

    public MainPage open() {
        logger.info("Opening main page: " + URL);
        Selenide.open(URL);
        // webdriver().shouldHave(url(URL));
        validatePageElements();
        return this;
    }

    public MainPage setEmail(String email) {
        logger.info("Setting email: " + email);
        $(email_inp).setValue(email);
        return this;
    }

    public MainPage setPassword(String password) {
        logger.info("Setting password");
        $(password_inp).setValue(password);
        return this;
    }

    public void loginClick() {
        logger.info("Clicking login button");
        $(login_btn).shouldBe(visible).click();
    }

    public MainPage profileClick() {
        logger.info("Clicking profile menu");
        SelenideElement element = $(profile_menu);
        logger.info("Profile menu element found: " + element.isDisplayed());
        element.shouldBe(visible).click();
        return this;
    }

    public void logoutClick() {
        logger.info("Clicking logout button");
        $(logout_btn).shouldBe(visible).click();
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
        logger.info("Help button is visiblecorrect");
        logger.info("All login page elements are visible");
    }

    public void validatePostLoginElements() {
        $(profile_menu).shouldBe(visible);
        logger.info("Profile menu is correct");
        $(logout_btn).shouldBe(visible);
        logger.info("Logout button is correct");
        logger.info("All post-login elements are visible");
    }
}