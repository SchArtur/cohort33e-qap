package webshoptest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddItemToCart extends TestBase {


    @BeforeEach
    void preconditions() {
        loginTestUser();
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }


    @Test
    @DisplayName("Adding item to the shopping cart and cleaning the shopping cart")
    void addItem() {
        driver.findElements(By.cssSelector("[class='product-item']")).get(1).findElement(By.cssSelector("[value='Add to cart']")).click();
        //assertTrue(getElementBy(By.xpath("//div[@class='button-2 product-box-add-to-cart-button']")).isEnabled(), "Added item");
        waitInSeconds(2);

//        clickOnElement(By.xpath("//a[@class='ico-cart']"));
        clickOnElement(By.cssSelector("[class='cart-label']"));
        assertTrue(getElementBy(By.xpath("//input[@class='qty-input']")).isEnabled(), "Item don't added to the shopping cart");
        clickOnElement(By.cssSelector("[name='removefromcart']"));
        clickOnElement(By.cssSelector("[name='updatecart']"));

        assertTrue(getElementBy(By.cssSelector("[class='order-summary-content']")).isDisplayed());
        clickOnElement(By.cssSelector("[href='/']"));
        clickOnElement(By.xpath("//a[@class='ico-logout']"));

    }

    @Test
    @DisplayName("Checking the empty shopping cart")
    void checkingCart() {
        clickOnElement(By.cssSelector("[class='cart-label']"));
        assertTrue(getElementBy(By.cssSelector("[class='order-summary-content']")).isDisplayed());
    }


}






