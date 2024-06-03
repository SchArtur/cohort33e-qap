/*import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.cssSelector;
*/
/*
public class AddToCartTest extends TestBase {

    @Test
    @DisplayName("Создаем объект для ввода данных в форму регистрации")
    void logIn() {
        RegisterForm userForm = new RegisterForm("male", "John", "Tramp", "JohnTramp3@test.com", "Pass123!", "Pass123!");

        //открываем страницу, переходим на элемет Log in
        driver.get(DEMO_SHOP_URL);
        clickOnElement(cssSelector("[class=\"ico-login\"]"));
        //заполняем поля формы Log in для входа в аккаунт

        fillInputField(By.id("Email"), userForm.getEmail());
        fillInputField(By.id("Password"), userForm.getPassword());
        // нажимаем кнопку Log in для подтверждения входа
        clickOnElement(cssSelector("[class='button-1 login-button']"));

        // Убеждаемся в успешном логировании, тем что иконка Log in сменилась на Log out
        WebElement confirmationLogOut = getElementBy(cssSelector("[class='ico-logout']"));
        Assertions.assertEquals("Log out", confirmationLogOut.getText(), "Icon is not Log out");
    }

    @Test
    @DisplayName("переходим на главную страницу , находим козину и проверяем, что корзина пуста, если нет , то очищаем корзину")
    void checkAndClearShoppingCart() {
        driver.get(DEMO_SHOP_URL);

        WebElement shoppingCart = getElementBy(cssSelector("[class='cart-label']"));
        Assertions.assertEquals("Shopping cart", shoppingCart.getText(), "Shopping cart is not found");

     /*  private int getCartQuantity () {
           WebElement cartQtyElement = getElementBy(By.className("cart-qty"));// '(0)'
           String cartQtyString = cartQtyElement.getText().replace("(", "").replace(")", ""); // 0
    //    String cartQtyString = cartQtyElement.getText().replaceAll("\\D", "");// '0' - заменили все символы '(' и ')'
           return Integer.parseInt(cartQtyString);
       }*/

    /* int CartQty= getCartQuantity(){
           WebElement shoppingCartItems = getElementBy(By.cssSelector("[class='cart-qty']"));
           String cartQtyText = shoppingCartItems.getText();
           int cartQty = Integer.parseInt(cartQtyText.substring(1, cartQtyText.length() - 1));
           if (cartQty > 0) {
               shoppingCartItems.clear();
           }
           int i = Integer.parseInt(cartQty);
           return i;
       }*/


        //переходим на главную страницу и добавляем выбранный товар в корзину

     /*   WebElement cartItem = getElementBy(By.xpath("//div[@class= 'button']/descendant::class='button-2 product-box-add-to-cart-button']")).click();
        Assertions.assertEquals("Add to cart", cartItem.getText(), "Cart item is not '14.1-inch Laptop'");

        //переходим в корзину для проверки добавлен ли выбранный товар
        clickOnElement(cssSelector("[class='cart-qty']"));
        getElementBy(cssSelector("[class='product-name']"));
        Assertions.assertEquals("14.1-inch Laptop", cartItem.getText(), "Cart item is not '14.1-inch Laptop'");

   /* private int getCartQuantity() {
        WebElement cartQtyElement = getElementBy(By.className("cart-qty"));// '(0)'
        String cartQtyString = cartQtyElement.getText().replace("(","").replace(")",""); // 0
//        String cartQtyString = cartQtyElement.getText().replaceAll("\\D", "");// '0' - заменили все символы '(' и ')'
        return Integer.parseInt(cartQtyString);*/









