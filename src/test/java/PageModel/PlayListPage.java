package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlayListPage extends Basepage{
    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }

 By clickPlusLocator = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
     By successBanner = By.cssSelector(".success");
    public void clickPlusPlaylistBtn(){
        WebElement plusBtn = waitUntilVisible(clickPlusLocator);
        plusBtn.click();

    }
    public void createNewPlaylistName(String playlist)  {
        wait.until(ExpectedConditions
                        .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")))
                .click();
        WebElement inputPlaylistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".create input")));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys(playlist);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }


    public WebElement verifySuccessBanner() {
        return   wait.until(ExpectedConditions.visibilityOfElementLocated(successBanner));
    }

    public void createNewPlaylistWhileAddingSong(String playlistName) {
        WebElement newPlaylistNameInput = driver.findElement(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }
    public void clickAddToPlaylistBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
    }
}





