package org.example.okmsger.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MainPage implements Page {
    private final SelenideElement email_inp = $("input[name='st.email']");
    private final SelenideElement password_inp = $("input[name='st.password']");
    private final SelenideElement login_btn = $("input[data-l='t,sign_in']");

    private final SelenideElement profile_menu = $("//*[@id=\"hook_Block_ToolbarUserDropdown\"]/div/button");
    private final SelenideElement logout_btn = $("a[data-l='t,logout']");

    private final SelenideElement forgotButton = $(byXpath("//a[@data-l='t,restore']"));
    private final SelenideElement downHelpButton = $(byXpath("//a[text()='Помощь']"));
    private final String URL = "https://ok.ru/";

    public boolean isHaveHelpButton() {
        return forgotButton.isDisplayed();
    }

    public MainPage clickForgotButton() {
        forgotButton.click();
        return this;
    }

    public MainPage clickHelpButton() {
        downHelpButton.click();
        return this;
    }

    public String getUrl() {
        return URL;
    }

    public MainPage open() {
        Selenide.open(URL);
        return this;
    }

    public MainPage setEmail(String email) {
        email_inp.setValue(email);
        return this;
    }
    
    public MainPage setPassword(String password) {
        password_inp.setValue(password);
        return this;
    }

    public void loginClick(){ login_btn.shouldBe(visible).click();}

    public MainPage profileClick() {
        profile_menu.click();
        return this;
    }

    public void logoutClick() { logout_btn.shouldBe(visible).click();
    }

}
