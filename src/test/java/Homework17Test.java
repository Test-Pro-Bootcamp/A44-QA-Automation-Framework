import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17Test extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("marianna.tysovska@gmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("marysia288940.");

        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();

        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());


        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("For the Poor");
        Thread.sleep(5000);

        WebElement submitView = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        submitView.click();

        WebElement submitFirstSong = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        submitFirstSong.click();



        WebElement submitAdd = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        submitAdd.click();

        WebElement playlistInput = driver.findElement(By.xpath("(//input[@data-test='new-playlist-name'])[3]"));
        playlistInput.click();
        playlistInput.clear();
        playlistInput.sendKeys("marianka");

        WebElement submitSave = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
        submitSave.click();

        WebElement createdPlaylist = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(createdPlaylist.isDisplayed());


    }
}