import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test
    public void loginSucceedTest() throws InterruptedException {
        openUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        // find if avatar exists
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
        Thread.sleep(5000);
    }


    @Test
    public void loginEmptyPasswordTest() {
        openUrl();
        enterEmail("demo@class.com");
        clickLoginBtn();
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
    }

    @Test
    public void loginInvalidEmailTest() {
        openUrl();
        enterEmail("notexists@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
    }


    //        Email("demo@class.com");
//        Password("te$t$tudent");
}
