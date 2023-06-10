import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTests extends BaseTest {


    @Test(dataProvider = "IncorrectLoginProviders")
    public void negativeLoginTests(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginSucceedTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.enterEmail("demo@class.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();
        Thread.sleep(6000);
        Assert.assertTrue(homePage.getAvatar());
    }


    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "");
        Assert.assertTrue(loginPage.isSubmitLoginBtnDisplayed());
    }

    @Test
    public void loginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .enterEmail("notexists@class.com")
                .enterPassword("te$t$tudent")
                .clickLoginBtn();
        Assert.assertTrue(loginPage.isSubmitLoginBtnDisplayed());
    }



    //        Email("demo@class.com");
//        Password("te$t$tudent");
}
