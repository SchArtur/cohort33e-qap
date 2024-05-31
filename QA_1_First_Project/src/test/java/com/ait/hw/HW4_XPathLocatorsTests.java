package com.ait.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW4_XPathLocatorsTests extends BaseTest {

    @Test
    @DisplayName("Css тесты")
    void test1() {
        driver.get(URL_DEMO_WEB_SHOP);

        //tagName -> tag name
        WebElement tagName = driver.findElement(By.xpath("//h3"));
        Assertions.assertTrue(tagName.isDisplayed());


        //By.id -> #id
        WebElement elementById = driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));
        Assertions.assertTrue(elementById.isEnabled());


        //class -> .class
        WebElement elementByClass = driver.findElement(By.xpath("//*[contains(@class, 'header-logo')]"));
        Assertions.assertTrue(elementByClass.isDisplayed());

        WebElement elementByClass2 = driver.findElement(By.xpath("//*[starts-with(@class, 'header-')]"));
        Assertions.assertTrue(elementByClass2.isDisplayed());


        //name, type, href и по остальным любым атрибутам ->
        WebElement elementByAtr = driver.findElement(By.xpath("//a[@href='http://www.nopcommerce.com/']"));
        Assertions.assertTrue(elementByAtr.isDisplayed());


        //Вниз по дереву body img
        WebElement elementByXPath = driver.findElement(By.xpath("//div//form"));
        Assertions.assertTrue(elementByXPath.isDisplayed());

    }

    @Test
    @DisplayName("Click тесты")
    void test2() {
        driver.get(URL_DEMO_WEB_SHOP);
        WebElement aboutUs = driver.findElement(By.xpath("//a[@href='/about-us']"));
        aboutUs.click();

        WebElement elementStrong1 = getElementBy(By.xpath("//h1"));
        // Проверяем, что текст элемента соответствует ожидаемому
        Assertions.assertEquals("About Us", elementStrong1.getText(), "Элемент не About Us");


    }

    @Test
    @DisplayName("Alert тест")
    void test3() {
        driver.get(URL_DEMO_WEB_SHOP);
        // Warte, bis das Element vorhanden und sichtbar ist
        WebElement searchLink = getElementBy(By.xpath("//input[@class='button-1 search-box-button']"));

        // Stelle sicher, dass das Element angezeigt wird
        Assertions.assertTrue(searchLink.isDisplayed(), "Das Suchfeld ist nicht sichtbar");
        searchLink.submit();

        Alert alert = getAlert();
        Assertions.assertEquals("Please enter some search keyword", alert.getText(), "Текст всплывающего уведомления не соответствует ожидаемому");
        alert.accept();

    }

    @Test
    @DisplayName("Search тест")
    void test4() {
        driver.get(URL_DEMO_WEB_SHOP);
        // Warte, bis das Suchfeld sichtbar ist und finde es dann
        WebElement searchField = getElementBy(By.xpath("//input[@name='q']"));

        // Gebe den Suchbegriff ein
        searchField.sendKeys("Laptop");

        // Finde den Suchbutton
        WebElement searchButton = waitForClickableElement(By.xpath("//input[@class='button-1 search-box-button']"));

        // Klicke auf den Suchbutton
        searchButton.click();

        WebElement elementLaptop = driver.findElement(By.xpath("//a[contains(@href, 'laptop')]"));
        Assertions.assertTrue(elementLaptop.isDisplayed());
    }
}
