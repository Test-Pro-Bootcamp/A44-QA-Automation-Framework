package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Locale;

public class BasePage {

    public WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    By successBanner = By.cssSelector(".success");

public BasePage( WebDriver givenDriver ){
    driver = givenDriver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    actions = new Actions(driver);
    PageFactory.initElements(driver, this);
}

    public WebElement waitUntilVisible(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitUntilClickable(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isSuccessBannerDisplayed(){
        return driver.findElement(successBanner).isDisplayed();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public String generateRandomName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }
}
