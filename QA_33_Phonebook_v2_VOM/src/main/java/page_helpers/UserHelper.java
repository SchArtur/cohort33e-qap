package page_helpers;

import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.AppManager.TEST_USER;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Проверяем наличие кнопки 'Sign Out'")
    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    @Step("Проверяем наличие кнопки 'LOGIN'")
    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//*[text()='LOGIN']"));
    }

    @Step("Нажимаем на кнопку 'LOGIN' в заголовке")
    public void clickOnLoginLink() {
        clickOnElement(By.xpath("//*[text()='LOGIN']"));
    }

    @Step("Нажимаем на кнопку 'login'")
    public void clickOnLoginButton() {
        clickOnElement(By.name("login"));
    }

    @Step("Нажимаем на кнопку 'registration'")
    public void clickOnRegistrationButton() {
        clickOnElement(By.name("registration"));
    }

    @Step("Нажимаем на кнопку 'Sign Out'")
    public void clickOnSigOutButton() {
        clickOnElement(By.xpath("//*[text()='Sign Out']"));
    }

    @Step("Заполняем данные пользователя")
    public void fillLoginRegisterForm(User user) {
        fillInputField(By.name("email"), user.getEmail());
        fillInputField(By.name("password"), user.getPassword());
    }
    @Step("Получаем сообщение об ошибке на странице")
    public String getMessageLoginFailed() {
        return getElementBy(By.xpath("//*[contains(text(), 'Login Failed')]")).getText();
    }
    @Step("Авторизуемся под тестовым пользователем")
    public void loginTestUser() {
        clickOnLoginLink();
        fillLoginRegisterForm(TEST_USER);
        clickOnLoginButton();
    }
}
