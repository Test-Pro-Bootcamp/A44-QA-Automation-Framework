package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {

        super(givenDriver);
    }

//    @FindBy(css ="[type='submit']")
//    WebElement submitButtonLocator;
    @FindBy(css = "[type='email']")
    private  WebElement emailInput;
    @FindBy(css = "[type='password']")
    private  WebElement  passwordInput;

//     public void clickSubBtn(){
//         submitButtonLocator.click();
//     }
//      public void provideEmail(String email){
//         emailField.sendKeys(email);
//      }
//      public void provedePassword(String password){
//         passwordField.sendKeys(password);
//      }
//    static By emailField = By.cssSelector("[type='email']");
//    static By passwordField = By.cssSelector("[type='password']");
 By submitLoginBtn = By.cssSelector("button[type='submit']");

    public LoginPage enterEmail(String email) {
//        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
//        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(submitLoginBtn));
        submitLogin.click();
        return this;
    }

//    public  loginSubmit(String email,String password){
//        enterEmail(email);
//        enterPassword(password);
//        clickLoginBtn();
//    }

    public boolean getSubmitLoginBtn() {
       return driver.findElement(submitLoginBtn).isDisplayed();
    }


}
