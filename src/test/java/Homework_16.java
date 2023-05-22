import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework_16 extends BaseTest {
    @Test
    public void registrationNavigation() {
        openUrl();
        WebElement registrationButton = driver.findElement(By.cssSelector("#hel"));
        registrationButton.click();
        WebElement registerButton = driver.findElement(By.cssSelector("#button"));
        Assert.assertTrue(registerButton.isDisplayed());





    }
}
