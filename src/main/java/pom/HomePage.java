package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a")
    private WebElement loginButton;
    @FindBy(css = ".col-sm-offset-1 > div > h2")
    private WebElement subscription;
    @FindBy(css = ".navbar-nav>li")
    private List<WebElement> navBar;
    @FindBy(css = "#slider-carousel > div > div.item.active > div:nth-child(1) > h2")
    private WebElement slideText;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }

    public boolean isLoggedUserInfoVisible() {
        return navBar.get(9).isDisplayed();
    }

    public AccountPage deleteUser() {
        waitForElementToBeClickable(navBar.get(4));
        navBar.get(4).click();
        return new AccountPage(driver);
    }

    public HomePage scrollDown() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return this;
    }

    public HomePage scrollUp() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0)");

        return this;
    }

    public boolean isDescriptionVisible() {
        waitForElementToBeVisible(subscription);
        return subscription.isDisplayed();
    }

    public boolean isVisible() {
        return navBar.get(0).isDisplayed();

    }


    public AllProductsPage clickProductsButton() {
        click(navBar.get(1));
        return new AllProductsPage(driver);
    }

    public String getSlideText() {
        return slideText.getText();
    }

}
