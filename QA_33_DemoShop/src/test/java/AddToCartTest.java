import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class AddToCartTest extends TestBase {

    @Test
    @DisplayName("Создаем объект для ввода данных в форму регистрации")
    void logIn() {
        RegisterForm userForm = new RegisterForm("male", "John", "Tramp", "JohnTramp3@test.com", "Pass123!", "Pass123!");

        //открываем страницу, переходим на элемет Log in
        driver.get(DEMO_SHOP_URL);
        clickOnElement(By.cssSelector("[class=\"ico-login\"]"));
        //заполняем поля формы Log in для входа в аккаунт

        fillInputField(By.id("Email"), userForm.getEmail());
        fillInputField(By.id("Password"), userForm.getPassword());
        // нажимаем кнопку Log in для подтверждения входа
        clickOnElement(By.cssSelector("[class='button-1 login-button']"));

        // Убеждаемся в успешном логировании, тем что иконка Log in сменилась на Log out
        WebElement confirmationLogOut = getElementBy(By.cssSelector("[class='ico-logout']"));
        Assertions.assertEquals("Log out", confirmationLogOut.getText(), "Icon is not Log out");
    }

    void checkAndClearShoppingCart() {
        driver.get(DEMO_SHOP_URL);

        //переходим на главную страницу , находим козину и проверяем, что корзина пуста, если нет , то очищаем корзину
        WebElement shoppingCart = getElementBy(By.cssSelector("[class='cart-label']"));
        Assertions.assertEquals("Shopping cart", shoppingCart.getText(), "Shopping cart is not found");

        WebElement shoppingCartItems = getElementBy(By.cssSelector("[class='cart-qty']"));
        String cartQtyText = shoppingCartItems.getText();
        int cartQty = Integer.parseInt(cartQtyText.substring(1, cartQtyText.length() - 1));
        if (cartQty > 0) {
            shoppingCartItems.clear();
        }
        //переходим на главную страницу и добавляем выбранный товар в корзину
        getElementBy(By.cssSelector("[alt='Tricentis Demo Web Shop']"));
        WebElement cartItem = getElementBy(By.cssSelector("[itemprop='name']"));
        Assertions.assertEquals("14.1-inch Laptop", cartItem.getText(), "Cart item is not '14.1-inch Laptop'");
        clickOnElement(By.cssSelector("[id='add-to-cart-button-31']"));

        //переходим в корзину для проверки добавлен ли выбранный товар
        clickOnElement(By.cssSelector("[class='cart-qty']"));
        getElementBy(By.cssSelector("[class='product-name']"));
        Assertions.assertEquals("14.1-inch Laptop", cartItem.getText(), "Cart item is not '14.1-inch Laptop'");
    }
}






