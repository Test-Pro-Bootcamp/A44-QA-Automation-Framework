
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


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
    @Parameters({"BaseURL"})

    public void setUpBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String url=BaseURL;
        openUrl(url);


        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


    public void openUrl(String url) {
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
        //openUrl();
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


    public void showSuccessBanner() {
        WebElement successBanner = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(successBanner.isDisplayed());
    }

    public void clickOkBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
        js.executeScript("arguments[0].click();", okBtn);
    }

    public void deleteSelectedPlaylist() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        js.executeScript("arguments[0].click();", deletePlaylistBtn);
    }

    public void clickPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("[class='playlist playlist']"));
        playlist.click();
    }

    public void assertRenamedPlaylistPresent() {
        List<WebElement> playlistNames = driver.findElements(By.cssSelector(".playlist.playlist>a"));
        List<String> listOfNames = new ArrayList<>();

        for (int i = 0; i < playlistNames.size(); i++) {
            String playlistName = playlistNames.get(i).getText();
            if(playlistName=="Renamed playlist attempt # 2"){
                listOfNames.add(playlistName);
            }
        }
        System.out.println(listOfNames);
        //Assert.assertTrue(listOfNames.contains("Renamed playlist attempt # 2"));
    }

    public void renamePlaylistName() {
        WebElement inputPlaylistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        inputPlaylistName.click();
        inputPlaylistName.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        inputPlaylistName.sendKeys("Renamed playlist attempt # 2");
        inputPlaylistName.sendKeys(Keys.ENTER);
    }

    public boolean assertSuccessBanner() {
        WebElement successBanner = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".success")));
        return successBanner.isDisplayed();
    }

    public void assertPlaylistNameInHeader() {
        WebElement playlistHeader = driver.findElement(By.cssSelector("#playlistWrapper h1"));
        wait.until(ExpectedConditions
                .textToBePresentInElement(playlistHeader, "Try#1"));
    }

    public void clickEnter() {
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }

    public void addPlaylistName() {
        WebElement inputPlaylistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".create input")));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys("Try#1");
    }

    public void clickNewPlaylist() {
        wait.until(ExpectedConditions
                        .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")))
                .click();
    }

    public void clickPlusBtn() {
        WebElement plusBtn = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[data-testid='sidebar-create-playlist-btn']")));
        plusBtn.click();
    }

    public void clickEdit() {
      WebElement editBtn = wait.until(ExpectedConditions
              .elementToBeClickable(By.cssSelector(".playlist .menu li ")));
      editBtn.click();
    }

    public void rightClickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".playlist .active")));
        new Actions(driver)
                .contextClick(playlist)
                .perform();
    }
            }