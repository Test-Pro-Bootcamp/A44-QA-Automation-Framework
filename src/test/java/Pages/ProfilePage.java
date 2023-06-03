package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By avatarIcon = By.cssSelector(".avatar");
    By profileBar = By.cssSelector("#favoritesWrapper>.screen-header");
    By listOfThemes = By.cssSelector(".themes li");
    By themeColor = By.cssSelector("[class='theme selected']");

    public void assertThemeChanged() {
        WebElement selectedTheme = wait.until(ExpectedConditions.presenceOfElementLocated(themeColor));
        Assert.assertTrue(selectedTheme.isEnabled());
        System.out.println("The selected theme is " + selectedTheme.getText());
    }

    public void clickRandomTheme() {
        List<WebElement> themes = driver.findElements(listOfThemes);
        Random random = new Random();
        int randomValue = random.nextInt(themes.size());
        themes.get(randomValue).click();
    }

    public boolean isProfilePageOpen() {
        WebElement profile = wait.until(ExpectedConditions.presenceOfElementLocated(profileBar));
        return profile.isDisplayed();
    }

    public void clickAvatar() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement avatar = wait.until(ExpectedConditions.elementToBeClickable(avatarIcon));
        js.executeScript("arguments[0].click();", avatar);
    }
}