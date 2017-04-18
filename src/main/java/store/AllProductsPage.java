package store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import templates.BasePage;

/**
 * Created by dmitr on 17.04.2017.
 */
public class AllProductsPage extends BasePage {

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открывем страницу товара")
    public ProductPage openProductPage(String name) {
        driver.get(getProductUrl(name));
        return new ProductPage(driver);
    }

    private String getProductUrl(String name) {
        return driver.findElement(By.xpath("//a[contains(text(), \"" + name + "\")]")).getAttribute("href");
    }
}
