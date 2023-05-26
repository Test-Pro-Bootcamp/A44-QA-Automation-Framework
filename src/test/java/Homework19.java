import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    //@BeforeMethod
   // @Parameters({"BaseURL"})
    //public void launchBrowser(String BaseURL) {
        //driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.get(BaseURL);
    //}

    @Test
    public void deletePlaylist() throws InterruptedException {
        //Login with valid credentials
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        //Deletion of selected playlist
        WebElement playlistToDelete = driver.findElement(By.cssSelector("[href='#!/playlist/58068']"));
        playlistToDelete.click();
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlaylistBtn.click();
        WebElement deleteNotification = driver.findElement(By.cssSelector("[class='msg']"));
        Thread.sleep(2000);
        Assert.assertTrue(deleteNotification.isDisplayed());
        WebElement deleteOKBtn = driver.findElement(By.cssSelector("button[class='ok']"));
        deleteOKBtn.click();
        //Assertion Deleted playlist banner is displayed 
        WebElement deleteBanner = driver.findElement(By.cssSelector("div[class='success show']"));
        Thread.sleep(2000);
        Assert.assertTrue(deleteBanner.isDisplayed());

    }
}