import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver;


    @BeforeSuite
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void setUpBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notification*");
        options.addArguments("--start-maximized");


        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}