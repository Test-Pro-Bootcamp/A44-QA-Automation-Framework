import Page.BasePage;
import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

   public class Homework23 extends BaseTest {

    @Test
    public void loginEmailPasswordTest() {
        // GIVEN
        LoginPage loginPage = new LoginPage(driver);
        // WHEN
        loginPage.enterEmail("andrei.bryliakov01@testpro.io")
                .enterPassword("te$t$tudent")
                .clickLoginBtn();

        // THEN
        Assert.assertTrue(loginPage.getSubmitLoginBtn());

    }



}
