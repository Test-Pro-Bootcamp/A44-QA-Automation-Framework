import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework20 extends  BaseTest {

    @Test

    public void deletePlaylist() throws InterruptedException {

        openUrl();
        enterEmail("andrei.bryliakov01@testpro.io");
        enterPassword("te$t$tudent");
        clickLoginBtn();

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("pluto");

        WebElement submitView = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']")));
        submitView.click();
    }
}