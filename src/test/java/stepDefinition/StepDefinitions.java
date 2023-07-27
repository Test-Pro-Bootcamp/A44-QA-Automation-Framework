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
//import pages.SongsPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class StepDefinitions {
    public static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    public static WebDriver driver = null;

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    @Before
    public void openBrowser() throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown(){
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.0.159:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
//            case "cloud":
//                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                // options.addArguments("--headless=new");
                return driver = new ChromeDriver(options);
        }
    }


    @Given("I open Login Page")
    public void openLoginPage(){
        getThreadLocal().get("https://qa.koel.app/");
    }

    @When("I enter email")
    public void iEnterEmail() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.enterEmail("demo@class.com");
    }

    @And("I enter password")
    public void iEnterPassword() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.enterPassword("te$t$tudent");
    }

    @And("I click submit")
    public void iClickSubmit() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.clickLoginBtn();
    }

    @Then("I logged in")
    public void iLoggedIn() {
        HomePage homePage = new HomePage(getThreadLocal());
        Assert.assertTrue(homePage.getAvatar());
    }

  /*  @And("I click play button")
    public void clickPlayBtn(){
        SongsPage songsPage = new SongsPage(getThreadLocal());
        songsPage.startPlaySong();
    }

    @Then("I see equalizer")
    public void iSeeEqualizer() {
        SongsPage songsPage = new SongsPage(getThreadLocal());
        Assert.assertTrue(songsPage.isEqualizerDisplayed());
    }*/
}