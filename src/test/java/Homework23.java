import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActionsPage;
import pages.LoginPage;

public class Homework23 extends BaseTest {
    @Test
    public void renamePlaylist() {
        ActionsPage actionsPage =new ActionsPage(getThreadLocal());
        LoginPage loginPage = new LoginPage(getThreadLocal());
        String playlistName = "Happy Days";
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        actionsPage. doubleClickChoosePlaylist().enterPlaylistName(playlistName);
        String newName = actionsPage.getPlaylistName();
        Assert.assertEquals(playlistName, newName, "=== PlaylistNames expected to be equals ===");
    }

}
