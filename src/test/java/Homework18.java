import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        // String playlistName = generateRandomPlaylistName();
        // login
        openUrl();
        login("vicplach123@gmail.com", "MEGAdelta06@");

        // all songs
        WebElement allSongs = driver.findElement(By.cssSelector(".songs"));
        allSongs.click();


        // Play the song
        WebElement hoverable = driver.findElement(By.cssSelector(".album-thumb-wrapper .fa-play"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        hoverable.click();
        Thread.sleep(5000);


        WebElement pauseBtn = driver.findElement(By.cssSelector(".fa-pause"));
        new Actions(driver)
                .moveToElement(pauseBtn)
                .perform();
        hoverable.click();


        Assert.assertTrue(pauseBtn.isDisplayed());
    }
}