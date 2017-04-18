package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import templates.BasePage;

import java.text.DecimalFormat;

/**
 * Created by dmitr on 17.04.2017.
 */
public class CreateProductPage extends BasePage {

    private By quantityFieldLocator = By.id("form_step1_qty_0_shortcut");
    private By priceFieldLocator = By.id("form_step1_price_shortcut");
    private By switchInputLocator = By.className("switch-input");
    private By growlCloseButtonLocator = By.className("growl-close");
    private By submitButtonLocator = By.id("submit");

    public CreateProductPage(WebDriver driver) {
        super(driver);
        waitForPageLoad(driver);
    }

    @Step("Вводим имя товара")
    public String enterProductName() {
        String name = generateProductName();
        ((JavascriptExecutor)driver).executeScript(
                ("$('#form_step1_name_1').val('" + name + "');"));
        return name;
    }

    @Step("Вводим стоимость товара")
    public String enterProductPrise() {
        String price = generatePrice();
        driver.findElement(priceFieldLocator).clear();
        driver.findElement(priceFieldLocator).sendKeys(price);
        return price.replace(",", ".");
    }

    @Step("Вводим количество товара")
    public String enterProductquantity() {
        String quantity = generateQuantity();
        driver.findElement(quantityFieldLocator).clear();
        driver.findElement(quantityFieldLocator).click();
        driver.findElement(quantityFieldLocator).sendKeys(quantity);
        return quantity;
    }

    @Step("Активируем товар")
    public void activateProduct() {
        driver.findElement(switchInputLocator).click();
        closeGrowlMessage();
    }

    @Step("Сохраняем")
    public void saveProduct() {
        driver.findElement(submitButtonLocator).click();
        closeGrowlMessage();
    }

    @Step("Закрываем всплывающее сообщение")
    private void closeGrowlMessage() {
        driver.findElement(growlCloseButtonLocator).click();
    }

    @Step("Генерируем имя продукта")
    private String generateProductName() {
        String name = "TestProduct" + System.currentTimeMillis();
        return name;
    }

    @Step("Генерируем количество товара")
    private String generateQuantity() {
        return String.valueOf(1 + (int)(Math.random() * ((100 - 1) + 1)));
    }

    @Step("Генерируем стоимость товара")
    private String generatePrice() {
        double d = Math.random() * ((100 - 0.1) + 0.1);
        DecimalFormat decimalFormat = new DecimalFormat("##0.0");
        String format = decimalFormat.format(d);
        if (format.toCharArray()[format.length() - 1] == '0') {
            return format.substring(0, format.length() - 2);
        }
        return format;
    }

    private void waitForPageLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10, 500);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), \"Сводка\")]"))));
    }
}
