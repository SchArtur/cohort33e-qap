import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;


public class AddToCartTest extends TestBase {

    @Test
    @DisplayName("Создаем объект для ввода данных в форму регистрации")
    void logIn() {
        RegisterForm userForm = new RegisterForm("male", "John", "Tramp", "JohnTramp3@test.com", "Pass123!", "Pass123!");

        //открываем страницу, переходим на элемет Log in
        driver.get(DEMO_SHOP_URL);
        clickOnElement(cssSelector("[class=\"ico-login\"]"));
        //заполняем поля формы Log in для входа в аккаунт

        fillInputField(id("Email"), userForm.getEmail());
        fillInputField(id("Password"), userForm.getPassword());
        // нажимаем кнопку Log in для подтверждения входа
        clickOnElement(cssSelector("[class='button-1 login-button']"));

        // Убеждаемся в успешном логировании, тем что иконка Log in сменилась на Log out
        WebElement confirmationLogOut = getElementBy(cssSelector("[class='ico-logout']"));
        Assertions.assertEquals("Log out", confirmationLogOut.getText(), "Icon is not Log out");
    }

    @Test
    @DisplayName("Проверяем корзину, удалаем элементы, если не пуста, боваляем элемент, проверяем, что он добавлен, очищаем корзину")

        // Открываем корзину
    void checkItemInCart() {
        clickOnElement(cssSelector("[class='cart-label']"));

        // Проверяем, пустая ли корзина

        WebElement cartQuantity = getElementBy(cssSelector(".cart-qty"));


        if (!cartQuantity.getText().contains("0")) {
            clickOnElement(cssSelector("[name='removefromcart']"));
            // Даем корзине время на обновление
            try {
                Thread.sleep(2000); // Подождем 2 секунды
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            // WebElement waitForClickableElement = wait.until(ExpectedConditions.elementToBeClickable(cssSelector("[name='updatecart']")));

            driver.findElement(By.cssSelector(".button-2.update-cart-button")).click();
        }
    }

    @Test
    @DisplayName("добавляем товар в корзину")
    void addItemToCart() {
        clickOnElement(cssSelector("[alt='Tricentis Demo Web Shop']"));

        //находим 2ой элемент и добавляем его в корзину
        WebElement cartItem = driver.findElements(cssSelector("[class='product-item']")).get(1).findElement(cssSelector("[value='Add to cart']"));
        try {
            Thread.sleep(2000); // Подождем 2 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cartItem.click();   //(xpath("//*[@id='add-to-cart-button-31']"));*/

        // Даем корзине время на обновление
        try {
            Thread.sleep(2000); // Подождем 2 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //переходим в корзину для проверки добавлен ли выбранный товар

       /*WebElement cartLabel = waitForClickableElement(getElementBy("[class='cart-label']"));
        cartLabel.click();*/
        //clickOnElement(cssSelector("[class='cart-label']"));
        getElementBy(By.linkText("Shopping cart")).click();
        try {
            Thread.sleep(2000); // Подождем 2 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement addedItem= driver.findElement(cssSelector("[class='product-name']"));
        Assertions.assertEquals("14.1-inch Laptop", addedItem.getText(), "Cart item is not '14.1-inch Laptop'");


    }


}

