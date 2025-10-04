package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // ================= Locators =================

    // زر Add To Cart
    private final By addToCartBtn = By.xpath("//*[@id='main']/div[2]/form/div/div/div[2]/div[6]/button");

    // زر View in Cart
    private final By viewCartBtn = By.xpath("//*[@id='main']/div[2]/form/div/div/div[2]/div[6]/a");

    // اختيارات الساعة
    private final By colorSilver = By.xpath("//label[contains(.,'Silver')]");
    private final By size44mm = By.xpath("//label[contains(.,'44mm')]");
    private final By connectivityGPS = By.xpath("//label[contains(.,'GPS and Cellular')]");

    // زر زيادة الكمية (+)
    private final By plusQtyBtn = By.xpath("//button[contains(@class,'increase') or text()='+']");

    // =================================================

    // ✅ اختيار اللون Silver
    public void selectColorSilver() {
        try {
            WebElement color = vis(colorSilver);
            scrollInto(color);
            color.click();
            System.out.println("✔ تم اختيار اللون Silver");
        } catch (Exception e) {
            System.out.println("⚠️ لم أستطع اختيار اللون Silver");
        }
    }

    // ✅ اختيار الحجم 44mm
    public void selectSize44mm() {
        try {
            WebElement size = vis(size44mm);
            scrollInto(size);
            size.click();
            System.out.println("✔ تم اختيار الحجم 44mm");
        } catch (Exception e) {
            System.out.println("⚠️ لم أستطع اختيار الحجم 44mm");
        }
    }

    // ✅ اختيار Connectivity: GPS and Cellular
    public void selectConnectivityGPS() {
        try {
            WebElement conn = vis(connectivityGPS);
            scrollInto(conn);
            conn.click();
            System.out.println("✔ تم اختيار Connectivity: GPS and Cellular");
        } catch (Exception e) {
            System.out.println("⚠️ لم أستطع اختيار Connectivity GPS");
        }
    }

    // ✅ محاولة زيادة الكمية
    public void tryIncreaseQty() {
        try {
            WebElement plusBtn = driver.findElement(plusQtyBtn);
            scrollInto(plusBtn);
            plusBtn.click();
            System.out.println("✔ تم زيادة الكمية");
        } catch (Exception e) {
            System.out.println("⚠️ لم أستطع زيادة الكمية → Skip");
        }
    }

    // ✅ إضافة الساعة + View in Cart (مع Scroll)
    public void addWatchWithOptions() {
        // 1- اختيارات الساعة
        selectColorSilver();
        selectSize44mm();
        selectConnectivityGPS();

        // 2- Scroll + Add to Cart
        WebElement addBtn = vis(addToCartBtn);
        scrollInto(addBtn);
        addBtn.click();
        System.out.println("✔ تم إضافة الساعة للسلة");

        // 3- Scroll للتأكد إن View in Cart ظاهر
        scrollBy(200);

        WebElement viewCart = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(viewCartBtn));
        viewCart.click();
        System.out.println("✔ تم الضغط على View in Cart");
    }

    // ✅ إضافة أي منتج عادي بدون اختيارات (مثلاً Dell Laptop)
    public void addToCart() {
        try {
            WebElement addBtn = vis(addToCartBtn);
            scrollInto(addBtn);
            addBtn.click();
            System.out.println("✔ تم إضافة المنتج للسلة");
        } catch (Exception e) {
            System.out.println("⚠️ لم أستطع الضغط على Add to Cart");
        }
    }
}
