import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Excellent songs";
        login("demo@class.com", "te$t$tudent");
        //
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("Great Music_777")));
        WebElement playlistToRename = driver.findElement(By.cssSelector("Great Music_777"));
        Actions action = new Actions(driver);
        action.contextClick(playlistToRename).perform();

    }
}