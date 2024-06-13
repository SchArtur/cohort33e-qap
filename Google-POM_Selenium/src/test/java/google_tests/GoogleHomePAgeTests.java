package google_tests;

import core.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static core.AppManager.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleHomePAgeTests extends BaseTest {

    @BeforeEach
    public void precondition(){
        basePage.open("https://www.google.com");
    }

    @Test
    public void test1(){
        System.out.println("Test");
    }

    @Feature("Google Home page tests")
    @Story("Test case 1")
    @DisplayName("Suche 'Katzen'")
    @Order(1)
    //@RepeatedTest(value = 5, name = "{displayName} :: итерация [{currentRepetition}] из [{totalRepetitions}]")
    @Test
    public void searchTest(){
        homePage.clickTermButton();
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Katzen");
//        driver.findElement(By.cssSelector("testarea[name='q']")).sendKeys("Katze");
//        driver.findElement(By.name("q")).sendKeys("Katze");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.RETURN);
        assertTrue(driver.findElement(By.id("search23")).isDisplayed());
    }

}
