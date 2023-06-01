import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        playlistPage.clickPlusBtn();
        playlistPage.clickNewPlaylist();
        playlistPage.addPlaylistName();
        playlistPage.clickEnter();
        playlistPage.assertPlaylistNameInHeader();
        assertSuccessBanner();

        playlistPage.rightClickOnPlaylist();
        playlistPage.clickEdit();
        playlistPage.renamePlaylistName();
        assertSuccessBanner();
        playlistPage.assertRenamedPlaylistPresent();
    }
}