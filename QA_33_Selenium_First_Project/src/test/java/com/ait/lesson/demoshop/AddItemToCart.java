package com.ait.lesson.demoshop;

import com.ait.lesson.BaseTest;
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
        login("ewqewq@gmail.com", "1234qwer", "Log in");
        if (getCountShopItem() > 0) {
            clearCart();
        }
    }

    @AfterEach
    void afterCondition() {
        clearCart();
    }

    @Test
    @DisplayName("Добавление товара в карзину")
    void addTest() {
        int startCountItems = getCountShopItem();
        System.out.println(startCountItems);

        WebElement productItem = driver.findElements(By.cssSelector("[class='product-item']")).get(1);//0 -1 получили второй элемент
        String productName = productItem.findElement(By.cssSelector(".product-title a")).getText();
        productItem.findElement(By.cssSelector("[value='Add to cart']")).click();
        waitInSeconds(3);

        int resultCountItems = getCountShopItem();
        System.out.println(resultCountItems);

        assertTrue(resultCountItems == startCountItems + 1);

        clickOnElement(By.xpath("//*[text()='Shopping cart']"));//Shopping cart

        WebElement actualProductNameInCart = getElementBy(By.cssSelector("[class='product-name']"));
        assertEquals(productName, actualProductNameInCart.getText(), "Добавился не тот товар");
    }

    private void clearCart() {
        clickOnElement(By.xpath("//*[text()='Shopping cart']"));//Shopping cart
        List<WebElement> listAElements = driver.findElements(By.name("removefromcart"));
        System.out.println(listAElements.size());
        for (int i = 0; i < listAElements.size(); i++) {
            listAElements.get(i).click();
        }
        clickOnElement(By.xpath("//input[@name='updatecart']"));
        driver.get(URL_DEMO_WEB_SHOP);
    }

    private int getCountShopItem() {
        String countShopItems = getElementBy(By.xpath("//span[@class='cart-qty']")).getText().replaceAll("[^0-9]+", "");
        return Integer.parseInt(countShopItems);
    }

}
