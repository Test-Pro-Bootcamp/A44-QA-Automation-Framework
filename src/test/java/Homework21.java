import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylistByContextMenu() {

        login("demo@class.com", "te$t$tudent");
        contextClickPlaylist();
        Assert.assertTrue(isEditBtnAppeared());
        clickEditBtnOfContextMenu();
        enterNewPlaylistName();
        Assert.assertTrue(isUpdatedBannerAppeared());
        isPlaylistNameChanged();
        Assert.assertEquals(getPlaylistName(), "Excellent songs");


    }

    public String getPlaylistName() {
        WebElement playlist = driver.findElement(By.cssSelector("[href='#!/playlist/59529']"));
        String playlistName = playlist.getText();
        return playlistName;
    }

    private void isPlaylistNameChanged() {
    }

    public boolean isUpdatedBannerAppeared() {
        WebElement updatedBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        return updatedBanner.isDisplayed();
    }


    private void enterNewPlaylistName() {

        String name = "Excellent songs";
        WebElement playlistToRename = driver.findElement(By.cssSelector("input[name='name']"));
        playlistToRename.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistToRename.sendKeys(Keys.ENTER);
    }

    public boolean isEditBtnAppeared() {
        WebElement editBtn = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-edit-59529']"));
        return editBtn.isDisplayed();
    }

    private void clickEditBtnOfContextMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-edit-59529']"))).click();
    }

    private void contextClickPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='#!/playlist/59529']")));
        WebElement playlistToRename = driver.findElement(By.cssSelector("[href='#!/playlist/59529']"));
        Actions action = new Actions(driver);
        action.contextClick(playlistToRename).perform();
    }
}