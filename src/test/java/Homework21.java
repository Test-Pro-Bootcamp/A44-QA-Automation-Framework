import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String playlistName = "Stay tune" ;
        String  newName = "Don't feel sorry";

        login("vicplach123@gmail.com", "MEGAdelta06@");


        //create playlist
        createNewPlist(playlistName);

       //check playlist name
        checkTheNameOfCreatedPlyst(playlistName);

        System.out.println(playlistName);


        //rename playlist
        doubleClickChoosePlaylist();

        enterNewName(newName);

        System.out.println(newName);
        Assert.assertFalse(playlistName.contains(newName));






    }

    private void createNewPlist(String playlistName) {
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


    }

    private void checkTheNameOfCreatedPlyst(String playlistName) {
        WebElement newPlaylistConfirm = driver.findElement(By.cssSelector("section#playlistWrapper h1"));

        wait.until(ExpectedConditions.textToBePresentInElement(newPlaylistConfirm, playlistName));
        Assert.assertEquals(newPlaylistConfirm.getText(), playlistName);
    }

    public void enterNewName(String newName) {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), newName);
        playlistInputField.sendKeys(Keys.ENTER);
    }


    private void doubleClickChoosePlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }
    }

