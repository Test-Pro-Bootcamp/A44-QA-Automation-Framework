import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

import java.util.List;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        // double click
        String playlistName = "Summer songs";

        loginPage.login("demo@class.com", "te$t$tudent");
        doubleClickChoosePlaylist();
        enterPlaylistName(playlistName);
        String newName = getPlaylistName();
        Assert.assertEquals(playlistName, newName, "=== PlaylistNames expected to be equals ===");
    }

}
