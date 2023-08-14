package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2>b")
    private WebElement accountStatusInfo;
    @FindBy(css = ".navbar-nav>li:nth-child(10)>a")
    private WebElement userInfo;
    @FindBy(css = ".pull-right>a")
    private WebElement countinue;
    @FindBy(css = ".modal-footer>button")
    private WebElement continueFromModalButton;
    @FindBy(css = ".container>div>div>a")
    private WebElement proceedButton;

    @FindBy(css = ".overlay-content>a")
    private List<WebElement> addToCartButton;
    @FindBy(css = ".productinfo>a")
    private List<WebElement> addToCartButton1;
    @FindBy(css = ".navbar-nav>li")
    private List<WebElement> navBar;
    @FindBy(css = ".checkout-information")
    private WebElement checkoutInfo;
    @FindBy(css = "#cart_items>div>div:nth-child(4)")
    private WebElement reviewOrder;
    @FindBy(css = "#ordermsg>textarea")
    private WebElement messageBox;
    @FindBy(css = "#cart_items>div>div:nth-child(7)>a")
    private WebElement placeOrderButton;

    public String accountCreatedInfo() {
        return accountStatusInfo.getText();
    }

    public boolean accountStatusInfoVisibility() {
        return accountStatusInfo.isDisplayed();
    }

    public HomePage clickContinueButton() {
        countinue.click();
        return new HomePage(driver);
    }

    public boolean isCheckoutInfoVisible() {
        return checkoutInfo.isDisplayed();
    }

    public boolean isReviewOrderInfoVisible() {
        return reviewOrder.isDisplayed();
    }

    public AccountPage clickOnProceedButton() {
        waitForElementToBeVisible(proceedButton);
        proceedButton.click();
        return this;
    }

    public AccountPage clickContinueModalButton() {
        click(continueFromModalButton);
        return this;
    }

    public AccountPage clickOnCartButton() {
        navBar.get(2).click();
        return this;
    }

    public PayementPage clickOnPlaceOrderButton() {
        click(placeOrderButton);
        return new PayementPage(driver);
    }

    public AccountPage addComment(String comment) {
        moveToElement(messageBox);
        messageBox.sendKeys(comment);
        scroll(800);
        return this;
    }


    public AccountPage clickAddToCartButton() {
        scroll(500);
        hover(addToCartButton1.get(0));
        waitForElementToBeClickable(addToCartButton.get(0));
        addToCartButton.get(0).click();
        return this;
    }

    public boolean isContinueButtonVisible() {
        return countinue.isDisplayed();
    }

    public boolean isUserLogged() {
        waitForPageToLoad();
        waitForElementToBeClickable(userInfo);
        return userInfo.isDisplayed();
    }
}
