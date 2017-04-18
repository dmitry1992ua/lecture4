package store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import templates.BasePage;

/**
 * Created by dmitr on 17.04.2017.
 */
public class ProductPage extends BasePage {

    private By productNameLocator = By.className("h1");
    private By productPriceLocator = By.cssSelector(".current-price>span");
    private By productQuantitiesLocator = By.cssSelector(".product-quantities>span");

    public ProductPage(WebDriver driver) {
        super(driver);
        waitForPageLoad();
    }

    @Step("Получаем имя товара")
    public String getProductName() {
        return driver.findElement(productNameLocator).getText().toLowerCase();
    }

    @Step("Получаем количество товара")
    public String getProductQuantity() {
        return driver.findElement(productQuantitiesLocator).getText().split(" ")[0];
    }

    @Step("Получаем стоимость товара")
    public String getProductPrice() {
        return driver.findElement(productPriceLocator).getAttribute("content");
    }

    private void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("add-to-cart"))));
    }
}
