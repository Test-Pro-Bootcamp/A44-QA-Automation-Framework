import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.annotations.Test;


public class Homework18 extends BaseTest {

    @Test

    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        homePage.clickPlayBtn();
        homePage.assertPauseBtn();
    }
    @Test

    public void addSongWhileSearching(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        String newPlaylist = playlistPage.generateRandomName();

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        homePage.searchSong("Pluto");
        homePage.clickViewAllBtn();
        homePage.clickFirstSong();
        homePage.clickAddToBtn();
        homePage.playlistNameInput(newPlaylist);
        playlistPage.clickEnter();
        BasePage.assertSuccessBanner();
        playlistPage.assertSongAddedToPlaylist();
    }
}