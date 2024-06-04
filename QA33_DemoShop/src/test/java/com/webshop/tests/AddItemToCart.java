package com.webshop.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddItemToCart extends BaseTest{

    @BeforeEach
    void preconditions(){
        loginTestUser();
    }

    @Test
    @DisplayName("Добавление товара в корзину и очистка корзины")
    void addItem (){

//    driver.findElements(By.cssSelector("[class='product-item']")).get(1).findElement(By.cssSelector("[value='Add to cart']")).click();

        driver.findElements(By.cssSelector("[class='product-item']")).get(1).click();
        clickOnElement(By.cssSelector("[value='Add to cart']"));
        waitInSeconds(2);
        clickOnElement(By.cssSelector("[href='/cart']"));
        assertTrue(getElementBy(By.xpath("//input[@class='qty-input']")).isEnabled(),String.format("Товар не добавлен в корзину"));
        clickOnElement(By.cssSelector("[name='removefromcart']"));
        clickOnElement(By.cssSelector("[name='updatecart']"));

        assertTrue(getElementBy(By.cssSelector("[class='order-summary-content']")).isDisplayed());
        clickOnElement(By.cssSelector("[href='/']"));
        clickOnElement(By.xpath("//a[@class='ico-logout']"));
    }

    @Test
    @DisplayName("Проверка пустой корзины")
    void checkCart(){
        clickOnElement(By.cssSelector("[class='cart-label']"));
        assertTrue(getElementBy(By.cssSelector("[class='order-summary-content']")).isDisplayed());
    }
}
