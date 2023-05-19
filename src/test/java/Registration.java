import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;


public class Registration extends BaseTest {

    @Test
    public static void registrationNavigationTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement registrationButton = driver.findElement(By.cssSelector("[id='hel']"));
        registrationButton.click();
        WebElement registerButton = driver.findElement(By.cssSelector("[id='button']"));
        registerButton.click();


        //registerButton.click();
        //passwordInput.clear();
        //passwordInput.sendKeys("te$t$tudent");
        //WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        //submitLogin.click();
        //WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        //Assert.assertTrue(avatar.isDisplayed());
        //Thread.sleep(5000);
        //List<WebElement> playlists = driver.findElements(By.cssSelector("#playlists"));
        driver.quit();
    }
}