import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() {
//      Added ChromeOptions argument below to fix websocket error
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        playlistPage.clickPlaylist();
        playlistPage.deleteSelectedPlaylist();
        playlistPage.clickOkBtn();
        waitCommand();
        assertSuccessBanner();
    }
}