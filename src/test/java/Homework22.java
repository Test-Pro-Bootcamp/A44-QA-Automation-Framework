import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActionsPage;
import pages.LoginPage;

public class Homework22 extends BaseTest {
    @Test
    public void renamePlaylist() {
        ActionsPage actionsPage =new ActionsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        // double click
        String playlistName = "Happy Days";

        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        actionsPage. doubleClickChoosePlaylist();
        actionsPage.enterPlaylistName(playlistName);
        String newName = actionsPage.getPlaylistName();
        Assert.assertEquals(playlistName, newName, "=== PlaylistNames expected to be equals ===");
    }

}
