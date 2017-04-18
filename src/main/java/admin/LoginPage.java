package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import templates.BasePage;

/**
 * Created by dmitr on 17.04.2017.
 */
public class LoginPage extends BasePage {

    private By loginFieldLocator = By.id("email");
    private By passwordFieldLocator = By.id("passwd");
    private By loginButtonLocator = By.className("ladda-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Авторизация в системе")
    public DashboardPage login(String userName, String password) {
        driver.findElement(loginFieldLocator).sendKeys(userName);
        driver.findElement(passwordFieldLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        return new DashboardPage(driver);
    }
}
