import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21Test extends BaseTest{

    @Test
    public void renamePlaylist () {


        String newNamePlaylist ="Summer songs";
        login("marianna.tysovska@gmail.com", "marysia288940.");
        doubleClickChoosePlaylist();

    }
        public void doubleClickChoosePlaylist(){
            WebElement playListElement = wait.until(ExpectedConditions.elementToBeClickable(By. cssSelector(".playlist:nth-child(3)")));
            Actions actions = new Actions(driver);
            actions.doubleClick(playListElement).perform();
        }

        public void  newNamePlaylist() {
            WebElement playListName = wait.until(ExpectedConditions.elementToBeClickable(By. cssSelector("input[name='name']")));
            playListName.sendKeys("Summer songs");

            WebElement createNewPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
            Assert.assertTrue(createNewPlaylistName .isDisplayed());
        }
    }


