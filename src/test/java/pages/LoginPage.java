package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "[type='email']")
    WebElement emailField;

    @FindBy(css = "[type='password']")
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement submitLoginBtn;


    public void clickLoginBtn() {
        WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(submitLoginBtn));
        submitLogin.click();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }

}