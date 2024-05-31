package webshoptest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginPageTest extends TestBase {

    @Test
    @DisplayName("Verification of successful logging")
    void loginTest() {
        clickOnElement(By.xpath("//*[text()='Log in']"));
        fillInputField(By.id("Email"), "ivanivanov2@gmail.com");
        fillInputField(By.id("Password"), "GhUl20DsaVx");
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));

        Assertions.assertTrue(getElementBy(By.xpath("//*[text()='Log out']")).isDisplayed(), "The exit button is missing");
    }

}
