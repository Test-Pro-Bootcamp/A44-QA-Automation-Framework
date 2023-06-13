package stepDefinition;

import Pages.HomePage;
import Pages.LoginPage;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

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
        String gridURL = "http://192.168.0.18:4444";
        switch (browser) {
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-edge":
                capabilities.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            //case "cloud":
                //return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
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
        loginPage.enterEmail("stella_26021987@mail.ru");
    }

    @And("I enter password")
    public void iEnterPassword() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.enterPassword("te$t$tudent");
    }

    @And("I click submit button")
    public void iClickSubmitButton() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.clickLoginBtn();
    }

    @Then("I am successfully logged in")
    public void iAmSuccessfullyLoggedIn() {
        HomePage homePage = new HomePage(getThreadLocal());
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }
    @When("I click play button")
    public void iClickPlayButton() {
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.clickPlayBtn();
    }

    @Then("I see pause button")
    public void iSeePauseButton() {
        HomePage homePage = new HomePage(getThreadLocal());
        homePage.assertPauseBtn();
    }
}