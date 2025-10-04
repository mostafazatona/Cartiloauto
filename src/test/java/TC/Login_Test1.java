package TC;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Home_page;
import pages.Login_page;
import pages.SearchResults_page;
import pages.ProductPage;
import pages.CartPage;

import java.time.Duration;

public class Login_Test1 {

    WebDriver driver;
    Home_page home;
    Login_page login;
    SearchResults_page results;
    ProductPage productDetail;
    CartPage cart;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        home = new Home_page(driver);
        login = new Login_page(driver);
        results = new SearchResults_page(driver);
        productDetail = new ProductPage(driver);
        cart = new CartPage(driver);
    }

    @Test
    public void testLoginAndCartFlow() throws InterruptedException {
        driver.get("https://cartlow.com/uae/en");

        // 1- Login
        home.hoverOnProfileIcon();
        home.clickSignIn();
        login.login("mostafaelcatinmax@gmail.com", "123456@Mw");
        Thread.sleep(2000);

        // 2- Search Laptop Dell
        home.searchFor("Dell Latitude 7490");
        results.clickFirstProduct();
        productDetail.addToCart();   // Laptop
        driver.navigate().back();

        // 3- Search Apple Watch + Options + Add To Cart + ViewCart
        home.searchFor("Apple Watch Series 6");
        results.clickFirstProduct();
        productDetail.addWatchWithOptions();
        Thread.sleep(2000);


        // 6- الضغط على Checkout
        cart.proceedToCheckout();
        Thread.sleep(2000);

        // 7- تحقق من الانتقال للـ Checkout Page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/checkout/onepage"), "❌ لم يتم الانتقال لصفحة Checkout");

        System.out.println("✅ Flow مكتمل: Login → Dell → Watch → Cart → Remove Dell → Checkout");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
