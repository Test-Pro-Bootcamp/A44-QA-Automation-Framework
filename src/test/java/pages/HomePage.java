package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By avatar = By.cssSelector(".avatar");


    public boolean getAvatar(){
        return driver.findElement(avatar).isDisplayed();
    }

}
