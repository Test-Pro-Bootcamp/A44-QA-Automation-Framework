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
        playlistPage.enterNewPlaylistName();
        Assert.assertTrue(playlistPage.updatedBanner().isDisplayed());
        Assert.assertEquals(playlistPage.getPlaylistName(), "Excellent songs");


    }


}



