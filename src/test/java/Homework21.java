import Pages.BasePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        PlaylistPage playlistPage = new PlaylistPage(getThreadLocal());
        String newPlaylist = playlistPage.generateRandomName();

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        Thread.sleep(1000);
        playlistPage.clickPlusBtn();
        Thread.sleep(1000);
        playlistPage.clickNewPlaylist();
        playlistPage.addPlaylistName(newPlaylist);
        playlistPage.clickEnter();
        playlistPage.assertPlaylistNameInHeader(newPlaylist);
        BasePage.assertSuccessBanner();

        playlistPage.rightClickOnPlaylist();
        playlistPage.clickEdit();
        playlistPage.renamePlaylistName(newPlaylist);
        BasePage.assertSuccessBanner();
        Thread.sleep(1000);
        playlistPage.assertRenamedPlaylistPresent(newPlaylist);
    }

    @Test

    public void renamePlaylist1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        assertRenamedPlaylistPresent();
    }
}