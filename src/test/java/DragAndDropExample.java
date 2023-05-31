import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragAndDropExample {
    static WebDriver driver;
    @BeforeSuite
    static void setupDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        driver = new FirefoxDriver();
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        Thread.sleep(2000);
        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        new Actions(driver).dragAndDrop(from, to).perform();
        String textTo = to.getText();
        if(textTo.equals("A")) {
            System.out.println("PASS: Square is dropped to target as expected");
        }else {
            System.out.println("FAIL: Square couldn't be dropped to target as expected");
        }
        driver.close();
    }

}
