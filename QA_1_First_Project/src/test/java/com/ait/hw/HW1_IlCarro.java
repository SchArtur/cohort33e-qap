package com.ait.hw;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HW1_IlCarro {

    private static final String URL="https://ilcarro.web.app/";
    private WebDriver driver;
    @BeforeEach
    public void startDriver() {
        driver= new ChromeDriver();
        driver.get(" https://ilcarro.web.app/");
    }
    @AfterEach
    public void quitDriver() {
        if (driver != null){
            driver.quit();
        }
    }
  @Test
// проверяем отображение заголовка сайта
  @DisplayName("Check the Site`s Title")
    public void testTitle(){
         driver.getTitle();
      assertEquals("ilCARRO", driver.getTitle(),
              "Оpen link https://ilcarro.web.app/search, Title must be ilCARRO" );
  }
  //проверяем отображение логотипа
    public void testLogoPresence(){
        WebElement logo = driver.findElement(By.className("header_logo"));
        assertTrue(logo.isDisplayed(),"Logo must be pointed on the main page");
    }
    //проверяем поиск слова/ссылки  Registration
    public void testSearchFunctionality(){
        WebElement searchField = driver.findElement(By.name("search"));
        searchField.sendKeys("Registration");
        searchField.submit();
        WebElement searchResult = driver.findElement(By.className("search-result"));
        assertTrue(searchResult.isDisplayed(), "The Result of search must be displayed");

        String searchResultText=searchResult.getText();
        assertTrue(searchResultText.contains("Registration"),"The result must contains  - Registration ");
    }
    //проверяем процесс регистрации по шагам
    public void testRegistration(){
        //находим и кликаем ссылку "Sign Up"
        WebElement signUpLink=driver.findElement(By.linkText("Sign Up"));
        signUpLink.click();
        //заполняем форму регистрации
        WebElement nameField =driver.findElement(By.name("Name"));
        nameField.sendKeys("Lilian");
        WebElement lastNameField =driver.findElement(By.name("Last name"));
        lastNameField.sendKeys("Lilo");
        WebElement emailField =driver.findElement(By.name("Email"));
        emailField.sendKeys("test@test.com");
        WebElement passwordField =driver.findElement(By.name("Password"));
        passwordField.sendKeys("Pass123456789!");
        WebElement termsCheckbox =driver.findElement(By.name("terms of use and privacy policy"));
        termsCheckbox.click();
        //Отправляем форму, но ТУТ БАГ - ПИШЕТ, ЧТО АККАУНТ С ТАКИМ ИМЕНЕМ УЖЕ ЕСТЬ!!!
        WebElement sighUpButton =driver.findElement(By.cssSelector("button[type=Yalla"));
        sighUpButton.click();
        //ожидание перехода на страницу регистрации
        WebElement confirmMessage =driver.findElement(By.className("Confirmation of rergistration"));
        Assert.notNull(confirmMessage, "Must appear registration notification");
    }


    //проверяем поиск элемента Log in
    public void testNavigationMenuLinks(){
        WebElement logInLink= (WebElement) driver.findElements(By.linkText("Log in"));
        assertTrue(logInLink.isDisplayed(),"The Link Log in must be dispalyed in novigation list");
        logInLink.click();
        assertEquals("https://ilcarro.web.app/login", driver.getCurrentUrl(),"You shoud be taken to the Log in page");
    }
    //проверяем список элементов в футере
    public void testFooterLinks(){
        List<WebElement> footerLinks  = driver.findElements(By.cssSelector(".footer_ _link"));
        assertTrue(footerLinks.size()>0, " In Footer must be at least one link");
    }

}
