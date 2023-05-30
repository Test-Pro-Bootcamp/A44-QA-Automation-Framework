
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.Locale;



public class BaseTest {
    static WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod

    public void setUpBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


    public void openUrl() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public void clickLoginBtn() {
        WebElement submitLogin = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitLogin.click();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void searchSong(String song) {
        WebElement searchInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(song);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickViewAllBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement viewAllBtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']")));
        js.executeScript("arguments[0].click();", viewAllBtn);

    }

    public void clickFirstSong() {
        WebElement searchSong = driver.findElement(By.cssSelector("[class='song-list-wrap main-scroll-wrap search-results'] .items"));
        searchSong.click();
    }

    public void waitCommand() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickAddToBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement addToBtn = driver.findElement(By.cssSelector(".btn-add-to"));
        js.executeScript("arguments[0].click();", addToBtn);

    }

    public void playlistNameInput(String playlistName) {
        WebElement nameInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']")));
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(playlistName);
    }

    public void clickSave() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement saveBtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[id='songResultsWrapper'] [type='submit']")));
        js.executeScript("arguments[0].click();", saveBtn);

        WebElement successBanner = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        Assert.assertTrue(successBanner.isDisplayed());
    }

    public void login(String email, String password) {
        openUrl();
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }

    public void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        new Actions(driver)
                .moveToElement(playBtn)
                .perform();
        playBtn.click();
    }

    public void assertPauseBtn() {
        WebElement pauseBtn = driver.findElement(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
            }

}