package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class AllSongsPage extends BasePage {

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By likedSongsList = By.cssSelector("#songsWrapper [data-test='btn-like-liked']");
    By allSongs = By.cssSelector("#songsWrapper h1");
    By allSongsMenu = By.cssSelector(".menu .songs");
    By unLikedSongsList = By.cssSelector("#songsWrapper [data-test='btn-like-unliked']");

    public void listOfAllLikedSongs() {
        List<WebElement> likedSongs = driver.findElements(likedSongsList);
        System.out.println("Quantity of all liked songs is " + likedSongs.size());
    }

    public void assertAllSongsPageOpen() {
        WebElement allSongsPage = wait.until(ExpectedConditions.presenceOfElementLocated(allSongs));
        Assert.assertEquals(allSongsPage.getText().trim(), "All Songs");
    }

    public void clickLikeBtn() {
        List<WebElement> favoriteSongs = driver.findElements(likedSongsList);
        Random random = new Random();
        int randomValue = random.nextInt(favoriteSongs.size());
        favoriteSongs.get(randomValue).click();
    }

    public void clickAllSongs() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement allSongs = wait.until(ExpectedConditions.elementToBeClickable(allSongsMenu));
        js.executeScript("arguments[0].click();", allSongs);
    }

    public void listOfAllUnlikedSongs() {
        List<WebElement> unLikedSongs = driver.findElements(unLikedSongsList);
        System.out.println("Quantity of all unliked songs is " + unLikedSongs.size());
    }

    public void clickUnlikeBtn() {
        List<WebElement> unlikedSongs = driver.findElements(unLikedSongsList);
        Random random = new Random();
        int randomValue = random.nextInt(unlikedSongs.size());
        unlikedSongs.get(randomValue).click();
    }
}