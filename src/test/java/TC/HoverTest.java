package TC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.time.Duration;

public class HoverTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // نجهّز كروم درايفر
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testHoverOnProfileIcon() throws InterruptedException {
        // افتح الموقع
        driver.get("https://cartlow.com/uae/en");

        // Locator للأيقونة
        By profileIcon = By.xpath("//span[@aria-label='Profile Info' or contains(@class,'icon-users') or contains(@class,'profile')]");

        // نعمل Hover
        WebElement icon = driver.findElement(profileIcon);
        Actions actions = new Actions(driver);
        actions.moveToElement(icon).perform();

        System.out.println("✅ Hover done on profile icon");

        // نوقف شوية عشان نلاحظ التأثير
        Thread.sleep(3000);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
