package com.ait.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class HW_XPafthLocator_Phonebook extends BaseTest {
      /*
    1) * - позволяет выбрать любой элемент
    2) [] - индекс узла html/body/div/div[1]/a[1]
    узел - тэг элемента
    3) / - путь от корневого узла html/body/div/div[1]/a[1]
    4) // - ищет узлы по всему документу //div[1]/a[1]
    5) . - текущий узел //body/.  остается body
    6) .. - родительский узел //body/..
    7) @ - указание на конкретный атрибут

    Методы xPath
    1. text() - возвращает текст элемента //*[text()='LOGIN']
    2. contains() - проверяет содержит ли строка подстроку //a[contains(text(), 'Notebooks')]
    3. count() - возвращает нам количество элементов

        //a[contains(text(), 'Notebooks')]
        //*[@id="root"]/div[2]/div/form/input[1]

        //ul[@class='top-menu']/descendant::a[contains(text(), 'Notebooks')]

         * В XPath есть несколько осей, которые можно использовать при создании выражений:
        1) child::note — Выбирает все узлы note, которые являются прямыми потомками текущего узла
        2) attribute::date — Выбирает атрибут date текущего узла
        3) child::* — Выбирает всех прямых потомков текущего узла
        4) attribute::* — Выбирает все атрибуты текущего узла
        5) child::text() — Выбирает все текстовые узлы текущего узла
        6) child::node() — Выбирает всех прямых потомков текущего узла
        7) descendant::div — Выбирает всех потомков div текущего узла
        8) ancestor::div — Выбирает всех предков div текущего узла
        9) ancestor-or-self::div — Выбирает всех предков div текущего узла, а также сам текущий узел, если это узел div
        10) child::* /child::div — Выбирает всех прямых потомков прямых потомков (“внуков") div текущего узла
        11) last() — Выделяет последний элемент в дереве.
        12) following::div - выбирает всех соседей текущего и следущих узлов
        *
     */


    @Test
    @DisplayName("1. Поиск элементов с использованием text()")
        //body/div/div/<a href="/login>LOGIN<a> для ускорения поиска на сайте
    void findElementByTextXpath() {
        driver.get(URL_PHONE_BOOK);
        WebElement loginElement = getElementBy(By.xpath("//*[text()='LOGIN']"));
        Assertions.assertTrue(loginElement.isDisplayed(), "LoginElement LOGIN is not found");
    }

    @Test
    @DisplayName("2. Поиск элементов с использованием contains()")
    //div/div/form/input name="password" placeholder="Password" value>
    void findElementByContainsXPath(){
        driver.get(URL_PHONE_BOOK);
        WebElement passwordElement=getElementBy(By.xpath("//input[contains(@placeholder, 'Password')]"));
        Assertions.assertTrue(passwordElement.isDisplayed(), "PasswordElement Password is not found");
    }

    @Test
    @DisplayName("3.Поиск элементов с использованием count()")
    void findElementByCountXPath() {
        driver.get(URL_PHONE_BOOK);
        List<WebElement> hrefElement = Collections.singletonList(getElementBy(By.xpath("//href")));
        Assertions.assertFalse(hrefElement.isEmpty(), "hrefElement href is not found");
    }

    @Test
    @DisplayName("Использование осей XPath")
    void findElementByAxesXPath() {
        driver.get(URL_PHONE_BOOK);
        WebElement childClassElement=getElementBy(By.xpath("child::class"));
        Assertions.assertTrue(childClassElement.isDisplayed(), "Not exists child of class element");

        List<WebElement>descendantDivsElements=driver.findElements(By.xpath("descendant::div"));
        Assertions.assertTrue(!descendantDivsElements.isEmpty(), "Deascendant elements of div are not found");

        WebElement ancestorElements=getElementBy(By.xpath("ancestor::div"));
        Assertions.assertFalse(descendantDivsElements.isEmpty(), "Ancestor elements of div are not found");

    }
}
