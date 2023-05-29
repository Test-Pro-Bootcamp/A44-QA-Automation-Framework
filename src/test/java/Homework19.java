import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test

    public void deletePlaylist(){

//        openUrl();
        enterEmail("andrei.bryliakov01@testpro.io");
        enterPassword("te$t$tudent");
        clickLoginBtn();

            WebElement submitPlayList = driver.findElement(By.xpath("(//li[@class='playlist playlist'])[2]"));
            submitPlayList.click();

        WebElement pressXPlayList = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        pressXPlayList.click();

            WebElement submitDeleteOK = driver.findElement(By.cssSelector("[class='ok']"));
            submitDeleteOK.click();

        WebElement createdPlaylist = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(createdPlaylist.isDisplayed());

    }

}
//        public void pressXPlayList() {
//        }
//        public void choosePlayList() {
//        }
//        public void submitDeleteOK() {
//        }
//        choosePlayList();
//        pressXPlayList();
//        submitDeleteOK();