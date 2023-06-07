import Pages.BasePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        playlistPage.clickPlaylist();
        playlistPage.deleteSelectedPlaylist();
        //waitCommand();
        basePage.assertSuccessBanner();
    }
}