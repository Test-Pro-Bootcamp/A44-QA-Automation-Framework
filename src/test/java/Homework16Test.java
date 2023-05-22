import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;



public class Homework16Test extends BaseTest {
    @Test
    public static void registrationNavigation() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        WebElement registrationButton = driver.findElement(By.cssSelector("[id='hel']"));
        registrationButton.click();
        Thread.sleep(5000);
        WebElement submitRegistrationPage = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(submitRegistrationPage.isDisplayed());
        Thread.sleep(1000);
        System.out.println("User are on the Registration page");
        driver.quit();

    }

}