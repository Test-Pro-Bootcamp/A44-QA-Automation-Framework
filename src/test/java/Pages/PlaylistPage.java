package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlaylistPage extends BasePage {
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
    By playlistActive = By.cssSelector(".playlist .active");
    By playlistMenuEdit = By.cssSelector(".playlist .menu li ");
    By playlistNameEditField = By.cssSelector("input[name='name']");
    By playlist = By.cssSelector(".playlist.playlist>a");
    By newlyCreatedPlaylist = By.cssSelector("#mainWrapper #playlistWrapper");
    By shuffleBtn = By.cssSelector("#playlistWrapper [data-test='btn-shuffle-all']");

    public void clickPlaylist() {
        WebElement playlist = driver.findElement(myPlaylist);
        playlist.click();
    }
    public void deleteSelectedPlaylist() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement deletePlaylistBtn = driver.findElement(deleteBtn);
        js.executeScript("arguments[0].click();", deletePlaylistBtn);

        try {
            boolean btnPresence = driver.findElement(shuffleBtn).isDisplayed();
            if (btnPresence == true) {
                WebElement okBtn = driver.findElement(btnOk);
                js.executeScript("arguments[0].click();", okBtn);
            }
        }
            catch(org.openqa.selenium.NoSuchElementException e){
            }
        }
       // if (driver.findElement(By.cssSelector("#playlistWrapper [data-test='btn-shuffle-all']")).isDisplayed()) {
           // WebElement okBtn = driver.findElement(btnOk);
            //js.executeScript("arguments[0].click();", okBtn);
            //}

    public void clickPlusBtn() {
        WebElement plusBtn = wait.until(ExpectedConditions.elementToBeClickable(btnPlus));
        plusBtn.click();
    }
    public void clickNewPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistCreate)).click();
    }

    public void addPlaylistName(String newPlaylist) {
        WebElement inputPlaylistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(playlistNameField));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys(newPlaylist);
    }
    public void assertPlaylistNameInHeader(String newPlaylist) {
        WebElement playlistHeader = driver.findElement(assertPlaylistNameIsInHeader);
        wait.until(ExpectedConditions
                .textToBePresentInElement(playlistHeader, newPlaylist));
    }
    public void clickDeletePlaylistBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions
                .elementToBeClickable(playlistDeleteBtn));
        js.executeScript("arguments[0].click();", deletePlaylistBtn);
    }
    public void assertPlaylistDeleted(String newPlaylist) {
        List<WebElement> playlists = driver.findElements(playlist);
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++) {
            String playlistName = playlists.get(i).getText();
            playlistNames.add(playlistName);
        }
        System.out.println("The names of available playlists are " + playlistNames);
        Assert.assertFalse(playlistNames.contains(newPlaylist));
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
    public void renamePlaylistName(String newPlaylist) {
        WebElement inputPlaylistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(playlistNameEditField));
        inputPlaylistName.click();
        inputPlaylistName.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        inputPlaylistName.sendKeys(newPlaylist);
        inputPlaylistName.sendKeys(Keys.ENTER);
    }
    public void assertRenamedPlaylistPresent(String newPlaylist) {
        List<WebElement> playlistNames = driver.findElements(playlist);
        List<String> listOfNames = new ArrayList<>();

        for (int i = 0; i < playlistNames.size(); i++) {
            String playlistName = playlistNames.get(i).getText();
            if (playlistName.equals(newPlaylist)) {
                listOfNames.add(playlistName);
            }
        }
        System.out.println(listOfNames);
        Assert.assertTrue(listOfNames.contains(newPlaylist));
    }
    public String generateRandomName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }
    public void assertSongAddedToPlaylist() {
        WebElement createdPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(newlyCreatedPlaylist));
        wait.until(ExpectedConditions
                .textToBePresentInElement(createdPlaylist, "Pluto"));
        }
}