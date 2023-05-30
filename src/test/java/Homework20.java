import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Homework20 extends BaseTest {

    @Test

    public void deletePlaylist(){
        login("stella_26021987@mail.ru", "te$t$tudent");

        WebElement plusBtn = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        plusBtn.click();

        WebElement newPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();

        WebElement inputPlaylistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".create>input")));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys("First Playlist");
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();


        WebElement playlistHeader = driver.findElement(By.cssSelector("#playlistWrapper h1"));
        wait.until(ExpectedConditions
                .textToBePresentInElement(playlistHeader, "First Playlist"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        js.executeScript("arguments[0].click();", deletePlaylistBtn);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success")));
        driver.navigate().refresh();

        List<WebElement> playlists = driver.findElements(By.cssSelector("#playlists a"));
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++) {
            String playlistName = playlists.get(i).getText();
            playlistNames.add(playlistName);
            }
        System.out.println("The names of available playlists are " + playlistNames);
        Assert.assertFalse(playlistNames.contains("First Playlist"));
    }
}
