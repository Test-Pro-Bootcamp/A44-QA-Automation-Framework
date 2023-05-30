import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        login("vicplach123@gmail.com", "MEGAdelta06@");
        String playlistName = generateRandomPlaylistName();

        //create playlist before deleting it

        WebElement plusPlaylistbtn = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[title='Create a new playlist']")));
        plusPlaylistbtn.click();
        WebElement newPlaylistbtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlaylistbtn.click();

        WebElement inputNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));

        inputNewPlaylist.click();
        inputNewPlaylist.clear();
        inputNewPlaylist.sendKeys(playlistName);
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
       // Thread.sleep(300);
        // playlist appearance confirmation
        WebElement newPlaylistConfirm = driver.findElement(By.cssSelector("section#playlistWrapper h1"));

        wait.until(ExpectedConditions.textToBePresentInElement(newPlaylistConfirm, playlistName));
        // check the playlist creation
        System.out.println(newPlaylistConfirm.getText());
        Assert.assertEquals(newPlaylistConfirm.getText(), playlistName);
        //delete playlist
        WebElement playlistDelete = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        playlistDelete.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success")));

        System.out.println("OK");
        // refresh page
        driver.navigate().refresh();

        //Thread.sleep(1000);

        List<WebElement> PlayLists = driver.findElements(By.cssSelector("#playlists a"));
        List<String> PlaylistNames = new ArrayList<>();
        //playlist deleting check

        for (int i = 0; i < PlayLists.size(); i++) {
            String PlaylistName = PlayLists.get(i).getText();
            PlaylistNames.add(PlaylistName);

        }
        System.out.println(PlaylistNames);
        Assert.assertFalse(PlaylistNames.contains(playlistName));
    }


}
