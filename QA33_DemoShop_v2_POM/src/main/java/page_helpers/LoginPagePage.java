package page_helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePage extends BasePage {

    @FindBy(css = "[href='/login']")
    WebElement loginLink;

    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement login;

    @Step("Переходим на страницу авторизации")
    public void clickOnHomeLink() {
        clickOnElement(loginLink);
    }

    @Step("Проверяем отображение 'Register'")
    public boolean checkRegisterIsPresent() {
        return login.isDisplayed();

    }
}
