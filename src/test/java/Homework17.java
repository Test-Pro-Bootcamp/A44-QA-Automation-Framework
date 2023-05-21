import org.testng.annotations.Test;


public class Homework17 extends BaseTest{

    @Test

    public void addSongToPlaylist(){
        openUrl();
        enterEmail("stella_26021987@mail.ru");
        enterPassword("te$t$tudent");
        clickLoginBtn();

        searchSong("Pluto");
        waitCommand();
        clickViewAllBtn();
        clickFirstSong();
        waitCommand();
        clickAddToBtn();
        playlistNameInput("Practice");
        clickSave();




    }

}
