import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist(){
        String newPlaylistName = "Excellent songs";
        login("demo@class.com", "te$t$tudent");
        //
        WebElement playlistElement = wait.until(ExpectedConditions.
                elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));

        }
        }