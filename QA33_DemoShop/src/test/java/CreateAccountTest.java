import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class CreateAccountTest extends TestBase {


    @Test
    @DisplayName("Проверка посика элемента по xpath ")
    void registerTest() {
        driver.get(DEMO_SHOP_URL);
        Assertions.assertEquals(true, getElementBy(By.xpath("//*[@href='/register']")).isDisplayed());

    }

    @Test
    @DisplayName("Проверка cсоздания и  успешной регистрации нового аккаунта")
    void fillRegistrationForm() {
        //Создаем объект для ввода данных в форму регистрации
        RegisterForm userForm = new RegisterForm("male", "John", "Tramp", "JohnTramp5@test.com", "Pass123!", "Pass123!");

        //ОТкрываем форму регистрации
        clickOnElement(By.linkText("Register"));
        //Заполняем форму регистрации


        if ("male".equals(userForm.getGender())) {
            getElementBy(By.id("gender-male")).click();
        } else {
            getElementBy(By.id("gender-female")).click();
        }


        fillInputField(By.xpath("//*[@id='FirstName']"), userForm.getFirstName());
        fillInputField(By.xpath("//*[@id='LastName']"), userForm.getLastName());
        fillInputField(By.xpath("//*[@id='Email']"), userForm.getEmail());
        fillInputField(By.xpath("//*[@id='Password']"), userForm.getPassword());
        fillInputField(By.xpath("//*[@id='ConfirmPassword']"), userForm.getConfirmPassword());

        //находим и нажимаем кнопку Register, после ввода всех данных в поля регистрации
        clickOnElement(By.id("register-button"));

        // Убеждаемся в успешной регистрации
        WebElement confirmationMessage = getElementBy(By.className("result"));
        Assertions.assertEquals("Your registration completed", confirmationMessage.getText(), "Registration form is not completed");

        //завершение регистрации нового аккаунта через выход "Log out"
        clickOnElement(By.xpath("//*[contains(text(),'Log out')]"));

    }

    private void click() {

    }

    // Пример из классной работы

 /*   protected void register(String email, String password, String loginOrRegistration) {
        clickOnElement(By.xpath("//*[text()='LOGIN']"));
        fillInputField(By.name("email"), email);
        fillInputField(By.name("password"), password);
        if (LOGIN.equals(loginOrRegistration)) {
            clickOnElement(By.name("login"));
        } else if (REGISTRATION.equals(loginOrRegistration)) {
            clickOnElement(By.name("registration"));
        }
    }

    protected void loginTestUser() {
        login("manuel@gm.com", "Manuel1234$","Login");
    }*/
}

