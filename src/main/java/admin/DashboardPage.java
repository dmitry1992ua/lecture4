package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import templates.BasePage;

/**
 * Created by dmitr on 17.04.2017.
 */
public class DashboardPage extends BasePage {

    private By catalogButtonLocator = By.xpath("//span[contains(text(), 'Каталог')]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открываем страницу \"Товары\"")
    public ProductsPage openProductPage() {
        driver.findElement(catalogButtonLocator).click();
        return new ProductsPage(driver);
    }

}
