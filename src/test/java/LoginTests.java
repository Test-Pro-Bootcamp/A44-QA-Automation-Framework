import PageModel.HomePage;
import PageModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


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
    public void negativeLoginTests(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login("vicplach123@gmail.com", "MEGAdelta06@");
        Assert.assertTrue(homePage.getAvatar());

    }


    @Test
    public void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("MEGAdelta06@");
        loginPage.clickLoginBtn();
        loginPage.isSubmitBtnDisplayed();
    }

    @Test
    public void loginInvalidEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("notexists@class.com", "MEGAdelta06@");
        loginPage.isSubmitBtnDisplayed();
     }


}