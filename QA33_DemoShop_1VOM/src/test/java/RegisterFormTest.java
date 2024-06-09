import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.REGISTER_USER;

public class RegisterFormTest extends TestBase {
    @BeforeMethod
    @Step ("Проверяем наличие кнопки Register, если ее нет нажимаем кнопку Log out")
    void precondition() {
        if (!app.getRegisterFormHelper().isRegisterLinkPresent()) {
            app.getHomePageHelper().clickOnLogOutInLink();
        }
        }

    @Test (description = "регистрация нового пользователя", groups = {"Positive"})
    @Step("Проверка регистрации нового пользователя")
    void  registerPositiveTest(){
        app.getRegisterFormHelper().isRegisterLinkPresent();
        app.getRegisterFormHelper().fillRegisterForm(REGISTER_USER);
        app.getRegisterFormHelper().clickOnRegisterButton();
        app.getRegisterFormHelper().isRegisterConfirmationPresent();
        Assert.assertEquals( "Your registration completed", app.registerFormHelper.isRegisterConfirmationPresent(), "Registration form is not completed");
    }
    }


