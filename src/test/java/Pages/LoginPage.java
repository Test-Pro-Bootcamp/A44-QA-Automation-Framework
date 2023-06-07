package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By emailfield = By.cssSelector("[type='email']");
    By passwordfield = By.cssSelector("[type='password']");
    By submitLoginBtn = By.cssSelector("button[type='submit']");
    By logOutBtn = By.cssSelector("[data-testid='btn-logout']");

    public void clickLoginBtn() {
        WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(submitLoginBtn));
        submitLogin.click();
    }
    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordfield));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailfield));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void login(String email, String password) {
        //openUrl();
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }
    public void logOut() {
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));
        logoutBtn.click();
    }
    public boolean submitLogin(){
        return driver.findElement(submitLoginBtn).isDisplayed();
    }
}