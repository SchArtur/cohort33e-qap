package page_helpers;

import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHelper extends BaseHelper {
    public LoginHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step (" Представлени элемент по локатору Log in")
    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//*[text()='Log in']"));
    }
    // return isElementPresent(By.xpath("//a[@class='ico-login']"));

   @Step ("Кликаем на линк Log in ")
    public void clickOnLoginLink() {
        clickOnElement(By.xpath("//*[text()='Log in']"));
    }

    @Step("Заполняемм данные зарегистрированного пользователя для входа в аккаунт")
    public void fillLoginForm(User user) {
        fillInputField(By.id("Email"), user.getEmail());
        fillInputField(By.id("Password"), user.getPassword() );
    }

    @Step("Нажимаем кнопку Log in, для завершения входа в аккаунт")
    public void clickOnLoginButton() {
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));

        // или по clickOnElement(By.cssSelector("[value='Log in']"));
    }
    @Step("Представлен элемент Log out")
    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.xpath("//*[text()='Log out']"));
    }
    @Step("Нажимаем на кнопку Log out")
    public void clickOnLogOutButton() {
       clickOnElement(By.xpath("//*[text()='Log out']"));
    }
    // clickOnElement(By.xpath("//a[@class='ico-logout']"));
}

