package page_helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageHelper extends BaseHelper{
    public LoginPageHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Переходим на страницу авторизации")
    public void clickOnHomeLink() {
        clickOnElement(By.cssSelector("[href='/login']"));
    }

    @Step("Проверяем отображение 'Register'")
    public boolean checkHomeComponentIsPresent() {
        return isElementPresent(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

    }
}
