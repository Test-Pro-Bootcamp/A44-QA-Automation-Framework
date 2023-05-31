import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        login("vicplach123@gmail.com", "MEGAdelta06@");
        String playlistName = generateRandomPlaylistName();
        String text = "Dark Days";
        // search for song
        inputSearch(text);



        // click results view all button
        clickViewAllBtn();

        // click first song
        clickFirstSearchResultSong();

        // click Add To
        clickAddToPlaylistBtn();

        // create new playlist
        createNewPlaylistWhileAddingSong(playlistName);


        isBannerDisplayed();

        // check the song
        getSongName();


        // assertion of name
        Assert.assertEquals(text, getSongName());
        // Find playlist
        findCreatedPlaylist();

        //Delete playlist
        deleteCreatedPlaylist();

        // Thread.sleep(3000);
        isBannerDisplayed();




    }

    private void deleteCreatedPlaylist() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        deletePlaylist.click();
        //  Thread.sleep(3000);
        WebElement pressOK = driver.findElement(By.cssSelector("[tabindex='1']"));
        pressOK.click();

    }

    private void findCreatedPlaylist() {
        WebElement findPlaylist = driver.findElement(By.cssSelector("section#playlists > ul > li:nth-of-type(3) > a"));
        findPlaylist.click();


    }

    private void inputSearch(String text) {
        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);


    }
}