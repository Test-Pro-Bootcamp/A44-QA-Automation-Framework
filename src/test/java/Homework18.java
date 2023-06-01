import org.testng.annotations.Test;


public class Homework18 extends BaseTest {

    @Test

    public void playSong() {
        login("stella_26021987@mail.ru", "te$t$tudent");
        clickPlayBtn();
        assertPauseBtn();
    }
}


