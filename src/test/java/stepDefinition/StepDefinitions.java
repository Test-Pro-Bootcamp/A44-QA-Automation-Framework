package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

import java.time.Duration;

public class StepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


    @Given("I open Login Page")
    public void openLoginPage(){
        driver.get("https://qa.koel.app/");
    }

    @When("I enter email")
    public void iEnterEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("demo@class.com");
    }

    @And("I enter password")
    public void iEnterPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("te$t$tudent");
    }

    @And("I click submit")
    public void iClickSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getAvatar());
    }

    @When("I enter wrong email")
    public void iEnterWrongEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("demo@class.co");
    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isSubmitLoginBtnDisplayed());
    }

    @And("I click play button")
    public void clickPlayBtn(){
        SongsPage songsPage = new SongsPage(driver);
        songsPage.startPlaySong();
    }

    @Then("I see equalizer")
    public void iSeeEqualizer() {
        SongsPage songsPage = new SongsPage(driver);
        Assert.assertTrue(songsPage.isEqualizerDisplayed());
    }

    @And("I enter wrong password")
    public void iEnterWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("te$t$tuden");
    }

    @And("I click pause button")
    public void iClickPauseButton() {
        SongsPage songsPage = new SongsPage(driver);
        songsPage.clickPauseBtn();
    }

    @Then("I see equalizer has been disappeared")
    public void iSeeEqualizerHasBeenDisappeared() {
        SongsPage songsPage = new SongsPage(driver);
        Assert.assertFalse(songsPage.isEqualizerDisplayed());
    }
}
