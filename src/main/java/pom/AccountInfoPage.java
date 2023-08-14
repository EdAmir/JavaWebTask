package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class AccountInfoPage extends BasePage {
    public AccountInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    private WebElement titleMen;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(id = "newsletter")
    private WebElement newsLetter;
    @FindBy(id = "optin")
    private WebElement specialOffers;
    @FindBy(id = "company")
    private WebElement company;
    @FindBy(css = ".login-form>form>button")
    private WebElement createAccount;
    @FindBy(css = ".login-form>h2")
    private WebElement info;


    @FindBy(css = ".required>input[type='Text']")
    private List<WebElement> accountInfoElements;


    public AccountInfoPage chooseTitleMen() {
        titleMen.click();
        return this;
    }

    public AccountInfoPage selectNewsLetter() {
        scroll(800);
        click(newsLetter);
        return this;
    }

    public AccountInfoPage selectSpecialOffers() {
        specialOffers.click();
        return this;
    }

    public AccountInfoPage fillPassword(String string) {
        password.sendKeys(string);
        return this;
    }

    public AccountInfoPage chooseDay(String day) {
        List<WebElement> element = driver.findElements(By.cssSelector("#days > option"));
        for (WebElement option : element
        ) {
            if (option.getText().contains(day)) {
                option.click();
                break;
            }
        }
        return this;
    }

    public AccountInfoPage chooseMonth(String month) {
        List<WebElement> element = driver.findElements(By.cssSelector("#months > option"));
        for (WebElement option : element) {
            if (option.getText().contains(month)) {
                option.click();
                break;
            }
        }
        return this;
    }

    public AccountInfoPage chooseYear(String year) {
        List<WebElement> element = driver.findElements(By.cssSelector("#years > option"));
        for (WebElement option : element
        ) {
            if (option.getText().contains(year)) {
                option.click();
                break;
            }
        }
        return this;
    }

    public AccountInfoPage setDateOfBirth(String day, String month, String year) {
        chooseDay(day);
        chooseMonth(month);
        chooseYear(year);
        return this;
    }

    public boolean getInfo() {
        return info.isDisplayed();
    }

    public AccountInfoPage fillFirstName(String firstName) {
        click(accountInfoElements.get(2));
        accountInfoElements.get(2).sendKeys(firstName);
        return this;
    }

    public AccountInfoPage fillLastName(String lastName) {
        click(accountInfoElements.get(3));
        accountInfoElements.get(3).sendKeys(lastName);
        return this;
    }

    public AccountInfoPage fillCompany(String company) {
        scroll(800);
        click(this.company);
        this.company.sendKeys(company);
        return this;
    }

    public AccountInfoPage fillAddress(String address) {
        click(accountInfoElements.get(4));
        accountInfoElements.get(4).sendKeys(address);
        return this;
    }

    public AccountInfoPage fillAddress2(String address) {
        click(accountInfoElements.get(5));
        accountInfoElements.get(5).sendKeys(address);
        return this;
    }

    public AccountInfoPage fillState(String state) {
        scroll(1200);
        click(accountInfoElements.get(6));
        accountInfoElements.get(6).sendKeys(state);
        return this;
    }

    public AccountInfoPage fillCity(String city) {
        click(accountInfoElements.get(7));
        accountInfoElements.get(7).sendKeys(city);
        return this;
    }

    public AccountInfoPage fillZipcode(String zipCode) {
        click(accountInfoElements.get(8));
        accountInfoElements.get(8).sendKeys(zipCode);
        return this;
    }

    public AccountInfoPage fillMobileNumber(String mobileNumber) {
        click(accountInfoElements.get(9));
        accountInfoElements.get(9).sendKeys(mobileNumber);
        return this;
    }

    public AccountPage createAccount() {
        createAccount.click();
        return new AccountPage(driver);
    }
}
