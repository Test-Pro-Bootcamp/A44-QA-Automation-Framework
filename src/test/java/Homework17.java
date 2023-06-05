import Page.HomePage;
import Page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {

     //   openUrl(url);
        enterEmail("andrei.bryliakov01@testpro.io");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        //Thread.sleep(5000);

        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("pluto");

        WebElement submitView = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        submitView.click();

        WebElement submitSong = driver.findElement(By.xpath("(//td[@class='title'])[9]"));
        submitSong.click();

        WebElement submitAdd = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        submitAdd.click();

        WebElement playlistInput = driver.findElement(By.xpath("(//input[@data-test='new-playlist-name'])[3]"));
        playlistInput.click();
        playlistInput.clear();
        playlistInput.sendKeys("HiN1");

        WebElement submitSave = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
        submitSave.click();

        WebElement createdPlaylist = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(createdPlaylist.isDisplayed());

    }
    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.enterEmail("andrei.bryliakov01@testpro.io");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();

        homePage.getAvatar();

        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());

    }
//    @Test
//    public void loginEmptyPaswordTest(){
//        enterEmail("andrei.bryliakov01@testpro.io");
//        clickLoginBtn();
//        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
//        Assert.assertTrue(submitLogin.isDisplayed());
//
//    }

}


