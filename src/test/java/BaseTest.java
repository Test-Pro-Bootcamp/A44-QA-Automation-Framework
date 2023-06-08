
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class BaseTest {
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    public static WebDriver driver=null;
    public static String url="https://qa.koel.app/";
    public static WebDriverWait wait=null;

    //@BeforeSuite
    //static void setupDriver() {
    //WebDriverManager.chromedriver().setup();
    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }
    @BeforeMethod
    //@Parameters({"BaseURL"})
    public void setUpBrowser() throws MalformedURLException {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--disable-notifications");

        //driver = pickBrowser(System.getProperty("browser"));
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //String url=BaseURL;
        //openUrl(url);

        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getThreadLocal().get(url);
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        //driver.quit();
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
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                return driver = new ChromeDriver(options);
        }
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "zhuldyzsyrlybayeva";
        String authkey = "wKnnVUCz7PatZVRtmxuXZAM8RdQFpcAFTqNefStg7zrB8usPbH";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Firefox");
        caps.setCapability("version", "112.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }
    //public void openUrl(String url) {
        //driver.get(url);}

    public void waitCommand() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void assertRenamedPlaylistPresent() {
        List<WebElement> playlistNames = driver.findElements(By.cssSelector(".playlist.playlist>a"));
        List<String> listOfNames = new ArrayList<>();

        for (int i = 0; i < playlistNames.size(); i++) {
            String playlistName = playlistNames.get(i).getText();
            if (playlistName.equals("Renamed playlist attempt # 2")) {
                listOfNames.add(playlistName);
            }

        }
        System.out.println(listOfNames);
    }
}