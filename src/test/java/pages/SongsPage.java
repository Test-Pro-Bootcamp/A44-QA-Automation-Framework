package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.NoSuchElementException;

public class SongsPage extends BasePage {


    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By pauseBtn = By.cssSelector("[data-testid='pause-btn']");
    By equalizer = By.cssSelector("[alt='Sound bars']");

    @FindBy (css = "[title='Play or resume']")
    WebElement playPauseButton;



    public boolean isPauseBtnDisplayed() {
        return driver.findElement(pauseBtn).isDisplayed();
    }

    public boolean isPlayBtnDisplayed() {
        return driver.findElement((By) playPauseButton).isDisplayed();
    }

    public boolean isEqualizerDisplayed() {
        return driver.findElement(equalizer).isDisplayed();
    }

    public boolean isEqualizerNotDisplayed() {
        try {
           driver.findElement(equalizer);
           return false;
        } catch (NoSuchElementException e) {
            return true;
        }



    }

    public void startPlaySong() {
        new Actions(driver)
                .moveToElement(playPauseButton)
                .perform();
        playPauseButton.click();


    }

    public void clickPauseBtn() {
        WebElement buttonPause = waitUntilVisible(pauseBtn);
        buttonPause.click();
    }

    public void searchForSong(String text) {
        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    public String getSongName() {
        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        return songText;
    }

    public void clickFirstSearchResultSong() {
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
    }

    public void clickAddToPlaylistBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
    }


    public void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector(".playback"));
        playBtn.click();
    }

    public void rightClickOnFirstSong() {
        WebElement firstSong = driver.findElement(By.cssSelector(".song-item"));
        Actions actions = new Actions(driver);
        actions.contextClick(firstSong).perform();
    }

    public void clickFooterPlayBtn() {
        Actions action = new Actions(driver);
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        action
                .moveToElement(playBtn)
                .perform();
        playBtn.click();
    }

    public boolean pauseBtnExists() {
        return driver.findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
    }


    public void goToAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".songs"))).click();
    }


    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getPlaylistName() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)>a")));
        String name = playlistElement.getText();
        return name;
    }
}
