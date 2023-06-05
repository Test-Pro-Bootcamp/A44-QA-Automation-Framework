package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = ".avatar")
    WebElement avatar;
    //By avatar = By.cssSelector(".avatar");


    public boolean getAvatar(){
        return driver.findElement(avatar).isDisplayed();
    }

}
