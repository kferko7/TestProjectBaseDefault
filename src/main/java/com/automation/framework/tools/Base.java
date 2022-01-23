package com.automation.framework.tools;

import com.automation.framework.homePage.HomePage;
import com.automation.framework.loginPage.LoginPage;
import org.apache.commons.codec.binary.Base64;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public String systemUnderTest;
    public String username;
    public String password;
    public SoftAssert softAssert;
    public static WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;

    @BeforeSuite
    public void loaIndGlobalVariables() throws IOException {
        Properties properties = new Properties();
        String pathToGlobalVariables = "/home/ferko/Desktop/IntelljProjects/testProject/globalproperties.properties";
        FileInputStream fileInputStream = new FileInputStream(pathToGlobalVariables);
        properties.load(fileInputStream);
        systemUnderTest = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");

    }
    @Parameters({"browser"})
    @BeforeMethod
    public WebDriver prepareTests(@Optional("chrome") String browser) throws IOException {
        //System.out.println(WebDriverManager.chromedriver().getDriverVersions());

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            System.out.println(WebDriverManager.chromedriver().getDownloadedDriverVersion());
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);

        }
        if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://");
        loginPage = new LoginPage(driver);
        loginPage.username("k.ferko@shoecarnival.loyaltydev");

        //loginPage.password(username);
        driver.findElement(By.id("password")).sendKeys(decodedString());
        homePage = new HomePage(driver);
        loginPage.login();
        softAssert = new SoftAssert();
        return driver;

    }
    static String decodedString() {
        byte[] decodedString = Base64.decodeBase64("S2YyNTA1ODAhYmVzdA==");
        return (new String(decodedString));


    }

    public String takeScreenshot(String testName,WebDriver driver) throws IOException {
        File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + ".png";
        FileUtils.copyFile(SourceFile, new File(destinationFilePath));
        return destinationFilePath;
    }
    @AfterMethod
    public void terminateDriver(){
        driver.quit();
        //driver.close();

    }

}