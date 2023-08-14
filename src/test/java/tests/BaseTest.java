package tests;

import drivers.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    public static WebDriver driver = driverFactory.createWebDriver("chrome");
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();


    @BeforeMethod
    public void setup() {
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public static synchronized WebDriver getDriver() {
        return driver;
    }

}
