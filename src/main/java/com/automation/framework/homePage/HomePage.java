package com.automation.framework.homePage;
import com.automation.framework.tools.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static com.automation.framework.homePage.Factory.*;

public class HomePage {
    public WebDriver driver;
    public Factory elements;
    public Interactions interactions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elements = new Factory(driver);
        this.interactions = new Interactions(driver);
    }

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public void icon_Nav_Menu() {interactions.click(elements.icon_Nav_Menu);
    }
    //public void home(){interactions.actionClick(By.xpath(HOME_XPATH));}
}