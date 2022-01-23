package com.automation.framework.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Factory extends LoginPage {

    public static final String SIGNUP_CSS = "a[href='/login']";
    @FindBy(css = SIGNUP_CSS)
    public WebElement signUp;


    public static final String USERNAME_CSS = "input[data-qa='login-email']";
    @FindBy(css = USERNAME_CSS)
    public WebElement username;

    public static final String PASSWORD_NAME = "password";
    @FindBy(name = PASSWORD_NAME)
    public WebElement password;

    public static final String LOGIN_CSS = "button[data-qa='login-button']";
    @FindBy(css = LOGIN_CSS)
    public WebElement login;

    public static final String USER_LOGOUT_CSS = "a[href='/logout']";
    @FindBy(css = USER_LOGOUT_CSS)
    public WebElement userLogout;

    public Factory(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

}