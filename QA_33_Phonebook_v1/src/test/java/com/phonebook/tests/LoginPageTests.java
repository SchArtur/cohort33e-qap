package com.phonebook.tests;

import com.phonebook.tests.data.User;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.Random;

@Tag("@LoginTests")
@Tag("@REGRESS")
public class LoginPageTests extends BaseTest {

    @Test
    @Tag("@Positive")
    @Tag("@SMOKE")
    @DisplayName("Проверка успешной авторизации")
    void loginTest1() {
        loginOrRegistration(TEST_USER, LOGIN);
        Assertions.assertTrue(getElementBy(By.xpath("//*[text()='Sign Out']")).isDisplayed(), "Отсутствует кнопка выхода ");
    }

    @Test
    @Tag("@NEGATIVE")
    @Tag("@SMOKE")
    @DisplayName("Проверка ввода неверного логина")
    void loginTest2() {
        loginOrRegistration(new User("manuelgm.com", "Manuel1234$"), LOGIN);
        Alert alert = getAlert();
        Assertions.assertEquals("Wrong email or password", alert.getText(), "Отсутствует кнопка выхода ");
        alert.accept();

        WebElement errorTextElement = getElementBy(By.xpath("//*[contains(text(), '401')]"));
        Assertions.assertEquals("Login Failed with code 401", errorTextElement.getText(), "Текст ошибки не соответствует ожидаемому");
    }

    @Test
    @Tag("@NEGATIVE")
    @DisplayName("Проверка ввода неверного пароля")
    void loginTest3() {
        loginOrRegistration(new User("manuel@gm.com", "Manue$"), LOGIN);
        Alert alert = getAlert();
        Assertions.assertEquals("Wrong email or password", alert.getText(), "Отсутствует кнопка выхода ");
        alert.accept();

        WebElement errorTextElement = getElementBy(By.xpath("//*[contains(text(), '401')]"));
        Assertions.assertEquals("Login Failed with code 401", errorTextElement.getText(), "Текст ошибки не соответствует ожидаемому");
    }

    @Test
    @Tag("@Positive")
    @Tag("@SMOKE")
    @Disabled
    @DisplayName("Проверка успешной регистрации")
    void registrationTest1() {
        loginOrRegistration(new User(randomEmail(), "Manuel1234$"), REGISTRATION);
        Assertions.assertTrue(getElementBy(By.xpath("//*[text()='Sign Out']")).isDisplayed(), "Отсутствует кнопка выхода ");
    }

    @Test
    @Tag("@NEGATIVE")
    @DisplayName("Проверка ввода неверного пароля")
    void registrationTest2() {
        loginOrRegistration(new User("manuel@gm.com", "Manue$"), REGISTRATION);
        Alert alert = getAlert();
        Assertions.assertTrue(alert.getText().contains("Wrong email or password format"),"Отсутствует кнопка выхода ");
        alert.accept();

        WebElement errorTextElement = getElementBy(By.xpath("//*[contains(text(), '401')]"));
        Assertions.assertEquals("Login Failed with code 400", errorTextElement.getText(), "Текст ошибки не соответствует ожидаемому");
    }

    private static String randomEmail() {
        char[] chars = "0123456789abcdef".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[8];
        for (int i = 0; i < result.length; i++) {
            int randomIndex = random.nextInt(chars.length);
            result[i] = chars[randomIndex];
        }
        String email = new String(result) + "@test.com";
        return email;
    }

}