package com.automation.framework.tools;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Interactions {

    public WebDriver driver;
    public WebDriverWait wait;
    int MAX_NUMBER_OF_LOOP_ATTEMPTS = 10;
    private By locator;

    public Interactions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);

    }
    /**Call this method from HomePage*/
    public void click(WebElement webElement) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();

    }

    public void click(WebElement webElement, By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        webElement.click();

    }
    /**
     * This method allows avoiding Duplicates
     */
    public void sendKeys(WebElement webElement, By by, String keysToSend) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        int loopNumber = 0;

        while (loopNumber <= MAX_NUMBER_OF_LOOP_ATTEMPTS) {
            loopNumber++;
            webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            webElement.sendKeys(keysToSend);
            if (webElement.getAttribute("value").equals(keysToSend)) {
                break;
            }

        }

    }
    public void goBack() {
        driver.navigate().back();
    }

    public String getWindowHandle(WebElement webElement) {
        return driver.getWindowHandle();
    }
    public Set<String> getWindowHandles(WebElement webElement) {
        return driver.getWindowHandles();
    }
    public int getNumberOfOpenWindows() {
        return driver.getWindowHandles().size();
    }
    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }
    public void goToUrl(String url) {
        driver.get(url);
    }
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Wait for alert present and then switch to it
     */
    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }
    public void hoverOverElement(By locator) {
        this.locator = locator;
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    /**
     * Perform Action Move to Element Single click
     */
    public void actionClick(By by) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).click()
                .build().perform();
    }
    /**
     * Perform DoubleClick
     */
    public void doubleClick(By by) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Actions action_move = new Actions(driver);
        action_move.moveToElement(driver.findElement(by)).doubleClick()
                .build().perform();
    }
    /**
     * Method to Assert text is displayed
     */

    public void highLighterMethod(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /**Js executor all*/
    public void jsExecute(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
    /**
     * Perform scroll to the bottom
     */
    public void scrollToBottom() {
        System.out.println("Scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void scrollElementIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Scrolls the document by the specified number of pixels.
     *
     * @param x How many pixels to scroll by, along the x-axis (horizontal).
     * @param y How many pixels to scroll by, along the y-axis (vertical).
     */
    public void scrollPage(int x, int y) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(" + x + "," + y + ");");
    }
    /**
     *
     * @param frame The index of the frame to switch to (first frame has index 0)
     */
    public void switchFrames(int frame) {
        driver.switchTo().frame(frame);
    }
    /**Switch To Default Frame*/
    public void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }
    /**Set Cookie*/
    public void setCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        driver.manage().addCookie(cookie);
    }
    /**Get Cookie*/
    public Cookie getCookie(String name) {
        return driver.manage().getCookieNamed(name);
    }

    //@Override
    public boolean findElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            final var eleDisplayed = ele.isDisplayed();
            flag = true;
        } catch (Exception e) {
            // System.out.println("Location not found: "+locatorName);
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully Found element at");

            } else {
                System.out.println("Unable to locate element at");
            }
        }
        return flag;
    }
    //@Override
    public boolean isSelected(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isSelected();
            if (flag) {
                System.out.println("The element is Selected");
            } else {
                System.out.println("The element is not Selected");
            }
        } else {
            System.out.println("Not selected ");
        }
        return flag;
    }
    /**
     * select value from DropDown by using selectByIndex
     *
     * @param element     : Action to be performed on element (Get it from Object
     *                    repository)
     *
     * @param index       : Index of value wish to select from dropdown list.
     *
     */
    //@Override
    public boolean selectByIndex(WebElement element, int index) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByIndex(index);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by Index");
            } else {
                System.out.println("Option not selected by Index");
            }
        }
    }

    /**
     * select value from DD by using value
     *
     * @param element     : Action to be performed on element (Get it from Object
     *                    repository)
     *
     * @param value       : Value wish to select from dropdown list.
     *
     */

    //@Override
    public boolean selectByValue(WebElement element, String value) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByValue(value);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by Value");
            } else {
                System.out.println("Option not selected by Value");
            }
        }
    }

    /**
     * select value from DropDown by using selectByVisibleText
     *  @param ele     : Action to be performed on element (Get it from Object
     *                    repository)
     *
     *
     *
     */

    //@Override
    public boolean selectByVisibleText(WebElement ele) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            String visibletext = null;
            s.selectByVisibleText(visibletext);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                System.out.println("Option selected by VisibleText");
            } else {
                System.out.println("Option not selected by VisibleText");
            }
        }
    }

}


