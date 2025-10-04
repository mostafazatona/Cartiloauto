package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResults_page extends BasePage {

    public SearchResults_page(WebDriver driver) {
        super(driver);
    }

    // XPath لأول منتج يظهر في النتائج
    private final By firstProduct = By.xpath("//*[@id=\"main\"]/div/div/div[2]/div[2]/div[2]/div/div[1]/a");

    // يضغط على أول منتج
    public void clickFirstProduct() {
        WebElement product = driver.findElement(firstProduct);
        scrollInto(product);
        product.click();
    }
}
