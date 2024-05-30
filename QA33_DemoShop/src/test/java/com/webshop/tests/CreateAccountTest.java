package com.webshop.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.security.SecureRandom;
import java.util.Random;

public class CreateAccountTest extends BaseTest{

    @Test
    @Tag("@Positive")
    @Tag("@SMOKE")
    @DisplayName("Проверка успешной регистрации")
    void createAccountTest() {
        clickOnElement(By.xpath("//*[text()='Register']"));
        clickOnElement(By.xpath("//*[@id='gender-male']"));

        fillInputField(By.id("FirstName"), "Anton");
        fillInputField(By.id("LastName"), "Antonov");
        fillInputField(By.id("Email"), randomEmail());
        fillInputField(By.id("Password"), "WvN3W$VUTA72T");
        fillInputField(By.id("ConfirmPassword"), "WvN3W$VUTA72T");

        clickOnElement(By.xpath("//*[@id='register-button']"));

        Assertions.assertTrue(getElementBy(By.xpath("//div[@class='result']")).isDisplayed(), "Отсутствует сообщения подтверждения регистрации выхода ");
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
