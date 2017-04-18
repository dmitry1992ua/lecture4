import admin.CreateProductPage;
import admin.DashboardPage;
import admin.LoginPage;
import admin.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import store.AllProductsPage;
import store.MainStorePage;
import store.ProductPage;

/**
 * Created by dmitr on 17.04.2017.
 */
public class CreateProductTest extends BaseTest {

    private String productName;
    private String productQuantity;
    private String productPrice;

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                { "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw" }
        };
    }

    @Title("Проверка авторизации")
    @Test(dataProvider = "loginData")
    public void login(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
    }

    @Title("Проверка создания нового товара")
    @Test(dependsOnMethods = "login")
    public void createProduct() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        ProductsPage productsPage = dashboardPage.openProductPage();
        CreateProductPage createProductPage = productsPage.openCpeateProductPage();
        productName = createProductPage.enterProductName();
        productQuantity = createProductPage.enterProductquantity();
        productPrice = createProductPage.enterProductPrise();
        createProductPage.activateProduct();
        createProductPage.saveProduct();
    }

    @Title("Проверка наличия созданного товара на сайте")
    @Test(dependsOnMethods = "createProduct")
    public void checkProductInStore() {
        driver.get(STORE_URL);
        AllProductsPage allProductsPage = new MainStorePage(driver).moveToAllProductsPage();
        ProductPage productPage = allProductsPage.openProductPage(productName);
        Assert.assertTrue(productPage.getProductName().equals(productName.toLowerCase())
                && productPage.getProductPrice().equals(productPrice)
                && productPage.getProductQuantity().equals(productQuantity));
    }
}
