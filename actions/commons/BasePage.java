package commons;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public void openUrl(WebDriver driver) {
        driver.get("https://demo.nopcommerce.com/");
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelToConfirm(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String text) {
        waitAlertPresence(driver).sendKeys(text);
    }

    public void clickToElement(WebDriver driver, String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String text) {
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    public void selectItemInDropDown(WebDriver driver, String locator, String option) {
        new Select(driver.findElement(By.xpath(locator))).selectByVisibleText(option);
    }

    public String getSelectedItemInDropDown(WebDriver driver, String locator) {
        return new Select(driver.findElement(By.xpath(locator))).getFirstSelectedOption().getText();
    }

    public void isDropdownMultiple(WebDriver driver, String locator, String option) {
        new Select(driver.findElement(By.xpath(locator))).isMultiple();
    }
}
