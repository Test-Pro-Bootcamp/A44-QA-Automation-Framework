import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException   {
        openUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        enterToSearch("Epic Song");
        WebElement viewAllBtn = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
        WebElement song = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']/tr[1]"));
        song.click();
        WebElement addToBtn = driver.findElement(By.cssSelector("[title='Add selected songs to…']"));
        addToBtn.click();
        WebElement playlistNameFld = driver.findElement(By.cssSelector("#songResultsWrapper [required]"));
        playlistNameFld.click();
        playlistNameFld.sendKeys("Great Music_777");
        WebElement savePlaylistBtn = driver.findElement(By.cssSelector("#songResultsWrapper [type='submit']"));
        savePlaylistBtn.click();


    }
       public void enterToSearch (String song) throws InterruptedException {
           WebElement searchLine = driver.findElement(By.cssSelector("[name='q']"));
           searchLine.click();
           searchLine.clear();
           searchLine.sendKeys(song);
       }





}
