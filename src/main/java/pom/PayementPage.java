package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayementPage extends BasePage {
    public PayementPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "#payment-form>div>div>input")
    private List<WebElement> cardDetails;

    @FindBy(id = "cart_info")
    private WebElement confirm;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(id = "#success_message>div.alert")
    private WebElement successMessage;

    public PayementPage fillNameOnCard(String name) {
        waitForElementToBeVisible(cardDetails.get(0));
        waitForElementToBeClickable(cardDetails.get(0));
        cardDetails.get(0).click();
        cardDetails.get(0).sendKeys(name);
        return this;
    }


    public PayementPage fillCardNumber(String cardNumber) {
        waitForElementToBeVisible(cardDetails.get(1));
        cardDetails.get(1).click();
        cardDetails.get(1).sendKeys(cardNumber);
        return this;
    }

    public PayementPage fillCVV(String name) {
        waitForElementToBeVisible(cardDetails.get(2));
        cardDetails.get(2).click();
        cardDetails.get(2).sendKeys(name);
        return this;
    }

    public PayementPage fillExpMonth(String expDate) {
        waitForElementToBeVisible(cardDetails.get(3));
        cardDetails.get(3).click();
        cardDetails.get(3).sendKeys(expDate);
        return this;
    }

    public PayementPage fillExpYear(String expDate) {
        waitForElementToBeVisible(cardDetails.get(4));
        cardDetails.get(4).click();
        cardDetails.get(4).sendKeys(expDate);
        return this;
    }

    public PayementPage clickOnSubmitButton() {
        waitForElementToBeClickable(submitButton);
        submitButton.click();
        return this;
    }

    public String getSuccessMessage() {
        waitForElementToBeVisible(successMessage);
        return successMessage.getText();
    }
}
