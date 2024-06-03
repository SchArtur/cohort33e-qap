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
    /*@Test
    @DisplayName("Проверка отображения информации по ссылке Register")
    void clickRegister(){
        clickOnElement(By.linkText("Register"));
        Assertions.assertTrue(clickRegister).isDisplayed(),  "Register form is not found");
    }*/
    @Test
    @DisplayName("Проверка cсоздания и  успешной регистрации нового аккаунта")
    private void fillRegistrationForm (){

        //Создаем объект для ввода данных в форму регистрации
        RegisterForm userForm = new RegisterForm( "male", "John", "Tramp", "JohnTramp@test.com", "Pass123!", "Pass123!");

        //ОТкрываем форму регистрации
        clickOnElement(By.linkText("Register"));
        //Заполняем форму регистрации

        WebElement genderElemnt = null;
        if ("male".equals(genderElemnt)){
            getElementBy(By.id("gender-male"));
        }else {
            getElementBy(By.id("gender-female"));
        }
        genderElemnt.click();

        fillInputField(By.xpath("//*[@for='FirstName']"), userForm.getFirstName());
        fillInputField(By.xpath("//*[@for='LasttName']"), userForm.getLastName());
        fillInputField(By.xpath("//*[@for='Email']"), userForm.getEmail());
        fillInputField(By.xpath("//*[@for='Password']"), userForm.getPassword());
        fillInputField(By.xpath("//*[@for='Confirm password'`]"), userForm.getConfirmPassword());

        //находим и нажимаем кнопку Register, после ввода всех данных в поля регистрации
        getElementBy(By.id("register-button"));
        clickOnElement(By.id("register-button"));

        // Убеждаемся в успешной регистрации
        WebElement confirmationMessage=getElementBy(By.className("result"));
        Assertions.assertEquals("Your registration completed", confirmationMessage.getText(), "Registration form is not completed");

        // переходим к сохранению акккаунта
        getElementBy(xpath("//*[@class='button-1 register-continue-button']"));
        clickOnElement(By.xpath("//*[@class='button-1 register-continue-button']"));
        Assertions. assertEquals("Continue", fillRegistrationForm.getText(), "Registration form is not complited");

        // Проверяем переход на страницу "My account-Customer Info" кликаем по эмайлу на месте слова Register
        WebElement myAccountTitle= getElementBy(By.xpath("//*[contains(text(), 'My account - Customer info']"));
        Assertions.assertTrue(myAccountTitle.isDisplayed(), "Page is not found");

        //нажимаем кнопку "save" для сохранения данных созданного аккаунта
        WebElement saveAccount =getElementBy(xpath("//*[@class='button-1 save-customer-info-button']"));
        clickOnElement(By.xpath("//*[contains(text(), 'Save']"));
        Assertions.assertEquals("Save", saveAccount.getText(), "Registration form is not completed");

        //завершение регистрации нового аккаунта через выход "Log out"
        WebElement lodOut =getElementBy(xpath("//*[contains(text(),'Log out')]"));
        clickOnElement(By.linkText("Log out"));
        Assertions.assertEquals("Log out", lodOut.getText(), "Registration form is not complited");
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

