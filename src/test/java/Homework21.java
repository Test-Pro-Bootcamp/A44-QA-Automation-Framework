import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylistByContextMenu() {
        String newPlaylistName = "Excellent songs";
        login("demo@class.com", "te$t$tudent");
        contextClickPlaylist();
        Assert.assertTrue(isEditBtnAppeared());
        clickEditBtnOfContextMenu();




    }

    public boolean isEditBtnAppeared() {
        WebElement editBtn = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-edit-59529']"));
        return editBtn.isDisplayed();
    }

    private void clickEditBtnOfContextMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-edit-59529']"))).click();
    }

    private void contextClickPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("Great Music_777")));
        WebElement playlistToRename = driver.findElement(By.cssSelector("Great Music_777"));
        Actions action = new Actions(driver);
        action.contextClick(playlistToRename).perform();
    }
}