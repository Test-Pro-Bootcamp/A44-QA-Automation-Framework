import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework24 extends BaseTest{

    @Test
    public void loginEmailPasswordSmokeTest() {
        // GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        // WHEN
        loginPage.enterEmail("andrei.bryliakov01@testpro.io");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();

        homePage.getAvatar();
        // THEN
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());

    }

}
