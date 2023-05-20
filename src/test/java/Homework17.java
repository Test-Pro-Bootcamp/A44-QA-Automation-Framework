import org.testng.annotations.Test;


public class Homework17 extends BaseTest{

    @Test

    public void addSongToPlaylist(){
        openUrl();
        enterEmail("stella_26021987@mail.ru");
        enterPassword("te$t$tudent");
        clickLoginBtn();

    }

}
