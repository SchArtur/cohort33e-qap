package com.webshop.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginPageTests extends BaseTest {

    @Test
    @Tag("@Positive")
    @Tag("@SMOKE")
    @DisplayName("Проверка успешной авторизации")
    void loginTest () {
        clickOnElement(By.xpath("//*[text()='Log in']"));
        fillInputField(By.id("Email"), "antonantonov@gmail.com");
        fillInputField(By.id("Password"), "WvN3W$VUTA72T");
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));

        Assertions.assertTrue(getElementBy(By.xpath("//*[text()='Log out']")).isDisplayed(), "Отсутствует кнопка выхода ");

    }
}
