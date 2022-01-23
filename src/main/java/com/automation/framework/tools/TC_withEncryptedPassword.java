package com.automation.framework.tools;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class TC_withEncryptedPassword {

    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.automationexercise.com/");



        driver.findElement(By.cssSelector("a[href='/login']")).sendKeys("ferko");
        driver.findElement(By.cssSelector("kferko#1!sek$")).sendKeys(decodedString(""));
        driver.findElement(By.cssSelector("a[href='/logout']")).click();

    }

    static String decodedString(String password) {
        byte[] decodedString = Base64.decodeBase64(password);
        return (new String(decodedString));

    }

}