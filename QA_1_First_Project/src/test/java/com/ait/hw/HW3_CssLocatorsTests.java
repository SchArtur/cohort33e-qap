package com.ait.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW3_CssLocatorsTests extends BaseTest {

    @Test
    @DisplayName("Css тесты")
    void test1() {
        driver.get(URL_DEMO_WEB_SHOP);

        //tagName -> tag name
        WebElement tagName = driver.findElement(By.cssSelector("h3"));
        Assertions.assertTrue(tagName.isDisplayed());

        //By.id -> #id
        WebElement elementById = driver.findElement(By.cssSelector("#dialog-notifications-success"));
        Assertions.assertTrue(elementById.isEnabled());

        //class -> .class
        WebElement elementByClass = driver.findElement(By.cssSelector(".header-logo"));
        Assertions.assertTrue(elementByClass.isDisplayed());

        WebElement elementByClass2 = driver.findElement(By.cssSelector("[class^='header-']"));
        Assertions.assertTrue(elementByClass2.isDisplayed());

        //name, type, href и по остальным любым атрибутам ->
        WebElement elementByAtr = driver.findElement(By.cssSelector("[href='http://www.nopcommerce.com/']"));
        Assertions.assertTrue(elementByAtr.isDisplayed());

        //Вниз по дереву body img
        WebElement elementByCss = driver.findElement(By.cssSelector("div form"));
        Assertions.assertTrue(elementByCss.isDisplayed());
    }

    @Test
    @DisplayName("Click тесты")
    void test2() {
        driver.get(URL_DEMO_WEB_SHOP);
        WebElement aboutUs = driver.findElement(By.cssSelector("[href='/about-us']"));
        aboutUs.click();

        WebElement elementStrong1 = getElementBy(By.cssSelector("h1"));
        // Проверяем, что текст элемента соответствует ожидаемому
        Assertions.assertEquals("About Us", elementStrong1.getText(), "Элемент не About Us");

    }

    @Test
    @DisplayName("Alert тест")
    void test3() {
        driver.get(URL_DEMO_WEB_SHOP);
        // Warte, bis das Element vorhanden und sichtbar ist
        WebElement searchLink = getElementBy(By.cssSelector("input.button-1.search-box-button"));

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
        WebElement searchField = getElementBy(By.cssSelector("input[name='q']"));

        // Gebe den Suchbegriff ein
        searchField.sendKeys("Laptop");

        // Finde den Suchbutton
        //Geändert den Zugang der Methode waitForClickableElement von Privat zu Public in BaseTest
        WebElement searchButton = waitForClickableElement(By.cssSelector("input.button-1.search-box-button"));

        // Klicke auf den Suchbutton
        searchButton.click();

        // Warte, bis die Suchergebnisse sichtbar sind (dieser Selektor ist nur ein Beispiel)
        WebElement searchResults = getElementBy(By.cssSelector(".search-text"));

        // Überprüfe, ob die Suchergebnisse angezeigt werden
        Assertions.assertTrue(searchResults.isDisplayed(), "Suchergebnisse werden nicht angezeigt");

        WebElement elementLaptop = driver.findElement(By.cssSelector("[href$='laptop']"));
        Assertions.assertTrue(elementLaptop.isDisplayed());
    }
}
