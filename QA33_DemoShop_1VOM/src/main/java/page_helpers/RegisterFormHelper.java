package page_helpers;

import io.qameta.allure.Step;
import model.RegisterForm;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterFormHelper extends BaseHelper {

    public RegisterFormHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

   @Step(" Проверка наличия линка Register для регистрации нового пользователя")
    public boolean isRegisterLinkPresent() {

        return isElementPresent(By.xpath("//a[@class='ico-register']"));
    }
    @Step("Кликаем на линк Register для регистрации нового пользователя")
    public void clickOnRegisterLink() {
        //clickOnElement(By.xpath("//*[text()='Register']"));
        clickOnElement(By.xpath("//a[class='ico-register']"));
    }

    @Step("Заполняем форму регистрации")
    public void fillRegisterForm(@NotNull RegisterForm registerForm) {

        if (registerForm.getGender().equals("male")) {
            getElementBy(By.id("gender-male")).click();
        } else {
            getElementBy(By.id("gender-female")).click();
        }

        fillInputField(By.id("FirstName"), registerForm.getFirstName());
        fillInputField(By.id("LastName"), registerForm.getLastName());
        fillInputField(By.id("Email"), registerForm.getEmail());
        fillInputField(By.id("Password"), registerForm.getPassword());
        fillInputField(By.id("ConfirmPassword"), registerForm.getConfirmPassword());
    }

    @Step("Кликаем на кнопку Register для завершения регистрации нового пользователя")
    public void clickOnRegisterButton() {
        clickOnElement(By.xpath("//input[@id='register-button']"));
        //clickOnElement(By.id("register-button"));
        // или по clickOnElement(By.cssSelector("[class='button-1 register-next-step-button']"));
    }

    @Step("Полдучаем уведомление о подтверждении завершния успешной  регистрации")
    public boolean isRegisterConfirmationPresent() {
        return isElementPresent(By.xpath("//*[text()='Your registration completed']"));
        // (By.xpath("//div[@class=class='result']));
    }
}
