package drivers;

import org.openqa.selenium.WebDriver;

public class driverFactory {
    public static WebDriver createWebDriver(String driver) {
        if (driver == "firefox") {
            return SingletonFirefoxDriver.getFirefoxDriver();
        } else
            return SingletonChromeDriver.getChromeDriver();
    }
}
