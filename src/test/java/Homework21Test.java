import io.github.bonigarcia.wdm.cache.ResolutionCache;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21Test extends BaseTest{

    @Test

    public void renamePlaylist(){
        //  GIVEN
        enterEmail("marianna.tysovska@gmail.com");
        enterPassword("marysia288940.");
        clickLoginBtn();
        //   WHEN
        doubleClick();
        playListNewName();
        click();
        //   THEN
        WebElement createdNewNamePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        Assert.assertTrue(createdNewNamePlaylist.isDisplayed());

    }

    public void doubleClick(){
        WebElement playListElement = wait.until(ExpectedConditions.elementToBeClickable(By. cssSelector(".playlist:nth-child(3)")));
        Actions actions = new Actions(driver);
        actions.doubleClick(playListElement).perform();

    }

    public void  playListNewName() {
        WebElement playListName = wait.until(ExpectedConditions.elementToBeClickable(By. cssSelector("input[name='name']")));
        playListName.sendKeys("summer songs");
    }

    public void click() {
        WebElement click = wait.until(ExpectedConditions.elementToBeClickable(By. cssSelector("[type='search']")));
        click.click();
    }

}















