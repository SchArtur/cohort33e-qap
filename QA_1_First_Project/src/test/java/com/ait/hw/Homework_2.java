package com.ait.hw;

import com.ait.lesson.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Homework_2 extends BaseTest {


    @Test
    @DisplayName("Проверка заголовка страницы")
    void testOpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demowebshop.tricentis.com/");
        //driver.navigate().forward();
        // driver.navigate().back();
        // driver.navigate().refresh();
        Assertions.assertEquals("Demo Web Shop", driver.getTitle(), "Открыта другая страница с другим Title");
    }

    @Test
    @DisplayName("Поиск  элементов по тегу")
    void test1() {
        driver.get(URL_DEMO_WEB_SHOP);

        List<WebElement> listAElements = driver.findElements(By.tagName("a"));
        Assertions.assertFalse(listAElements.isEmpty(), "Нет элементов с тегом \"a\"");


        List<WebElement> listAElements2 = driver.findElements(By.tagName("img"));
        Assertions.assertFalse(listAElements2.isEmpty(), "Нет элементов с тегом \"img\"");

        List<WebElement> listAElements3 = driver.findElements(By.tagName("strong"));
        Assertions.assertFalse(listAElements3.isEmpty(), "Нет элементов с тегом \"strong\"");


        WebElement elementByClassName = getElementBy(By.className("header-logo"));
        Assertions.assertTrue(elementByClassName.isDisplayed(), "elementByClassName нет на странице");


        WebElement elementByPartialLinkText = getElementBy(By.partialLinkText("COMPU"));
        Assertions.assertTrue(elementByPartialLinkText.isDisplayed(), "elementByPartialLinkText нет на странице");

        WebElement elementByLinkText = getElementBy(By.linkText("Computers"));
        Assertions.assertTrue(elementByLinkText.isDisplayed(), "elementByLinkText нет на странице");


        WebElement elementByCssByClass = getElementBy(By.cssSelector("a[href='/producttag/8/awesome']"));
        Assertions.assertTrue(elementByCssByClass.isDisplayed(), "elementByName нет на странице");

        WebElement elementByCssByValue = driver.findElement(By.cssSelector("input[value='Vote']"));
        Assertions.assertTrue(elementByCssByValue.isDisplayed(), " ");

        WebElement elementByCssByImg = getElementBy(By.cssSelector("img[alt=\"Picture of $25 Virtual Gift Card\"]"));
        Assertions.assertTrue(elementByCssByImg.isDisplayed(), "elementByName нет на странице");


        getElementBy(By.linkText("Log in")).click();
        WebElement elementByName = getElementBy(By.name("Email"));
        Assertions.assertTrue(elementByName.isDisplayed(), "elementByName нет на странице");

        WebElement elementByCss = getElementBy(By.cssSelector("input[id='Email']"));
        Assertions.assertTrue(elementByCss.isDisplayed(), "elementByName нет на странице");


    }
}
