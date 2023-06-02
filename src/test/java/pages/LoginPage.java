package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitLoginBtn = By.cssSelector("button[type='submit']");


    public void clickLoginBtn() {
        WebElement submitLogin = driver.findElement(submitLoginBtn);
        submitLogin.click();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }

}
