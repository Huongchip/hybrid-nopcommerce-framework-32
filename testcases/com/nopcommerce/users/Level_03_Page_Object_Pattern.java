package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Level_03_Page_Object_Pattern {
    WebDriver driver;
    BasePage basePage;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        basePage = new BasePage();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void User_01_Register() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.waitForElementClickable(driver, "//input[@id='gender-female']");
        basePage.clickToElement(driver, "//input[@id='gender-female']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", "Lucy");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", "Tran");
        basePage.sendKeyToElement(driver, "//input[@id='Email']", "lucy290624@gmail.com");
        basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

        basePage.waitForElementClickable(driver, "//button[@id='register-button']");
        basePage.clickToElement(driver, "//button[@id='register-button']");
    }

    @Test
    public void User_02_Login() {
        basePage.waitForElementClickable(driver, "//a[@class='ico-login']");
        basePage.clickToElement(driver, "//a[@class='ico-login']");
        basePage.sendKeyToElement(driver, "//input[@id='Email']", "lucy290624@gmail.com");
        basePage.sendKeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.waitForElementClickable(driver, "//button[@class='login-button']");
        basePage.clickToElement(driver, "//button[@class='login-button']");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
