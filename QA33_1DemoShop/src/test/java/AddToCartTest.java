import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static core.AppManager.LOGIN_USER;
public class AddToCartTest extends TestBase {

    @BeforeMethod
    void precondition() {
        if (!app.getLoginHelper().isLoginLinkPresent()) {
            app.getHomePageHelper().clickOnLogOutInLink();
        }
    }

    @Test
    void addToCartPositiveTest() {
        app.addToCartHelper.fillLoginForm(LOGIN_USER);
        app.addToCartHelper.clickOnLoginButton();
        app.addToCartHelper.isLoggedIn();
        app.addToCartHelper.openCart();
        app.addToCartHelper.clearCartIfNotEmpty();
        app.addToCartHelper.addItemToCart();
        app.addToCartHelper.isItemInCart();

    }
}




