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

    public static final String PASSWORD_ID = "password";
    @FindBy(id = PASSWORD_ID)
    public WebElement password;

    public static final String LOGIN_CSS = "#Login";
    @FindBy(css = LOGIN_CSS)
    public WebElement login;

    public static final String DRP_UI_IMAGE_XPATH = "//button/div/span/div/span";
    @FindBy(xpath = DRP_UI_IMAGE_XPATH)
    public WebElement drpUiImage;

    public static final String DEV_USER_LOGOUT_CSS = ".logout";
    @FindBy(css = DEV_USER_LOGOUT_CSS)
    public WebElement devUserLogout;

    public Factory(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

}