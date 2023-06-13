package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "[type='email']")
    WebElement emailInput;

    //  By emailField = By.cssSelector("[type='email']");

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    //  private By passwordField = By.cssSelector("[type='password']");
    private By submitLoginBtn = By.cssSelector("button[type='submit']");


    public LoginPage clickLoginBtn() {
        WebElement submitLogin = driver.findElement(submitLoginBtn);
        submitLogin.click();
        return this;
    }

    public LoginPage enterPassword(String password) {
        // WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage enterEmail(String email) {
        // WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }

    public boolean isSubmitLoginBtnDisplayed(){
        return driver.findElement(submitLoginBtn).isDisplayed();
    }

}