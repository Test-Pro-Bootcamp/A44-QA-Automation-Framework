import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.annotations.Test;

public class Practice extends BaseTest {
    @Test

    public void changeTheme(){
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        loginPage.login("stella_26021987@mail.ru", "te$t$tudent");
        profilePage.clickAvatar();
        profilePage.isProfilePageOpen();
        profilePage.clickRandomTheme();
        profilePage.assertThemeChanged();
    }
}