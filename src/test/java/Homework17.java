import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException{
        //log in
        openUrl("https://bbb.testpro.io/");
        login("grigore.crepciuc@testpro.io","te$t$tudent");




        //search for song
        WebElement searchInput = driver.findElement(By.cssSelector("[type ='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("Dark Days");


        //results view all button
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();

        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();

        //click Add To
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
        // create new playlist
        WebElement newPlaylistNameInput = driver.findElement(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        String playlistName = generateRandomPlaylistName();
        newPlaylistNameInput.sendKeys(playlistName);

        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();

        // assertions - success banner and song name in playlist
        WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(successBanner.isDisplayed());
        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        Assert.assertEquals("Dark Days", songText);

    }
}
