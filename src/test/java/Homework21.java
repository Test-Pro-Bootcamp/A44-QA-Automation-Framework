import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() {
        login("stella_26021987@mail.ru", "te$t$tudent");
        clickPlusBtn();
        clickNewPlaylist();
        addPlaylistName();
        clickEnter();
        assertPlaylistNameInHeader();
        assertSuccessBanner();

        rightClickOnPlaylist();
        clickEdit();
        renamePlaylistName();
        assertSuccessBanner();
        assertRenamedPlaylistPresent();
    }
}