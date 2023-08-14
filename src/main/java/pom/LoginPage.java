package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".signup-form>form>input")
    private List<WebElement> signupFormElements;
    @FindBy(css = ".signup-form>form>button")
    private WebElement signup;
    @FindBy(css = ".login-form>form>input")
    private List<WebElement> loginFormElements;

    @FindBy(css = ".login-form>form>button")
    private WebElement loginButton;


    public LoginPage fillName(String name) {
        click(signupFormElements.get(1));
        signupFormElements.get(1).sendKeys(name);
        return this;
    }

    public LoginPage fillEmail(String email) {
        signupFormElements.get(2).click();
        signupFormElements.get(2).sendKeys(email);
        return this;
    }

    public LoginPage fillUserEmail(String eserEmail) {
        click(loginFormElements.get(1));
        loginFormElements.get(1).sendKeys(eserEmail);
        return this;
    }

    public LoginPage fillUserPassword(String password) {
        click(loginFormElements.get(2));
        loginFormElements.get(2).sendKeys(password);
        return this;
    }

    public AccountInfoPage signupClick() {
        signup.click();
        return new AccountInfoPage(driver);
    }

    public boolean isSignupButtonDisplayed() {
        waitForPageToLoad();
        return signup.isDisplayed();
    }

    public HomePage clickOnLogginButton() {
        waitForElementToBeClickable(loginButton);
        loginButton.click();
        return new HomePage(driver);
    }


}
