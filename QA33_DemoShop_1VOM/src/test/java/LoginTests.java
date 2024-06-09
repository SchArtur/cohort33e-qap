import core.DataProviders;
import io.qameta.allure.Step;
import model.User;
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

    @Test(description = "логин зарегистрированного пользователя", groups = {"Positive"})
    @Step ("Проверка логина зарегистрированного пользователя")
    void loginPositiveTest() {
        app.getLoginHelper().clickOnLoginLink();
        app.getLoginHelper().fillLoginForm(LOGIN_USER);
        app.getLoginHelper().clickOnLoginButton();
        Assert.assertTrue(app.getLoginHelper().isLogOutLinkPresent());

    }

    @Test(dataProvider = "logInUsers", dataProviderClass = DataProviders.class)
    void successLogInUsersTestDataProvider(User user) {
        app.getLoginHelper().clickOnLoginLink();
        app.getLoginHelper().fillLoginForm(user);
        app.getLoginHelper().clickOnLoginButton();
        Assert.assertTrue(app.getLoginHelper().isLogOutLinkPresent());

    }


}
