package webshoptest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.security.SecureRandom;
import java.util.Random;

public class CreateAccountTest extends TestBase {

    @Test
    @Tag("@Positive")
    @Tag("@SMOKE")
    @DisplayName("Checking of successful registration")
    void createAccountTest() {
        clickOnElement(By.xpath("//*[text()= 'Register']"));
        clickOnElement(By.xpath("//*[@id='gender-male']"));

        fillInputField(By.id("FirstName"), "Ivan");
        fillInputField(By.id("LastName"), "Ivanov");
        fillInputField(By.id("Email"), randomEmail());
        fillInputField(By.id("Password"), "GhUl20DsaVx");
        fillInputField(By.id("ConfirmPassword"), "GhUl20DsaVx");

        clickOnElement(By.xpath("//*[@id='register-button']"));
        Assertions.assertTrue(getElementBy(By.cssSelector("[class='result']")).getText().contains("Your registration completed"),  "There is no confirmation message for exit registration");


    }

    private static String randomEmail() {
        char[] chars = "0123456789acked".toCharArray();
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
