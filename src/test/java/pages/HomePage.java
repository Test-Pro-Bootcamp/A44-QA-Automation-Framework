package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = ".avatar")
    WebElement avatar;
    //By avatar = By.cssSelector(".avatar");


    public WebElement getAvatar(){
        return wait.until(ExpectedConditions.visibilityOf(avatar));
    }

}
