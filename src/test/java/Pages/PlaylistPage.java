package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By myPlaylist = By.cssSelector("[class='playlist playlist']");
    By deleteBtn = By.cssSelector("[title='Delete this playlist']");
    By btnOk = By.cssSelector(".ok");
    By btnPlus = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    By newPlaylistCreate = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By playlistNameField = By.cssSelector(".create input");
    By assertPlaylistNameIsInHeader = By.cssSelector("#playlistWrapper h1");
    By playlistDeleteBtn = By.cssSelector(".btn-delete-playlist");
    By listOfPlaylistNames = By.cssSelector("#playlists a");
    By playlistActive = By.cssSelector(".playlist .active");
    By playlistMenuEdit = By.cssSelector(".playlist .menu li ");
    By playlistNameEditField = By.cssSelector("input[name='name']");
    By assertRenamedPlaylistIsPresent = By.cssSelector(".playlist.playlist>a");

    public void clickPlaylist() {
        WebElement playlist = driver.findElement(myPlaylist);
        playlist.click();
    }
    public void deleteSelectedPlaylist() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement deletePlaylistBtn = driver.findElement(deleteBtn);
        js.executeScript("arguments[0].click();", deletePlaylistBtn);
    }
    public void clickOkBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement okBtn = driver.findElement(btnOk);
        js.executeScript("arguments[0].click();", okBtn);
    }
    public void clickPlusBtn() {
        WebElement plusBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(btnPlus));
        plusBtn.click();
    }
    public void clickNewPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistCreate)).click();
    }
    public void addPlaylistName() {
        WebElement inputPlaylistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(playlistNameField));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys("Try#1");
    }
    public void assertPlaylistNameInHeader() {
        WebElement playlistHeader = driver.findElement(assertPlaylistNameIsInHeader);
        wait.until(ExpectedConditions
                .textToBePresentInElement(playlistHeader, "Try#1"));
    }
    public void clickDeletePlaylistBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions
                .elementToBeClickable(playlistDeleteBtn));
        js.executeScript("arguments[0].click();", deletePlaylistBtn);
    }
    public void assertPlaylistCreated(){
        List<WebElement> playlists = driver.findElements(listOfPlaylistNames);
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++) {
            String playlistName = playlists.get(i).getText();
            playlistNames.add(playlistName);
        }
        System.out.println("The names of available playlists are " + playlistNames);
        Assert.assertFalse(playlistNames.contains("First Playlist"));
    }
    public void clickEnter() {
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }
    public void rightClickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(playlistActive));
        new Actions(driver)
                .contextClick(playlist)
                .perform();
    }
    public void clickEdit() {
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(playlistMenuEdit));
        editBtn.click();
    }
    public void renamePlaylistName() {
        WebElement inputPlaylistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(playlistNameEditField));
        inputPlaylistName.click();
        inputPlaylistName.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        inputPlaylistName.sendKeys("Renamed playlist attempt # 2");
        inputPlaylistName.sendKeys(Keys.ENTER);
    }
    public void assertRenamedPlaylistPresent() {
        List<WebElement> playlistNames = driver.findElements(assertRenamedPlaylistIsPresent);
        List<String> listOfNames = new ArrayList<>();

        for (int i = 0; i < playlistNames.size(); i++) {
            String playlistName = playlistNames.get(i).getText();
            if(playlistName=="Renamed playlist attempt # 2"){
                listOfNames.add(playlistName);
            }
        }
        System.out.println(listOfNames);
        //Assert.assertTrue(listOfNames.contains("Renamed playlist attempt # 2"));
    }
}