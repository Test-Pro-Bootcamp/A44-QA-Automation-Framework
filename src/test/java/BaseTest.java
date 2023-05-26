import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class BaseTest {
    static WebDriver driver;


    @BeforeSuite
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
     public void setUpBrowser(String BaseURL){
     //   public void setUpBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     //   String url = "https://bbb.testpro.io/";
       String  url = BaseURL;
        openUrl(url);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public String generateRandomName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }

    public String generateRandomPlaylistName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }

    protected void clickLoginBtn() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    protected void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void openUrl(String url) {
        driver.get(url);
    }


    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }

    public void searchForSong(String text) {
        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    public String getSongName(){
        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        return songText;
    }

    public boolean isBannerDisplayed(){
        WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        return successBanner.isDisplayed();
    }

    public void createNewPlaylistWhileAddingSong(String playlistName) {
        WebElement newPlaylistNameInput = driver.findElement(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }

    public void clickAddToPlaylistBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void clickFirstSearchResultSong() {
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

}