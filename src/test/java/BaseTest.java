import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


/**
 * Created by dmitr on 17.04.2017.
 */
public class BaseTest {

    protected WebDriver driver;
    private static final String ADMIN_URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    protected static final String STORE_URL = "http://prestashop-automation.qatestlab.com.ua";

    @BeforeClass()
    @Parameters("browser")
    public void setUp(String browser) {
        driver = WebDriverFactory.initWebDriver(browser);
        driver.get(ADMIN_URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
