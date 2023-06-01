import Pages.LoginPage;
import Pages.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Homework20 extends BaseTest {

    @Test

    public void deletePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        playlistPage.clickPlusBtn();
        playlistPage.clickNewPlaylist();
        playlistPage.addPlaylistName();
        playlistPage.clickEnter();
        playlistPage.assertPlaylistNameInHeader();

        playlistPage.clickDeletePlaylistBtn();
        assertSuccessBanner();
        driver.navigate().refresh();
        playlistPage.assertPlaylistCreated();
    }
}