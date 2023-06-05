import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16Test extends BaseTest {
    @Test
    public void registrationNavigation() {

        WebElement registrationButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='hel']")));
        registrationButton.click();

        WebElement submitRegistrationPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Register']")));
        Assert.assertTrue(submitRegistrationPage.isDisplayed());

        System.out.println("User are on the Registration page");
        driver.quit();
    }
}
