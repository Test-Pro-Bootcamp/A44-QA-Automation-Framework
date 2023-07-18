import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;


public class LoginTests extends BaseTest {


    @Test(dataProvider = "IncorrectLoginProviders")
    public void negativeLoginTests(String email, String password) {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginSucceedTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.enterEmail("grigore.crepciuc@testpro.io");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.getAvatar());
    }


    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.login("grigore.crepciuc@testpro.io", "");
        Assert.assertTrue(loginPage.isSubmitLoginBtnDisplayed());
    }

    @Test
    public void loginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage
                .enterEmail("notexists@class.com")
                .enterPassword("te$t$tudent")
                .clickLoginBtn();
        Assert.assertTrue(loginPage.isSubmitLoginBtnDisplayed());
    }



    //        Email("demo@class.com");
//        Password("te$t$tudent");
}
