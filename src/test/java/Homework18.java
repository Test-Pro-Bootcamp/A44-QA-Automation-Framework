import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
public void playSongTest() throws InterruptedException {

     openUrl();
     enterEmail("andrei.bryliakov01@testpro.io");
     enterPassword("te$t$tudent");
     clickLoginBtn();

        WebElement hoverable = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        hoverable.click();

        WebElement buttonPause = driver.findElement(By.cssSelector("span[data-testid='pause-btn']"));
        Assert.assertTrue(buttonPause.isDisplayed());
    }

}
