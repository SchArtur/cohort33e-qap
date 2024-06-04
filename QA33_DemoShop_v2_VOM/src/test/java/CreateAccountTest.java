import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.NEW_USER;

public class CreateAccountTest extends BaseTest{

    @BeforeMethod
    void precondition() {
        if (!app.getLoginHelper().isLoginLinkPresent()) {
            app.getLoginHelper().clickOnLogOutButton();
        }
    }

    @Test
    void registerAccountPositiveTest(){
        app.getCreateAccountHelper().clickOnRegisterLink();
        app.getCreateAccountHelper().clickOnGenderCheckbox();
        app.getCreateAccountHelper().fillRegisterForm(NEW_USER);
        app.getCreateAccountHelper().clickOnRegisterButton();
        Assert.assertTrue(app.getCreateAccountHelper().isConfirmationPresent());
    }
}
