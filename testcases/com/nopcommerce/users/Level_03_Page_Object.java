package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Level_03_Page_Object {
    //declare variable
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;

    private CustomerInfoPageObject customerInfoPage;

    //Pre-Condition
    @BeforeClass
    public void beforeClass() {
        //Mở URL lên -> Qua HomePage
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Page đó đc sinh ra và bắt đầu làm những action của page đó
    }

    //Testcase
    @Test
    public void User_01_Register() {
        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject();
        registerPage.clickToMaleRadio();
        registerPage.enterToFirstNameTextbox("");
        registerPage.enterToLastNameTextbox("");
        registerPage.enterToEmailTextbox("");
        registerPage.enterToCompanyTextbox("");
        registerPage.enterToPasswordTextbox("");
        registerPage.enterToConfirmPasswordTextbox("");
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
    }

    @Test
    public void User_02_Login() {
        registerPage.clickToLoginButton();
        loginPage = new LoginPageObject();
        loginPage.enterToEmailTextbox("");
        loginPage.enterToPasswordTextbox("");
        loginPage.clickToLoginButton();

        homePage = new HomePageObject();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_03_My_Account() {
        homePage.clickToMyAccountLink();
        customerInfoPage = new CustomerInfoPageObject();
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
        Assert.assertTrue(customerInfoPage.getFirstNameTextboxValue(), "");
        Assert.assertTrue(customerInfoPage.getLastNameTextboxValue(), "");
        Assert.assertTrue(customerInfoPage.getEmailTextboxValue(), "");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
