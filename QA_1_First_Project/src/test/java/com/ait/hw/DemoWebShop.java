package com.ait.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
/*
public class DemoWebShop extends BaseTest {

    @Test
    @DisplayName("Поиск элемента по tagName и name")
    void test1() {
        // Открываем страницу
        driver.get(URL_DEMO_WEB_SHOP);
        // Ищем элемент по тегу
        WebElement elementTitle = driver.findElement(By.tagName("title"));
        // Проверяем, что текст элемента соответствует ожидаемому
        Assertions.assertEquals("Demo Web Shop", elementTitle.getText(), "Заголовок страницы не Demo Web Shop");

        WebElement elementH1 = driver.findElement(By.tagName("H1"));
        // Проверяем, что текст элемента соответствует ожидаемому
        Assertions.assertEquals("Desktops", elementTitle.getText(), "Заголовок страницы не Desktops");


        // Ищем все элементы с тегом "li"
        List<WebElement> listAElements = driver.findElements(By.tagName("li"));
        // Проверяем, что список элементов не пуст
        Assertions.assertTrue(!listAElements.isEmpty(), "Нет элементов с тэгом \"li\"");

        // Кликаем по элементу с текстом "ELECTRONICS"
        getElementBy(By.linkText("ELECTRONICS")).click();

        // Ищем элемент по имени
        WebElement elementByName = getElementBy(By.name("BOOKS"));
        WebElement elementByCss = getElementBy(By.cssSelector("[span='View as']"));
        WebElement elementByxPath = getElementBy(By.xpath("//*[@name='Remember me']"));
        Assertions.assertTrue(elementByName.isDisplayed(), "elementByName нет на странице");
    }

    @Test
    @DisplayName("Поиск элемента по локаторам")
    void test2() {
        // Открываем страницу
        driver.get(URL_DEMO_WEB_SHOP);
        // Ищем элемент по id
        //[id="city"]
        WebElement elementById = getElementBy(By.id("dialog-notification-success"));
        // Проверяем, что элемент отображается на странице
        Assertions.assertTrue(elementById.isDisplayed(), "elementById нет на странице");

        // Ищем элемент по className
        WebElement elementByClassName = getElementBy(By.className("ico-wishlist"));
        Assertions.assertTrue(elementByClassName.isDisplayed(), "elementByClassName нет на странице");

        // Ищем элемент по className внутри элемента
        WebElement elementByClassNameByClassName = elementByClassName.findElement(By.className("cart-label"));
        Assertions.assertTrue(elementByClassNameByClassName.isDisplayed(), "elementByClassName нет на странице");

        // Ищем элемент по linkText
        WebElement elementByLinkText = getElementBy(By.linkText("Shopping cart"));
        Assertions.assertTrue(elementByLinkText.isDisplayed(), "elementByLinkText нет на странице");

        // Ищем элемент по partialLinkText
        WebElement elementByPartialLinkText = getElementBy(By.partialLinkText("Shop"));
        Assertions.assertTrue(elementByPartialLinkText.isDisplayed(), "elementByPartialLinkText нет на странице");
    }
}
*/

