package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    public RegisterPageObject() {
        this.driver = driver;
    }

    private WebDriver driver;

    public void clickToMaleRadio() {
    }

    public void enterToFirstNameTextbox(String s) {
    }

    public void enterToLastNameTextbox(String s) {
    }

    public void enterToEmailTextbox(String s) {
    }

    public void enterToCompanyTextbox(String s) {
    }

    public void enterToPasswordTextbox(String s) {
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickToRegisterButton() {
    }

    public byte[] getRegisterSuccessMessage() {
        return new byte[0];
    }

    public void clickToLoginButton() {
    }
}
