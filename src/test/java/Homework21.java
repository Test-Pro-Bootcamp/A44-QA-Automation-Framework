import io.github.bonigarcia.wdm.cache.ResolutionCache;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

@Test

    public void renamePlaylist(){
  //  GIVEN
//    openUrl(url);
    enterEmail("andrei.bryliakov01@testpro.io");
    enterPassword("te$t$tudent");
    clickLoginBtn();
  //   WHEN
    doubleClick();
    playListNewName();
    click();
  //   THEN
    WebElement createdElementNewName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
    Assert.assertTrue(createdElementNewName.isDisplayed());

}

    public void doubleClick(){
        WebElement playListElement = wait.until(ExpectedConditions.elementToBeClickable(By. cssSelector(".playlist:nth-child(3)")));
    Actions actions = new Actions(driver);
    actions.doubleClick(playListElement).perform();

    }

    public void  playListNewName() {
      WebElement playListName = wait.until(ExpectedConditions.elementToBeClickable(By. cssSelector("input[name='name']")));
      // playListNewName.clear();
    playListName.sendKeys("Hello");
    }

    public void click() {
        WebElement click = wait.until(ExpectedConditions.elementToBeClickable(By. cssSelector("[type='search']")));
        click.click();
    }

}







