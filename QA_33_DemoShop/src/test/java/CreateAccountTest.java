import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.BooleanSupplier;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.xpath;

public class CreateAccountTest extends TestBase {
    private Alert fillRegistrationForm;

    @Test
    @DisplayName("Проверка посика элемента по xpath ")
    void registerTest() {
        driver.get(DEMO_SHOP_URL);
        Assertions.assertEquals(true, getElementBy(xpath("//*[@href='/register']")).isDisplayed());

    }
    @Test
    @DisplayName("Проверка отображения информации по ссылке Register")
    void clickRegister(){
        clickOnElement(xpath("//*[contains(text(),'Demo Web Shop. Register')]"));
        Assertions.assertEquals("Demo Web Shop. Register",  "Register form is not found");
    }
    @Test
    @DisplayName("Проверка cсоздания и  успешной регистрации нового аккаунта")
    private void fillRegistrationForm (){

        //Создаем объект для ввода данных в форму регистрации
        RegisterForm userForm = new RegisterForm( "male", "John", "Tramp", "JohnTramp@test.com", "Pass123!", "Pass123!");

        //Заполняем форму регистрации

        WebElement genderElemnt = null;
        if ("male".equals(genderElemnt)){
            getElementBy(By.id("gender-male"));
        }else {
            getElementBy(By.id("gender-female"));
        }
        genderElemnt.click();

        fillInputField(By.name("First name "), userForm.getFirstName());
        fillInputField(By.name("Last name "), userForm.getLastName());
        fillInputField(By.name("Email"), userForm.getEmail());
        fillInputField(By.name("Password"), userForm.getPassword());
        fillInputField(By.name("Confirm password"), userForm.getConfirmPassword());

        //находим и нажимаем кнопку Register, после ввода всех данных в поля регистрации
        getElementBy(xpath("//*[@action='/register']")).click();
        Alert alert= getAlert();
        Assertions.assertEquals("Your registration completed", fillRegistrationForm.getText(), "Registration form is not complited");

        // переходим к сохранению акккаунта
        getElementBy(xpath("//*[@class='button-1 register-continue-button']")).click();
        Assertions. assertEquals("Continue", fillRegistrationForm.getText(), "Registration form is not complited");
        // Проверяем переход на страницу "My account-Customer Info"


        //нажимаем кнопку "save" для сохранения данных созданного аккаунта
        getElementBy(xpath("//*[@class='button-1 save-customer-info-button']")).click();
        Assertions.assertEquals("Save", fillRegistrationForm.getText(), "Registration form is not complited");

        //завершение регистрации нового аккаунта через выход "Log out"
        getElementBy(xpath("//*[contains(text(),'Log out')]")).click();
        Assertions.assertEquals("Log out", fillRegistrationForm.getText(), "Registration form is not complited");
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

