package com.ait.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW2_TestDemoWebShop extends BaseTest {

    @Test
    @DisplayName("Поиск элемента по имени тега")
    void test1() {
        // Открываем страницу
        driver.get(BaseTest.URL_DEMO_WEB_SHOP);
        // Ищем элемент по тегу
        WebElement elementStrong = driver.findElement(By.tagName("strong"));
        // Проверяем, что текст элемента соответствует ожидаемому
        Assertions.assertEquals("CATEGORIES", elementStrong.getText(), "Элемент не CATEGORIES");

        // Ищем элемент по тегу
        WebElement elementStrong1 = getElementBy(By.cssSelector("[class*='manufacturer']")).findElement(By.tagName("strong"));
        // Проверяем, что текст элемента соответствует ожидаемому
        Assertions.assertEquals("MANUFACTURERS", elementStrong1.getText(), "Элемент не Manufacturers");

        // Ищем элемент по тегу
        WebElement elementH3 = driver.findElement(By.tagName("h3"));
        // Проверяем, что текст элемента соответствует ожидаемому
        Assertions.assertEquals("INFORMATION", elementH3.getText(), "Элемент не INFORMATION");

        // Ищем элемент по тегу
        WebElement elementA = driver.findElement(By.tagName("a"));
        // Проверяем, что текст элемента соответствует ожидаемому
        Assertions.assertTrue(elementA.isDisplayed(),"elementA нет на странице");
            }

    @Test
    @DisplayName("Поиск элемента по имени")
    void test2() {
        // Открываем страницу
        driver.get(BaseTest.URL_DEMO_WEB_SHOP);
        // Ищем элемент по имени
        WebElement elementByName = getElementBy(By.name("NewsletterEmail"));
        Assertions.assertTrue(elementByName.isDisplayed(), "elementByName нет на странице");

        WebElement elementByName2 = getElementBy(By.name("pollanswers-1"));
        Assertions.assertTrue(elementByName2.isDisplayed(), "elementByName2 нет на странице");

        WebElement elementByName3 = getElementBy(By.name("q"));
        Assertions.assertTrue(elementByName3.isDisplayed(), "elementByName3 нет на странице");
    }

    @Test
    @DisplayName("Поиск элемента по id")
    void test3() {
        // Открываем страницу
        driver.get(BaseTest.URL_DEMO_WEB_SHOP);
        // Ищем элемент по id
        WebElement elementById = getElementBy(By.id("newsletter-email"));
        // Проверяем, что элемент отображается на странице
        Assertions.assertTrue(elementById.isDisplayed(), "elementById нет на странице");

        // Ищем элемент по id
        WebElement elementById2 = getElementBy(By.id("nivo-slider"));
        // Проверяем, что элемент отображается на странице
        Assertions.assertTrue(elementById2.isDisplayed(), "elementById2 нет на странице");

        // Ищем элемент по id
        WebElement elementById3 = getElementBy(By.id("topcartlink"));
        // Проверяем, что элемент отображается на странице
        Assertions.assertTrue(elementById3.isDisplayed(), "elementById3 нет на странице");
    }

    @Test
    @DisplayName("Поиск элемента по className")
    void test4() {
        // Открываем страницу
        driver.get(BaseTest.URL_DEMO_WEB_SHOP);
        // Ищем элемент по className
        WebElement elementByClassName = getElementBy(By.className("header-logo"));
        Assertions.assertTrue(elementByClassName.isDisplayed(), "elementByClassName нет на странице");

        // Ищем элемент по className
        WebElement elementByClassName2 = getElementBy(By.className("header-menu"));
        Assertions.assertTrue(elementByClassName2.isDisplayed(), "elementByClassName2 нет на странице");

        // Ищем элемент по className
        WebElement elementByClassName3 = getElementBy(By.className("buttons"));
        Assertions.assertTrue(elementByClassName3.isDisplayed(), "elementByClassName2 нет на странице");
    }

    @Test
    @DisplayName("Поиск элемента по text")
    void test5() {
        // Открываем страницу
        driver.get(BaseTest.URL_DEMO_WEB_SHOP);
        // Ищем элемент по linkText
        WebElement elementByLinkText = getElementBy(By.linkText("Electronics"));
        Assertions.assertTrue(elementByLinkText.isDisplayed(), "elementByLinkText нет на странице");

        // Ищем элемент по linkText
        WebElement elementByLinkText2 = getElementBy(By.linkText("Books"));
        Assertions.assertTrue(elementByLinkText2.isDisplayed(), "elementByLinkText2 нет на странице");

        // Ищем элемент по linkText
        WebElement elementByLinkText3 = getElementBy(By.linkText("Computers"));
        Assertions.assertTrue(elementByLinkText3.isDisplayed(), "elementByLinkText нет на странице");
    }

    @Test
    @DisplayName("Поиск элемента по частичному тексту.")
    void test6() {
        // Открываем страницу
        driver.get(BaseTest.URL_DEMO_WEB_SHOP);
        // Ищем элемент по partialLinkText
        WebElement elementByPartialLinkText = getElementBy(By.partialLinkText("Log"));
        Assertions.assertTrue(elementByPartialLinkText.isDisplayed(), "elementByPartialLinkText нет на странице");

        // Ищем элемент по partialLinkText
        WebElement elementByPartialLinkText2 = getElementBy(By.partialLinkText("Shopping"));
        Assertions.assertTrue(elementByPartialLinkText2.isDisplayed(), "elementByPartialLinkText нет на странице");

        // Ищем элемент по partialLinkText
        WebElement elementByPartialLinkText3 = getElementBy(By.partialLinkText("Apparel"));
        Assertions.assertTrue(elementByPartialLinkText3.isDisplayed(), "elementByPartialLinkText нет на странице");
    }
}
