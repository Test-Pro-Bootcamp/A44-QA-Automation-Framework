import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() {
//      Added ChromeOptions argument below to fix websocket error
        login("grigore.crepciuc@testpro.io", "te$t$tudent");
        clickPlaylist();
        deleteSelectedPlaylist();
        waitCommand();
        clickOkBtn();
        showSuccessBanner();
    }
}
