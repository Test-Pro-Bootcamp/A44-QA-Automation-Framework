package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By avatar = By.cssSelector(".avatar");
    By playBtnFooter = By.cssSelector("[data-testid='play-btn']");
    By pauseBtnFooter = By.cssSelector("[data-testid='pause-btn']");
    By searchField = By.cssSelector("[type='search']");
    By viewAllButton = By.cssSelector("button[data-test='view-all-songs-btn']");
    By firstSongSelect = By.cssSelector("[class='song-list-wrap main-scroll-wrap search-results'] .items");
    By addToButton = By.cssSelector(".btn-add-to");
    By playlistNameField = By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']");


    public WebElement getAvatar(){
        return waitUntilVisible(avatar);
    }
    public void clickPlayBtn() {
        WebElement playBtn = driver.findElement(playBtnFooter);
        new Actions(driver)
                .moveToElement(playBtn)
                .perform();
        playBtn.click();
    }
    public void assertPauseBtn() {
        WebElement pauseBtn = driver.findElement(pauseBtnFooter);
        Assert.assertTrue(pauseBtn.isDisplayed());
    }
    public void searchSong(String song) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(song);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void clickViewAllBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement viewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(viewAllButton));
        js.executeScript("arguments[0].click();", viewAllBtn);
    }
    public void clickFirstSong() {
        WebElement searchSong = wait.until(ExpectedConditions.elementToBeClickable(firstSongSelect));
        searchSong.click();
    }
    public void clickAddToBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement addToBtn = driver.findElement(addToButton);
        js.executeScript("arguments[0].click();", addToBtn);
    }
    public void playlistNameInput(String playlistName) {
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(playlistNameField));
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(playlistName);
    }
}