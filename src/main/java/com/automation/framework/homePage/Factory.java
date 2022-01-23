package com.automation.framework.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Factory extends HomePage{

    public static final String ICON_NAV_MENU_XPATH = "//div[3]/div/button/lightning-primitive-icon";
    @FindBy(xpath = ICON_NAV_MENU_XPATH)
    public WebElement icon_Nav_Menu;

    public static final String HOME_XPATH = "//span[contains(text(),'Home')]";
    @FindBy(xpath = HOME_XPATH)
    public WebElement home;

    public static final String MARK_CHECKBOXES_XPATH = " //div[@data-component-id='loyaltyHomePage_loyaltyPromotionList']//thead//label//span[1]";

    public Factory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
