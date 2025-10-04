package pages;

import org.openqa.selenium.*;
import org.testng.Assert;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By checkoutBtn = By.xpath("//*[@id='main']/div[2]/div/div[2]/div/div[2]/div/a");

    public void assertCheckoutLink() {
        WebElement btn = vis(checkoutBtn);
        String href = btn.getAttribute("href");
        Assert.assertEquals(href, "https://cartlow.com/uae/en/checkout/onepage",
                "❌ Checkout link is incorrect!");
        System.out.println("✅ Checkout link verified: " + href);
    }

    public void proceedToCheckout() {
        WebElement btn = vis(checkoutBtn);
        scrollInto(btn);
        btn.click();
        System.out.println("✅ Proceeded to Checkout");
    }
}
