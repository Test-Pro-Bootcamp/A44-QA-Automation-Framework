import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

 public class LoginTests extends BaseTest {
    @Test
    public static void loginSucceedTest()throws  InterruptedException {

//      Added ChromeOptions argument below to fix websocket error

//      WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("andrei.bryliakov01@testpro.io");
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();

        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
        driver.quit();


    }


}
