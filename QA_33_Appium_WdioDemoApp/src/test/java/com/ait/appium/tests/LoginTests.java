package com.ait.appium.tests;

import com.ait.appuim.pages.BottomPanel;
import com.ait.appuim.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ait.appuim.pages.LoginPage.TypeFieldError.REPEAT_PASSWORD_FIELD_ERROR;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("Проверка авторизация с валидными данными")
    void test1() {
        new BottomPanel().tapOnLoginInPanel()
                .tapOnLoginTab()
                .fillEmailField("test@gmail.com")
                .fillPasswordField("qwertY123!")
                .tapOnLoginButton()
                .checkMessage("You are logged in!");
    }

    @Test
    @DisplayName("Проверка регистрации с валидными данными")
    void test2() {
        new BottomPanel().tapOnLoginInPanel()
                .tapOnSignUpTab()
                .fillEmailField("test@gmail.com")
                .fillPasswordField("qwertY123!")
                .fillRepeatPasswordField("qwertY123!")
                .tapOnSignUpButton()
                .checkMessage("You successfully signed up!");
    }

    @Test
    @DisplayName("Проверка регистрации с ошибкой в поле повторного ввода пароля")
    void test3() {
        new BottomPanel().tapOnLoginInPanel()
                .tapOnSignUpTab()
                .fillEmailField("test@gmail.com")
                .fillPasswordField("qwertY123!")
                .fillRepeatPasswordField("qwertY12")
                .tapOnSignUpButton()
                .checkErrorIsDisplayed(REPEAT_PASSWORD_FIELD_ERROR);
    }

}
