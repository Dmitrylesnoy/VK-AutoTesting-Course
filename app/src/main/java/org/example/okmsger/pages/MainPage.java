package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

import org.openqa.selenium.By;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage extends Page {
    private final SelenideElement email_inp = $(By.cssSelector("input[name='st.email']"));
    private final SelenideElement password_inp = $(By.cssSelector("input[name='st.password']"));
    private final SelenideElement login_btn = $(By.cssSelector("input[data-l='t,sign_in']"));

    private final SelenideElement profile_menu = $(By.cssSelector("//*[@id=\"hook_Block_ToolbarUserDropdown\"]/div/button"));
    private final SelenideElement logout_btn = $(By.cssSelector("a[data-l='t,logout']"));

    private final SelenideElement forgotButton = $(By.xpath("//a[@data-l='t,restore']"));
    private final SelenideElement downHelpButton = $(By.xpath("//a[text()='Помощь']"));
    private final String URL = "https://ok.ru/";

    @Override
    public String getUrl() {
        return URL;
    }

    @Override
    public MainPage open() {
        logger.info("Opening main page: " + URL);
        Selenide.open(URL);
        isLoaded();
        return this;
    }

    @Override
    public void isLoaded() {
        logger.info("Checking if MainPage is loaded");
        webdriver().shouldHave(url(URL));
        validatePageElements();
    }

    public boolean isHaveHelpButton() {
        boolean isDisplayed = forgotButton.shouldBe(visible).isDisplayed();
        logger.info("Checking if help button is displayed: " + isDisplayed);
        return isDisplayed;
    }

    public MainPage clickForgotButton() {
        logger.info("Clicking forgot button");
        forgotButton.shouldBe(visible).click();
        return this;
    }

    public MainPage clickHelpButton() {
        logger.info("Clicking help button");
        downHelpButton.shouldBe(visible).click();
        return this;
    }

    public MainPage setEmail(String email) {
        logger.info("Setting email: " + email);
        email_inp.shouldBe(visible).setValue(email);
        return this;
    }

    public MainPage setPassword(String password) {
        logger.info("Setting password");
        password_inp.shouldBe(visible).setValue(password);
        return this;
    }

    public void loginClick() {
        logger.info("Clicking login button");
        login_btn.shouldBe(visible).click();
    }

    public MainPage profileClick() {
        logger.info("Clicking profile menu");
        profile_menu.shouldBe(visible).click();
        return this;
    }

    public void logoutClick() {
        logger.info("Clicking logout button");
        logout_btn.shouldBe(visible).click();
    }

    public void validatePageElements() {
        logger.info("Validating login page elements");
        email_inp.shouldBe(visible);
        logger.info("Email input is correct");
        password_inp.shouldBe(visible);
        logger.info("Password input is correct");
        login_btn.shouldBe(visible);
        logger.info("Login button is correct");
        forgotButton.shouldBe(visible);
        logger.info("Forgot button is correct");
        downHelpButton.shouldBe(visible);
        logger.info("Help button is correct");
        logger.info("All login page elements are visible");
    }

    public void validatePostLoginElements() {
        logger.info("Validating post-login page elements");
        profile_menu.shouldBe(visible);
        logger.info("Profile menu is correct");
        logout_btn.shouldBe(visible);
        logger.info("Logout button is correct");
        logger.info("All post-login elements are visible");
    }
}