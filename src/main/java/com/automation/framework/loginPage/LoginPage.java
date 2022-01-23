package com.automation.framework.loginPage;

import com.automation.framework.tools.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static com.automation.framework.loginPage.Factory.*;

public class LoginPage {
    public WebDriver driver;
    public Factory elements;
    public Interactions interactions;

    //Create a Constructor for and use it inside the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elements = new Factory(driver);
        this.interactions = new Interactions(driver);
    }

    public LoginPage() {
        PageFactory.initElements(driver, this
        );
    }
    public void signUp(){interactions.actionClick(By.cssSelector(SIGNUP_CSS));
    }

    public void username(String username) {
        interactions.sendKeys(elements.username,
                By.cssSelector(USERNAME_CSS),
                username);
    }
    public void password(String password) {
        interactions.sendKeys(elements.password,
                By.name(PASSWORD_NAME),
                password);
    }
    public void login() {
        interactions.click(elements.login,
                By.cssSelector(LOGIN_CSS));
    }

    public void userLogout() {
        interactions.actionClick(
                By.cssSelector(USER_LOGOUT_CSS));
    }

}