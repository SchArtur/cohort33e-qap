
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.TEST_USER;

public class LoginTests extends BaseTest {

    @BeforeMethod
    void precondition() {
        if (!app.getUserHelper().isLoginLinkPresent()) {
            app.getUserHelper().clickOnSigOutButton();
        }
    }

    @Test
    void loginPositiveTest() {
        app.getUserHelper().clickOnLoginLink();
        app.getUserHelper().fillLoginRegisterForm(TEST_USER);
        app.getUserHelper().clickOnLoginButton();
        Assert.assertTrue(app.getUserHelper().isSignOutButtonPresent());
    }
}
