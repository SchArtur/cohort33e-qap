import io.qameta.allure.Step;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static core.AppManager.LOGIN_USER;
public class AddToCartTest extends TestBase {

    @BeforeMethod
    @Step ("Авторизуемся под зарегистрированным пользователем нажимая кнопку Log in")
    void precondition() {
        if (!app.getHomePageHelper().checkForLogInComponentIsPresent()) {
            app.getHomePageHelper().clickOnLogOutInLink();
        }
    }

    @Test (description = "добавления товара в корзину", groups = {"Positive"})
    @Step ("Проверка добавления товара в корзину")
    void addToCartPositiveTest() {
        app.addToCartHelper.fillLoginForm(LOGIN_USER);
        app.addToCartHelper.clickOnLoginButton();
        if (!app.addToCartHelper.isLoggedIn()) throw new AssertionError();
        app.addToCartHelper.openCart();
        app.addToCartHelper.clearCartIfNotEmpty();
        app.addToCartHelper.addItemToCart();
        app.addToCartHelper.isItemInCart();

    }
}




