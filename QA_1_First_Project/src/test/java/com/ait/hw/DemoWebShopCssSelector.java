package com.ait.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class DemoWebShopCssSelector extends BaseTest {
    @Test
    @DisplayName("Css тесты")
    void test1() {

        driver.get(URL_DemoWebShopCssSelector);
        //tagName -> tag div
//        ListWebElement tagName = driver.findElement(By.tagName("div"));
        List<WebElement> listDivElements = driver.findElements(By.cssSelector("div"));
        Assertions.assertFalse(listDivElements.isEmpty(), "Нет элементов с тэгом \"div\"");

        //By.id -> #id
        WebElement elementById = driver.findElement(By.cssSelector("#dialog-notification-success"));
//        WebElement elementById = driver.findElement(By.id("dialog-notification-success"));
//        Assertions.assertEquals("dialog-notification-success", elementById.getAttribute("id") );

        //class -> .class
//        WebElement elementByClass = driver.findElement(By.className("search-box"))
        WebElement elementByClass = driver.findElement(By.cssSelector(".search-box"));
//        WebElement elementByClass = driver.findElement(By.cssSelector("class='search-box'"))
        Assertions.assertEquals("search-box", elementByClass.getCssValue("class"));

        //name, type, href и по остальным любым атрибутам ->
        WebElement elementByAtr = driver.findElement(By.cssSelector("[href='/search']"));

        //Вниз по дереву body img
        WebElement elementByCss = driver.findElement(By.cssSelector("body img"));

        /*
            class='ng-untouched ng-pristine ng-invalid'"
            contains -> *=      By.cssSelector("[class*='ng-pristine']")
            start With -> ^=    By.cssSelector("[class^='ng-untouched']")
            end on -> $=        By.cssSelector("[class$='ng-invalid']")
        */
    }

    @Test
    @DisplayName("Проверка работы всплывающего уведомления")
    void test2() {
        driver.get(URL_DemoWebShopCssSelector);
        WebElement loginLink = getElementBy(By.cssSelector("[href='/login']"));
        loginLink.click();

        WebElement loginButton = getElementBy(By.cssSelector("button[name='login']"));
        loginButton.click();

        Alert alert = getAlert();
        Assertions.assertEquals("Wrong email or password", alert.getText(), "Текст всплывающего уведомления не соответствует ожидаемому");
        alert.accept();

        WebElement errorTextElement = getElementBy(By.cssSelector("[class='login_login__3EHKB'] div"));
        Assertions.assertEquals("Login Failed with code 401", errorTextElement.getText(), "Текст ошибки не соответствует ожидаемому");
    }

}


