package com.webshop.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddItemToCart extends BaseTest {

    @BeforeEach
    void preconditions() {
        loginTestUser();
        if (getCountShopItem() > 0) {
            clearCart();
        }
    }

    @AfterEach
    void afterCondition() {
        clearCart();
    }

    @Test
    @DisplayName("Добавление товара в корзину и очистка корзины")
    void addItem() {

//        driver.findElements(By.cssSelector("[class='product-item']")).get(1).click();
//        clickOnElement(By.cssSelector("[value='Add to cart']"));
//        waitInSeconds(2);
//        clickOnElement(By.cssSelector("[href='/cart']"));
//        assertTrue(getElementBy(By.xpath("//input[@class='qty-input']")).isEnabled(),String.format("Товар не добавлен в корзину"));
//        clickOnElement(By.cssSelector("[name='removefromcart']"));
//        clickOnElement(By.cssSelector("[name='updatecart']"));
//
//        assertTrue(getElementBy(By.cssSelector("[class='order-summary-content']")).isDisplayed());
//        clickOnElement(By.cssSelector("[href='/']"));
//        clickOnElement(By.xpath("//a[@class='ico-logout']"));

        int startCountItems = getCountShopItem();
        System.out.println(startCountItems);

        WebElement productItem = driver.findElements(By.cssSelector("[class='product-item']")).get(1);//0 -1 получили второй элемент
        String productName = productItem.findElement(By.cssSelector(".product-title a")).getText();
        productItem.findElement(By.cssSelector("[value='Add to cart']")).click();
        waitInSeconds(3);

        int resultCountItems = getCountShopItem();
        System.out.println(resultCountItems);

        assertTrue(resultCountItems == startCountItems + 1);

        clickOnElement(By.xpath("//a[@href='/cart']"));//Shopping cart
        waitInSeconds(2);
        WebElement actualProductNameInCart = getElementBy(By.cssSelector("[class='product-name']"));
        assertEquals(productName, actualProductNameInCart.getText(), "Добавился не тот товар");
    }


//    @Test
//    @DisplayName("Проверка пустой корзины")
//    void checkCart() {
//        clickOnElement(By.xpath("//a[@href='/cart']"));
//        String emptyCart = getElementBy(By.xpath("//*[text()='Your Shopping Cart is empty!']));
//        assertEquals(emptyCart, "Your Shopping Cart is empty!");
//    }

    private void clearCart() {
        clickOnElement(By.xpath("//a[@href='/cart']"));//Shopping cart
        List<WebElement> listAElements = driver.findElements(By.name("removefromcart"));
        System.out.println(listAElements.size());
        for (int i = 0; i < listAElements.size(); i++) {
//            waitInSeconds(1);
            listAElements.get(i).click();
        }
        clickOnElement(By.cssSelector("[name='updatecart']"));
        driver.get(URL_DEMO_WEBSHOP);
    }

    private int getCountShopItem() {
        String countShopItems = getElementBy(By.xpath("//span[@class='cart-qty']")).getText().replaceAll("[^0-9]+", "");
        return Integer.parseInt(countShopItems);
    }
}
