package com.ait.lesson.demoshop;

import com.ait.lesson.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoShopTests extends BaseTest {

    final static String DEMO_SHOP_URL = "https://demowebshop.tricentis.com/";

    @Test
    @DisplayName("Проверка элемента по id")
    void test1() {
        driver.get(DEMO_SHOP_URL);
        WebElement smallSearchTerms = getElementBy(By.id("small-searchterms"));

        Assertions.assertTrue(smallSearchTerms.getAttribute("name").equals("q"));
        Assertions.assertEquals("q", smallSearchTerms.getAttribute("name"));
    }

    @Test
    @DisplayName("Переход на страницу Books и проверяем элементы")
    void test2() {
        driver.get(DEMO_SHOP_URL);
//        WebElement hrefBooks = getElementBy(By.cssSelector("[href='/books']"));
        WebElement hrefBooks = getElementBy(By.partialLinkText("Books"));
        hrefBooks.click();

        Assertions.assertTrue(driver.getTitle().contains("Books"), "Не перешли на страницу Books");
    }

    @Test
    @DisplayName("Поиск сложного элемента через родителей")
    void test4() {
        driver.get(URL_DEMO_WEB_SHOP);

        assertTrue(getElementBy(By.cssSelector("ul[class='list'] a[href='/computers']")).isDisplayed());
        assertTrue(getElementBy(By.cssSelector(".list a[href='/computers']")).isDisplayed());
        assertTrue(getElementBy(By.xpath("//ul[@class='list']//a[@href='/computers']")).isDisplayed()); //так делать можно, но не желательно
        assertTrue(getElementBy(By.xpath("//ul[@class='list']/descendant::a[@href='/computers']")).isDisplayed());// - так желательно

        WebElement parentElement = getElementBy(By.className("list"));
        WebElement childElement = parentElement.findElement(By.cssSelector("[href='/computers']"));
        assertTrue(childElement.isDisplayed());

        int startQuantity = getCartQuantity();
        driver.findElements(By.cssSelector("[class='product-item']")).get(1).findElement(By.cssSelector("[value='Add to cart']")).click();
        waitInSeconds(2);
        int resultQuantity = getCartQuantity();
        assertTrue(startQuantity+1==resultQuantity, "Товар не добавился в карзину");

    }

    private int getCartQuantity() {
        WebElement cartQtyElement = getElementBy(By.className("cart-qty"));// '(0)'
        String cartQtyString = cartQtyElement.getText().replace("(","").replace(")",""); // 0
//        String cartQtyString = cartQtyElement.getText().replaceAll("\\D", "");// '0' - заменили все символы '(' и ')'
        return Integer.parseInt(cartQtyString);
    }
}
