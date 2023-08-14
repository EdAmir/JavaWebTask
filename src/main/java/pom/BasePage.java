package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class BasePage {
    private static final int TIMEOUT = 45;
    public WebDriver driver;
    Logger logger = Logger.getLogger(String.valueOf(BasePage.class));

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not clickable");
        }
    }

    private void pageReadyStateToComplete() {
        forceWait(200);
        ExpectedCondition<Boolean> pageLoadCondition = driver -> (boolean) ((JavascriptExecutor) driver)
                .executeScript("return document.readyState == 'complete'");
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(pageLoadCondition);
        } catch (WebDriverException e) {
            throw new WebDriverException("Page is not loaded");
        }
    }

    protected void waitForElementToBeVisible(WebElement element) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not visible");
        }
    }

    private void ajaxJquery() {
        forceWait(200);
        ExpectedCondition<Boolean> pageLoadCondition = driver -> (boolean) ((JavascriptExecutor) driver)
                .executeScript("return window.jQuery == undefined ? true : window.jQuery.active == 0");
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(pageLoadCondition);
        } catch (WebDriverException e) {
            throw new WebDriverException("Page is not loaded");
        }
    }

    public void waitForPageToLoad() {
        pageReadyStateToComplete();
        ajaxJquery();
    }

    protected void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }


    protected void unHighlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
    }

    protected void forceWait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void click(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(element);
        element.click();
        logger.info("Element " + element.getText() + " is clicking...");
        unHighlightElement(element);
    }

    protected void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    protected void scroll(int pixel) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, " + pixel + ");");
    }

    protected void type(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text, Keys.ENTER);
    }

    protected void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

}
