package com.ait.appuim.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import static com.ait.appuim.pages.LoginPage.TypeFieldError.EMAIL_FIELD_ERROR;

public class LoginPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\").instance(0)")
    WebElement loginTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
    WebElement signUpTab;

    @AndroidFindBy(accessibility = "input-email")
    WebElement emailField;

    @AndroidFindBy(accessibility = "input-password")
    WebElement passwordField;

    @AndroidFindBy(accessibility = "input-repeat-password")
    WebElement repeatPasswordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"LOGIN\")")
    WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SIGN UP\")")
    WebElement signUpButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter the same password\")")
    WebElement errorMsgRepeatPasswordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter a valid email address\")")
    WebElement errorMsgEmailField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter at least 8 characters\")")
    WebElement errorMsgPasswordField;

    @Step("Заполняем поле email")
    public LoginPage fillEmailField(String email) {
        fillInputField(emailField, email);
        return this;
    }

    @Step("Заполняем поле password")
    public LoginPage fillPasswordField(String password) {
        fillInputField(passwordField, password);
        return this;
    }

    @Step("Заполняем поле repeat password")
    public LoginPage fillRepeatPasswordField(String password) {
        fillInputField(repeatPasswordField, password);
        return this;
    }

    @Step("нажимаем на вкладку Login")
    public LoginPage tapOnLoginTab() {
        tapOnElement(loginTab);
        return this;
    }

    @Step("Нажимаем на кнопку LOGIN")
    public LoginPage tapOnLoginButton() {
        tapOnElement(loginButton);
        return this;
    }

    @Step("нажимаем на вкладку Sign Up")
    public LoginPage tapOnSignUpTab() {
        tapOnElement(signUpTab);
        return this;
    }

    @Step("Нажимаем на кнопку SIGN UP")
    public LoginPage tapOnSignUpButton() {
        tapOnElement(signUpButton);
        return this;
    }

    @Step("Проверяем текст всплывающего уведомления")
    public LoginPage checkMessage(String msg) {
        Assertions.assertTrue(getAlertText().contains(msg), "текст уведомления не содержит ожидаемый");
        return this;
    }

    public void checkErrorIsDisplayed(TypeFieldError error) {
        switch (error) {
            case EMAIL_FIELD_ERROR -> checkElementIsPresent(errorMsgEmailField);
            case PASSWORD_FIELD_ERROR -> checkElementIsPresent(errorMsgPasswordField);
            case REPEAT_PASSWORD_FIELD_ERROR -> checkElementIsPresent(repeatPasswordField);
        }
    }

    public enum TypeFieldError {
        EMAIL_FIELD_ERROR,
        PASSWORD_FIELD_ERROR,
        REPEAT_PASSWORD_FIELD_ERROR
    }
}
