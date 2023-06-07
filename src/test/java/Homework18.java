import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test

    public void playSong() {
        openUrl();
        login("grigore.crepciuc@testpro.io", "te$t$tudent");
        clickPlayBtn();
        assertPauseBtn();
    }
}

