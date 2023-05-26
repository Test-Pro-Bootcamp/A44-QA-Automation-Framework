import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() {
//      Added ChromeOptions argument below to fix websocket error
        login("stella_26021987@mail.ru", "te$t$tudent");
        clickPlaylist();
        deleteSelectedPlaylist();
        waitCommand();
        clickOkBtn();
        showSuccessBanner();
    }
}
