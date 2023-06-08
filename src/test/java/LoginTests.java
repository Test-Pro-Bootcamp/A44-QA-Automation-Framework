import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""},
        };
    }

    @Test(dataProvider = "IncorrectLoginProviders")
    public void negativeLoginTests(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
        // Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginSucceedTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.enterEmail("stella_26021987@mail.ru");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();
        // find if avatar exists
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
        //Thread.sleep(5000);
    }


    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.enterEmail("demo@class.com");
        loginPage.clickLoginBtn();

        Assert.assertTrue(loginPage.submitLogin());
    }

    @Test
    public void loginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.enterEmail("notexists@class.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();

        Assert.assertTrue(loginPage.submitLogin());
    }
}