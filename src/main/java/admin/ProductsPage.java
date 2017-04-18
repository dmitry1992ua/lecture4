package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import templates.BasePage;

/**
 * Created by dmitr on 17.04.2017.
 */
public class ProductsPage extends BasePage {

    private By createProductButtonLocator = By.id("page-header-desc-configuration-add");

    protected ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открываем страницу создания товара")
    public CreateProductPage openCpeateProductPage() {
        driver.findElement(createProductButtonLocator).click();
        return new CreateProductPage(driver);
    }

}
