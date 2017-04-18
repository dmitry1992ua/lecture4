package templates;

import org.openqa.selenium.WebDriver;

/**
 * Created by dmitr on 17.04.2017.
 */
public class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
