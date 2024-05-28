package com.ait.lesson;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class XPathLocatorTests extends BaseTest {

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
    text() - возвращает текст элемента //*[text()='LOGIN']
    contains() - проверяет содержит ли строка подстроку //a[contains(text(), 'Notebooks')]
    count() - возвращает нам количество элементов

        //a[contains(text(), 'Notebooks')]
        //ul[@class='top-menu']/descendant::a[contains(text(), 'Notebooks')]

       //*[@id="root"]/div[2]/div/form/input[1]
     */

    @Test
    @DisplayName("Поиск элементов по xPath")
    void findElementByXpath() {
        driver.get(URL_PHONE_BOOK);
        clickOnElement(By.xpath("//*[text()='LOGIN']"));

        fillInputField(By.xpath("//*[@name='email']"), "manuel@gm.com");
        fillInputField(By.xpath("//*[@name='password']"), "Manuel1234$");

        clickOnElement(By.xpath("//*[text()='Login']"));

        Assertions.assertTrue(getElementBy(By.xpath("//button[text()='Sign Out']")).isDisplayed(), "Отсутствует кнопка выхода ");
    }
}
