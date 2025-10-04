package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Home_page {
    WebDriver driver;

    // Locators
    By profileIcon = By.cssSelector("span.icon-users");
    By signInButton = By.xpath("//a[contains(text(),'Sign In')]");
    By searchBox = By.name("query");
    By searchButton = By.cssSelector("div.icon-search");

    public Home_page(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOnProfileIcon() {
        WebElement profile = driver.findElement(profileIcon);
        Actions actions = new Actions(driver);
        actions.moveToElement(profile).perform();
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void searchFor(String keyword) {
        WebElement box = driver.findElement(searchBox);
        box.clear();
        box.sendKeys(keyword);
        driver.findElement(searchButton).click();
    }
}
