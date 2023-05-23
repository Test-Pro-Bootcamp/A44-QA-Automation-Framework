import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException   {
        openUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        enterToSearch("Epic song");
        //click View All button results
        WebElement viewAllBtn = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
        //click first song from list
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results.items [draggable='true']:nth-of-type(1)"));
        songsInResults.get(0).click();
        // click Add To button
        WebElement addToBtn = driver.findElement(By.cssSelector("[title='Add selected songs to…']"));
        addToBtn.click();
        //Creation of new playlist with selected song
        WebElement playlistNameFld = driver.findElement(By.cssSelector("#songResultsWrapper [required]"));
        playlistNameFld.click();
        playlistNameFld.sendKeys("Great Music_777");
        WebElement savePlaylistBtn = driver.findElement(By.cssSelector("#songResultsWrapper [type='submit']"));
        savePlaylistBtn.click();
        //assertion - success banner
        WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(successBanner.isDisplayed());
    }
       public void enterToSearch (String song) throws InterruptedException {
           WebElement searchLine = driver.findElement(By.cssSelector("[name='q']"));
           searchLine.click();
           searchLine.clear();
           searchLine.sendKeys(song);
       }





}
