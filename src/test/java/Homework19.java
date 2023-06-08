import Pages.BasePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deleteCurrentPlaylist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        PlaylistPage playlistPage = new PlaylistPage(getThreadLocal());
        BasePage basePage = new BasePage(getThreadLocal());

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        playlistPage.clickPlaylist();
        playlistPage.deleteSelectedPlaylist();
        //waitCommand();
        basePage.assertSuccessBanner();
    }
}