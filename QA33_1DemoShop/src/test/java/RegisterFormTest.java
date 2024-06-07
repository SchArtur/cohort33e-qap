import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.REGISTER_USER;

public class RegisterFormTest extends TestBase {
    @BeforeMethod
    void precondition() {
        if (!app.getRegisterFormHelper().isRegisterLinkPresent()) {
            app.getHomePageHelper().clickOnLogOutInLink();
        }
        }

    @Test
    void  registerPositiveTest(){
        app.getRegisterFormHelper().fillRegisterForm(REGISTER_USER);
        app.getRegisterFormHelper().clickOnRegisterButton();
        app.getRegisterFormHelper().isRegisterConfirmationPresent();
        Assert.assertEquals( "Your registration completed", app.registerFormHelper.isRegisterConfirmationPresent(), "Registration form is not completed");
    }
    }


