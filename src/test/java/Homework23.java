import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework23 extends BaseTest {

    @Test
    public void renamePlaylistByContextMenu() {
        PlaylistPage playlistPage = new PlaylistPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);


        loginPage.login("demo@class.com", "te$t$tudent");
        playlistPage.contextClickPlaylist();
        Assert.assertTrue(playlistPage.editBtn().isDisplayed());
        playlistPage.clickEditBtnOfContextMenu();
        playlistPage.enterNewPlaylistName();
        Assert.assertTrue(playlistPage.updatedBanner().isDisplayed());
        Assert.assertEquals(playlistPage.getPlaylistName(), "Excellent songs");


    }

    @Test
    public void deletePlaylist()  {
        PlaylistPage playlistPage = new PlaylistPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //Login with valid credentials
        loginPage.login("demo@class.com", "te$t$tudent");
        //Deletion of selected playlist
        WebElement playlistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#!/playlist/59099']")));
        //driver.findElement(By.cssSelector("[href='#!/playlist/58068']"));
        playlistToDelete.click();
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Delete this playlist']")));
        //driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlaylistBtn.click();
        WebElement deleteNotification = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Delete this playlist']")));
        //driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        //Thread.sleep(2000);
        Assert.assertTrue(deleteNotification.isDisplayed());
        WebElement deleteOKBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='ok']")));
        //driver.findElement(By.cssSelector("button[class='ok']"));
        deleteOKBtn.click();
        //Assertion Deleted playlist banner is displayed
        WebElement deleteBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        //driver.findElement(By.cssSelector("div[class='success show']"));
        //Thread.sleep(2000);
        Assert.assertTrue(deleteBanner.isDisplayed());

    }


}