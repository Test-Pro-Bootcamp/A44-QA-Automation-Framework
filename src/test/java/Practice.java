import Pages.AllSongsPage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Practice extends BaseTest {
    @Test

    public void changeTheme(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        profilePage.clickAvatar();
        profilePage.isProfilePageOpen();
        profilePage.clickRandomTheme();
        Assert.assertEquals(profilePage.clickRandomTheme(), profilePage.assertThemeChanged());
    }
    @Test

    public void likeSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        allSongsPage.clickAllSongs();
        Thread.sleep(1000);
        allSongsPage.assertAllSongsPageOpen();
        allSongsPage.clickLikeBtn();
        allSongsPage.listOfAllLikedSongs();
    }
    @Test

    public void unlikeSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        allSongsPage.clickAllSongs();
        Thread.sleep(1000);
        allSongsPage.assertAllSongsPageOpen();
        allSongsPage.clickUnlikeBtn();
        allSongsPage.listOfAllUnlikedSongs();
    }
    @Test

    public void logout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        loginPage.logOut();
        Thread.sleep(1000);
        loginPage.submitLogin();
    }
}