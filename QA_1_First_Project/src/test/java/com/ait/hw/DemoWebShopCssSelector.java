package com.ait.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DemoWebShopCssSelector extends BaseTest {

    @Test
    @DisplayName("Css тесты")
    void test1() {
        driver.get(URL_DemoWebShopCssSelector);
        //tagName -> tag div
        List<WebElement> tagName = driver.findElements(By.tagName("div"));
        List<WebElement> listDivElements = driver.findElements(By.cssSelector("div"));
        Assertions.assertFalse(tagName.isEmpty(), "Нет элементов с тэгом \"div\"");
        Assertions.assertFalse(listDivElements.isEmpty(), "Нет элементов с тэгом \"div\"");

        //By.id -> #id
        WebElement elementById = driver.findElement(By.cssSelector("#dialog-notifications-success"));
        Assertions.assertTrue(elementById.getAttribute("title").equals("Notification"), "elementById нет на странице");
        //тот же элелмент по ID, но проверяемый By.id
        WebElement elementById1 = driver.findElement(By.id("dialog-notifications-success"));
        WebElement elementById2 = driver.findElement(By.cssSelector("[id*='notifications-success']"));
        WebElement elementById3 = driver.findElement(By.cssSelector("[id^='dialog-notifications']"));
        WebElement elementById4 = driver.findElement(By.cssSelector("[id$='-success']"));
        Assertions.assertEquals("dialog-notifications-success", elementById1.getAttribute("id"));
        Assertions.assertEquals("Notification", elementById2.getAttribute("title"), "elementById2 нет на странице");
        Assertions.assertEquals("Notification", elementById3.getAttribute("title"), "elementById3 нет на странице");
        Assertions.assertEquals("Notification", elementById4.getAttribute("title"), "elementById4 нет на странице");


        //class -> .class
        WebElement elementByClass1 = driver.findElement(By.className("search-box"));
        Assertions.assertTrue(elementByClass1.isDisplayed(), "elementByClass1 нет на странице");
        // точка впереди означает class (".search-box")
        WebElement elementByClass = driver.findElement(By.cssSelector(".search-box"));
        assertEquals("search-box", elementByClass.getAttribute("class"));

        WebElement elementByClass2 = driver.findElement(By.cssSelector("[class='search-box']"));
        assertEquals("search-box", elementByClass2.getAttribute("class"));

        //name, type, href и по остальным любым атрибутам ->
        WebElement elementByAtr = driver.findElement(By.cssSelector("[href='/about-us']"));
        assertEquals("About us", elementByAtr.getText());

        WebElement elementByType = driver.findElement(By.cssSelector("[type='submit']"));
        assertEquals("submit", elementByType.getAttribute("type")); //чтио писать в getCssValue(properyName - type or Submit)?!!!!!!*/

        //Вниз по дереву body img
        WebElement elementByCss = driver.findElement(By.cssSelector("div[class='header-logo'] img"));
        assertTrue(elementByCss.isDisplayed());// с этим разобраться еще раз на уроке!!!!!!

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
       /* WebElement strongLink = getElementBy(By.cssSelector("[strong='/Your Password']"));
        strongLink.click();*/

     /*   WebElement loginButton = getElementBy(By.cssSelector("button[name='login']")); // это еще раз спросить!!!!
        loginButton.click();*/

        /*Alert alertSubscribe = getAlert();
        assertEquals("Failed to subscribe", alertSubscribe.getText(), "Текст всплывающего уведомления не соответствует ожидаемому");
        alertSubscribe.accept();*/

        // пример попросить разобрать в классе
      /*  WebElement validationSummaryErrors = getElementBy(By.cssSelector("[class='validation-summary-errors'] div"));
        assertEquals("Login was unsuccessful.Please correct the errors and try again.", validationSummaryErrors.getText(), "Текст ошибки не соответствует ожидаемому");*/
    }

}


