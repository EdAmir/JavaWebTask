package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllProductsPage extends BasePage {
    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search_product")
    private WebElement search_product;
    @FindBy(id = ".features_items>h2")
    private WebElement allProductsSection;
    @FindBy(id = ".container>button")
    private WebElement searchButton;
    @FindBy(id = ".features_items>h2")
    private WebElement searchedProductText;
    @FindBy(id = ".features_items>div")
    private List<WebElement> allProducts;

    public boolean isSearchedProductIsVisible() {
        return searchedProductText.isDisplayed();
    }

    public AllProductsPage clickOnSearchButton() {
        click(searchButton);
        return this;
    }

    public boolean isAllProductsVisible() {
        for (WebElement element : allProducts) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public AllProductsPage fillProductName(String productName) {
        click(search_product);
        search_product.clear();
        search_product.sendKeys(productName);
        return this;
    }
}
