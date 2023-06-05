import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Homework20Test extends BaseTest {
    @Test
    public void deletePlaylist(){

        enterEmail("marianna.tysovska@gmail.com");
        enterPassword("marysia288940.");
        clickLoginBtn();



        WebElement playlistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#!/playlist/59619']")));
        playlistToDelete.click();
        WebElement submitDeletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
        submitDeletePlaylist.click();
        WebElement deleteNotification = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        Assert.assertTrue(deleteNotification.isDisplayed());
        WebElement deleteOKBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='ok']")));
        deleteOKBtn.click();
        WebElement deleteBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        Assert.assertTrue(deleteBanner.isDisplayed());

    }
}
