package store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import templates.BasePage;

/**
 * Created by dmitr on 17.04.2017.
 */
public class MainStorePage extends BasePage{

    private By allProductsButtonLocator = By.className("all-product-link");

    public MainStorePage(WebDriver driver) {
        super(driver);
    }

    @Step("Переходим к странице \"Все товары\"")
    public AllProductsPage moveToAllProductsPage() {
        driver.findElement(allProductsButtonLocator).click();
        return new AllProductsPage(driver);
    }
}
