import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class Homework22 extends BaseTest {

    @Test
    public void renamePlaylistByContextMenu() {
        PlaylistPage playlistPage = new PlaylistPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("demo@class.com", "te$t$tudent");
        playlistPage.contextClickPlaylist();
        Assert.assertTrue(playlistPage.editBtn().isDisplayed());
        playlistPage.clickEditBtnOfContextMenu();
        enterNewPlaylistName();
        Assert.assertTrue(isUpdatedBannerAppeared());
        Assert.assertEquals(getPlaylistName(), "Excellent songs");


    }

    public String getPlaylistName() {
        WebElement playlist = driver.findElement(By.cssSelector("[href='#!/playlist/59529']"));
        String playlistName = playlist.getText();
        return playlistName;
    }


    public boolean isUpdatedBannerAppeared() {
        WebElement updatedBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        return updatedBanner.isDisplayed();
    }


    private void enterNewPlaylistName() {

        String name = "Excellent songs";
        WebElement playlistToRename = driver.findElement(By.cssSelector("input[name='name']"));
        playlistToRename.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistToRename.sendKeys(Keys.ENTER);
    }




}



