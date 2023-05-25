import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        openUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        //Hover over to Play button and click
        WebElement playNextBtn = driver.findElement(By.cssSelector("[title='Play or resume']"));
        new Actions(driver)
                .moveToElement(playNextBtn)
                .perform();
        playNextBtn.click();
        Thread.sleep(2000);
        //assertion - creation Pause button
        WebElement pauseBtn = driver.findElement(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
    }
}

