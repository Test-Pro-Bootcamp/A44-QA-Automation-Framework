import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        login("vicplach123@gmail.com", "MEGAdelta06@");
        String playlistName = generateRandomPlaylistName();
        String text = "Dark Days";
        // search for song
        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
        // click results view all button
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
        // click first song
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
        // click Add To
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
        // create new playlist
        WebElement newPlaylistNameInput = driver.findElement(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
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
        Assert.assertEquals(text, songText);
        // Find playlist
        WebElement findPlaylist = driver.findElement(By.cssSelector("section#playlists > ul > li:nth-of-type(3) > a"));
        findPlaylist.click();
        //Delete playlist
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deletePlaylist.click();
        Thread.sleep(3000);
        WebElement pressOK = driver.findElement(By.cssSelector("[tabindex='1']"));
        pressOK.click();
        Thread.sleep(3000);
        WebElement deleteSuccess = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(deleteSuccess.isDisplayed());
    }
}
