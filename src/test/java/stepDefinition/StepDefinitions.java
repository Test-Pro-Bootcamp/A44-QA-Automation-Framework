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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.SongsPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class StepDefinitions {








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
}
