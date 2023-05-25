import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;

public class Homeework18Test extends BaseTest {

    @Test

    public void nextSongButton() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.sendKeys("marianna.tysovska@gmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.sendKeys("marysia288940.");

        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();





        WebElement playNext = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));


        new Actions(driver)
                .moveToElement(playNext)
                .perform();
        playNext.click();
        Thread.sleep(5000);
        WebElement buttonPause = driver.findElement(By.cssSelector("span[data-testid='pause-btn']"));
        Assert.assertTrue(buttonPause.isDisplayed());

        driver.quit();

    }
}
