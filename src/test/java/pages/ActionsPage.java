package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActionsPage extends BasePage{
    public ActionsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private @FindBy(css = ".playlist:nth-child(3)")
    WebElement playlistElement;
    //By doubleClick = By.cssSelector(".playlist:nth-child(3)");
    private @FindBy(css= "input[name='name']")
    WebElement playlistInputField;
    //By enterName = By.cssSelector("input[name='name']");

    private By getName = By.cssSelector(".playlist:nth-child(3)>a");
    public ActionsPage doubleClickChoosePlaylist() {
       // WebElement playlistElement = wait.until(ExpectedConditions.
            //    elementToBeClickable(doubleClick));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
        return this;
    }

    public ActionsPage enterPlaylistName(String name) {
        //WebElement playlistInputField = driver.findElement(enterName);
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
        return this;
    }

    public String getPlaylistName() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                visibilityOfElementLocated(getName));
        String name = playlistElement.getText();
        return name;
    }
}
