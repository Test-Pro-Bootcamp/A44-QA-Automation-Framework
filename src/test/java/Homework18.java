import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException   {
        openUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        //
        WebElement viewAllBtn = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllBtn.click();