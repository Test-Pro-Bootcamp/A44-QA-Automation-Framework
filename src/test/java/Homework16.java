import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notification*");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);



        WebElement submitRegistration = driver.findElement(By.cssSelector("a[type='submit']"));
        submitRegistration.click();

        WebElement post = driver.findElement(By.cssSelector("[method='POST']"));
        Assert.assertTrue(post.isDisplayed());
        driver.quit();


    }
}
