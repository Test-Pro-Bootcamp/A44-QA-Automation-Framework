import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ProfileTests extends BaseTest {

    @Test(groups = "ProfileTests")
    public void changeProfileName()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        // open profile
        WebElement avatar = getThreadLocal().findElement(By.cssSelector(".avatar"));
        avatar.click();
        // type password
        WebElement currentPasswordInput = getThreadLocal().findElement(By.cssSelector("[id='inputProfileCurrentPassword']"));
        currentPasswordInput.click();
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys("te$t$tudent");
        // type new name
        String name = generateRandomName();
        System.out.println(name);
        WebElement profileName = getThreadLocal().findElement(By.cssSelector("#inputProfileName"));
        profileName.click();
        profileName.clear();
        profileName.sendKeys(name);
        // type email
        WebElement emailInput = getThreadLocal().findElement(By.cssSelector("#inputProfileEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");
        // click save
        WebElement saveBtn = getThreadLocal().findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();
        // assert profile name is new
        getThreadLocal().navigate().refresh();
        WebElement profile = getThreadLocal().findElement(By.cssSelector(".view-profile>span"));
        String newName = profile.getText();
        Assert.assertEquals(newName, name);
    }
}
