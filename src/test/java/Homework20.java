import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
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
        WebElement playlistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#!/playlist/59099']")));
        //driver.findElement(By.cssSelector("[href='#!/playlist/58068']"));
        playlistToDelete.click();
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
        //driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlaylistBtn.click();
        WebElement deleteNotification = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        //driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        //Thread.sleep(2000);
        Assert.assertTrue(deleteNotification.isDisplayed());
        WebElement deleteOKBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='ok']")));
        //driver.findElement(By.cssSelector("button[class='ok']"));
        deleteOKBtn.click();
        //Assertion Deleted playlist banner is displayed
        WebElement deleteBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        //driver.findElement(By.cssSelector("div[class='success show']"));
        //Thread.sleep(2000);
        Assert.assertTrue(deleteBanner.isDisplayed());

    }
}