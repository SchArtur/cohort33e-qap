import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.LOGIN_USER;

public class LoginTests extends TestBase {
    @BeforeMethod
    void precondition() {
        if (!app.getLoginHelper().isLoginLinkPresent()) {
            app.getLoginHelper().clickOnLogOutButton();
        }

    }

    @Test
    void loginPositiveTest() {
        app.getLoginHelper().clickOnLoginLink();
        app.getLoginHelper().fillLoginForm(LOGIN_USER);
        app.getLoginHelper().clickOnLoginButton();
        Assert.assertTrue(app.getLoginHelper().isLogOutLinkPresent());

    }
}
