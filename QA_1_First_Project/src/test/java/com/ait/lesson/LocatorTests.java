package com.ait.lesson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocatorTests extends BaseTest {

    @Test
    @DisplayName("Поиск элемента по tagName и name")
    void test1() {
        // Открываем страницу
        driver.get(URL_PHONE_BOOK);
        // Ищем элемент по тегу
        WebElement elementH1 = driver.findElement(By.tagName("h1"));
        // Проверяем, что текст элемента соответствует ожидаемому
        Assertions.assertEquals("PHONEBOOK", elementH1.getText(), "Заголовок страницы не PHONEBOOK");

        // Ищем все элементы с тегом "a"
        List<WebElement> listAElements = driver.findElements(By.tagName("a"));
        // Проверяем, что список элементов не пуст
        assertTrue(!listAElements.isEmpty(), "Нет элементов с тэгом \"а\"");

        // Кликаем по элементу с текстом "LOGIN"
        getElementBy(By.linkText("LOGIN")).click();

        // Ищем элемент по имени
        WebElement elementByName = getElementBy(By.name("email"));
        WebElement elementByCss = getElementBy(By.cssSelector("[name='email']"));
        WebElement elementByxPath = getElementBy(By.xpath("//*[@name='email']"));
        assertTrue(elementByName.isDisplayed(), "elementByName нет на странице");
    }

    @Test
    @DisplayName("Поиск элемента по локаторам")
    void test2() {
        // Открываем страницу
        driver.get(URL_ILCARRO);
        // Ищем элемент по id
        //[id="city"]
        WebElement elementById = getElementBy(By.id("city"));
        // Проверяем, что элемент отображается на странице
        assertTrue(elementById.isDisplayed(), "elementById нет на странице");

        // Ищем элемент по className
        WebElement elementByClassName = getElementBy(By.className("input-container"));
        assertTrue(elementByClassName.isDisplayed(), "elementByClassName нет на странице");

        // Ищем элемент по className внутри элемента
        WebElement elementByClassNameByClassName = elementByClassName.findElement(By.className("input-label"));
        assertTrue(elementByClassNameByClassName.isDisplayed(), "elementByClassName нет на странице");

        // Ищем элемент по linkText
        WebElement elementByLinkText = getElementBy(By.linkText("Let the car work"));
        assertTrue(elementByLinkText.isDisplayed(), "elementByLinkText нет на странице");

        // Ищем элемент по partialLinkText
        WebElement elementByPartialLinkText = getElementBy(By.partialLinkText("Let the"));
        assertTrue(elementByPartialLinkText.isDisplayed(), "elementByPartialLinkText нет на странице");
    }

    @Test
    @DisplayName("Поиск одного единственного элемента")
    void test3() {
        driver.get(URL_DEMO_WEB_SHOP);
//        <a href="/register" class="ico-register">Register</a>
        assertTrue(getElementBy(By.cssSelector("[href='/register']")).isDisplayed());
        assertTrue(getElementBy(By.xpath("//*[@href='/register']")).isDisplayed());
        assertTrue(getElementBy(By.xpath("//*[contains(@href, 'register')]")).isDisplayed());

        assertTrue(getElementBy(By.cssSelector("[class='ico-register']")).isDisplayed());
        assertTrue(getElementBy(By.xpath("//*[@class='ico-register']")).isDisplayed());
        assertTrue(getElementBy(By.xpath("//*[contains(@class,'ico-register')]")).isDisplayed());

        assertTrue(getElementBy(By.linkText("Register")).isDisplayed());
        assertTrue(getElementBy(By.xpath("//*[text()='Register']")).isDisplayed());

        assertTrue(getElementBy(By.partialLinkText("Regist")).isDisplayed());
        assertTrue(getElementBy(By.xpath("//*[contains(text(),'Regist')]")).isDisplayed());
    }


}
