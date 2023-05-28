import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19Test extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {

        enterEmail("marianna.tysovska@gmail.com");
        enterPassword("marysia288940.");
        clickLoginBtn();


        WebElement playlistToDelete = driver.findElement(By.cssSelector("[href='#!/playlist/35653']"));
        playlistToDelete.click();
    WebElement submitDeletePlaylist = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        submitDeletePlaylist.click();
    WebElement deleteNotification = driver.findElement(By.cssSelector("[class='msg']"));
        Thread.sleep(2000);
        Assert.assertTrue(deleteNotification.isDisplayed());
    WebElement buttonOkDelete = driver.findElement(By.cssSelector("button[class='ok']"));
        buttonOkDelete.click();
        WebElement deleteBanner = driver.findElement(By.cssSelector("div[class='success show']"));
        Thread.sleep(2000);
        Assert.assertTrue(deleteBanner.isDisplayed());

    }
}


