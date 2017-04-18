import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmitr on 17.04.2017.
 */
public class WebDriverFactory {

    private static String property = System.getProperty("user.dir") + "/drivers/";

    public static WebDriver initWebDriver(String browserName) {
        WebDriver driver;
        switch (browserName) {
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", property + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox" :
                System.setProperty("webdriver.gecko.driver", property + "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "ie" :
                System.setProperty("webdriver.ie.driver", property + "IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
