import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {


        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("andrei.bryliakov01@testpro.io");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");

        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();

        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
        //Thread.sleep(5000);

        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("pluto");
       // Thread.sleep(5000);

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
}


