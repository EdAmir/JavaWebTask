package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.*;

import java.util.Random;

public class RegisterUserTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();
    Random random = new Random();


    @Test
    public void registerUser() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        AccountInfoPage accountInfoPage = new AccountInfoPage(driver);

        softAssert.assertTrue(homePage.isVisible(), "Home page is not displayed");
        homePage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.isSignupButtonDisplayed(), " 'New User Signup!' is not visible");

        loginPage
                .fillName("eduard")
                .fillEmail("edamir" + random.nextInt(1000) + "@gmail.com")
                .signupClick();
        softAssert.assertTrue(accountInfoPage.getInfo(), "'ENTER ACCOUNT INFORMATION' is not visible");

        accountInfoPage
                .chooseTitleMen()
                .fillPassword("4730426Ed")
                .setDateOfBirth("13", "03", "88")
                .selectNewsLetter()
                .selectSpecialOffers()
                .fillFirstName("Eduard")
                .fillLastName("Amirjanyan")
                .fillCompany("GP Morgan")
                .fillAddress("John Doe 123 Main Street New York, NY 12345")
                .fillAddress2("John Doe 123 Main Street Los Angelos, CA 12345")
                .fillState("California")
                .fillCity("Los Angelos")
                .fillZipcode("90012")
                .fillMobileNumber("18175894623")
                .createAccount();
        softAssert.assertTrue(accountPage.accountStatusInfoVisibility());
        softAssert.assertEquals(accountPage.accountCreatedInfo(), "Your order has been placed successfully");
        accountPage.clickContinueButton();
        softAssert.assertTrue(homePage.isLoggedUserInfoVisible());

        homePage.deleteUser();
        softAssert.assertTrue(accountPage.isContinueButtonVisible());
        softAssert.assertTrue(accountPage.accountStatusInfoVisibility());
        softAssert.assertAll();
    }

    @Test
    public void searchProductTest() {
        HomePage homePage = new HomePage(driver);
        AllProductsPage allProductsPage = new AllProductsPage(driver);
        softAssert.assertTrue(homePage.isVisible(), "Home page is not displayed");
        homePage.clickProductsButton();
        allProductsPage.fillProductName("Blue Top")
                .clickOnSearchButton();
        softAssert.assertTrue(allProductsPage.isSearchedProductIsVisible());
        softAssert.assertTrue(allProductsPage.isAllProductsVisible());
    }

    @Test
    public void loginBeforeCheckoutTest() {
        HomePage homePage = new HomePage(driver);
        AccountPage accountPage = new AccountPage(driver);
        PayementPage payementPage = new PayementPage(driver);
        softAssert.assertTrue(homePage.isVisible(), "Home page is not displayed");

        homePage.clickOnLoginButton()
                .fillUserEmail("edamir4@gmail.com")
                .fillUserPassword("4730426Ed")
                .clickOnLogginButton();
        softAssert.assertTrue(accountPage.isUserLogged());

        accountPage.clickAddToCartButton()
                .clickContinueModalButton()
                .clickOnCartButton()
                .clickOnProceedButton();
        softAssert.assertTrue(accountPage.isCheckoutInfoVisible());
        softAssert.assertTrue(accountPage.isReviewOrderInfoVisible());

        accountPage.addComment("good item")
                .clickOnPlaceOrderButton();
        payementPage.fillNameOnCard("Asatryan Aram")
                .fillCardNumber("456123465789")
                .fillCVV("456")
                .fillExpMonth("11")
                .fillExpYear("2030")
                .clickOnSubmitButton();
        softAssert.assertEquals(payementPage.getSuccessMessage(), "Your order has been placed successfully!");
        homePage.deleteUser();
        softAssert.assertTrue(accountPage.accountStatusInfoVisibility());

    }

    @Test
    public void scrollUpTest() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollDown();
        softAssert.assertTrue(homePage.isDescriptionVisible());
        homePage.scrollUp();
        softAssert.assertEquals(homePage.getSlideText(), "Full-Fledged practice website for Automation Engineers");
    }
}
