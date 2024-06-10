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

    @Test(description = "1 Проверка успешного логина зарегистрированного пользователя", groups = {"Positive"})
    @Step ("1 Проверка успешного логина зарегистрированного пользователя")
    void loginPositiveTest() {
        app.getLoginHelper().clickOnLoginLink();
        app.getLoginHelper().fillLoginForm(LOGIN_USER);
        app.getLoginHelper().clickOnLoginButton();
        Assert.assertTrue(app.getLoginHelper().isLogOutLinkPresent());

    }



    @Test (description = "2 Проверка неуспешного логина  зарегистрированного пользователя", groups = {"Negative"})
    @Step ("2 Проверка неуспешного  логина зарегистрированного пользователя")
    void loginNegativeTest1() {
        app.getLoginHelper().clickOnLoginLink();
        User user = new User("Tramptest.com","Tramp123!");
        app.getLoginHelper().fillLoginForm(user);
        app.getLoginHelper().clickOnLoginButton();
        Assert.assertTrue(app.getLoginHelper().getAlertText().contains("Please enter a valid email address"));
    //<span class="field-validation-error" data-valmsg-for="Email" data-valmsg-replace="true"><span for="Email" class="">Please enter a valid email address.</span></span>
    }

    @Test (description = "3 Проверка неуспешного логина  зарегистрированного пользователя", groups = {"Negative"})
    @Step ("3 Проверка неуспешного  логина зарегистрированного пользователя")
    void loginNegativeTest2() {
        app.getLoginHelper().clickOnLoginLink();
        User user = new User("Tramp@test.com","Tramp123");
        app.getLoginHelper().fillLoginForm(user);
        app.getLoginHelper().clickOnLoginButton();
        Assert.assertTrue(app.getLoginHelper().getAlertText().contains("Login was unsuccessful. Please correct the errors and try again."));
    //<span>Login was unsuccessful. Please correct the errors and try again.</span>
    }


    @Test(dataProvider = "logInUsers", dataProviderClass = DataProviders.class)
    @Step (" 4 Проверка логина зарегистрированного пользователя через dataProvider")
    void successLogInUsersTestDataProvider(User user) {
        app.getLoginHelper().clickOnLoginLink();
        app.getLoginHelper().fillLoginForm(user);
        app.getLoginHelper().clickOnLoginButton();
        Assert.assertTrue(app.getLoginHelper().isLogOutLinkPresent());

    }

    @Test(dataProvider = "logInUsers", dataProviderClass = DataProviders.class)
    @Step("2  Проверка логина зарегистрированного пользователя через dataProvider и файл 'users.csv'")
    void successLogInTestDataProviderFromCsv(User user, String result) {
        app.getLoginHelper().clickOnLoginLink();
        app.getLoginHelper().fillLoginForm(user);
        app.getLoginHelper().clickOnLoginButton();

        if (result.equals("passed")) {
            app.getLoginHelper().waitInSeconds(3);
            Assert.assertTrue(app.getLoginHelper().isLogOutLinkPresent(), "Неуспешный логин");
            app.getLoginHelper().waitInSeconds(1);
        } else {
            Assert.assertTrue(app.getLoginHelper().getAlertText().contains("Login was unsuccessful. Please correct the errors and try again"),
                    "Сообщение в уведомлении не содержит 'Login was unsuccessful. Please correct the errors and try again'");
        }

    }
}
