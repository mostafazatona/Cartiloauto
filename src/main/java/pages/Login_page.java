package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login_page {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By emailField = By.id("identifier");
    By continueBtn = By.xpath("//*[@id=\"main\"]/div/div/div[2]/div/div/div/form/div[2]/button");
    By passwordField = By.id("password");
    By signInBtn = By.xpath("//*[@id=\"main\"]/div/div/div[2]/div/div/div/form/div[2]/button");

    public Login_page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driver.findElement(continueBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driver.findElement(signInBtn).click();
    }
}
