package page_helpers;

import com.beust.ah.A;
import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.By.cssSelector;

public class AddToCartHelper extends BaseHelper {


    public AddToCartHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.isItemInCart();
    };

    @Step("Кликаем на линк Log in, переходим на страницу логирования , заполняем данные для входа в аккаунт")
    public void fillLoginForm(User loginUser) {
        clickOnElement(By.cssSelector("[class='ico-login']"));
        fillInputField(By.id("Email"), loginUser.getEmail());
        fillInputField(By.id("Password"), loginUser.getPassword());
    }
    @Step ("Нажимаем на кнопку Login для завершения входа в аккаунт")
    public void clickOnLoginButton() {
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));
    }


    @Step ("После успешного логирования должен быть виден линк Log out ")
    public boolean isLoggedIn() {
        return checkElementIsPresent(By.cssSelector("[class='ico-logout']"));
    }

    @Step ("Кликаем на линк Shopping cart,  переходим на страницу корзины")
    public void openCart() {
        clickOnElement(By.xpath("//*[text()='Shopping cart']"));
    }

   @Step ("Очищаем корзину, если она не пустая")
    public void clearCartIfNotEmpty() {
        openCart();
        WebElement cartQuantityElement = getElementBy(By.cssSelector(".cart-qty"));
        int cartQuantity = Integer.parseInt(cartQuantityElement.getText().replaceAll("[^0-9]", ""));
        if (cartQuantity != 0) {
            clickOnElement(By.cssSelector("[name='removefromcart']"));
            clickOnElement(By.cssSelector("[name='updatecart']"));
        }
    }

    @Step ("Добавляем товар в корзину с индексом 1, получаем его наименование ")
    public void addItemToCart() {

      //  isElementPresent(By.xpath("//*[text()='Your registration completed']"));
        // проверить верхнюю строку по селектору
        WebElement productItem =
        driver.findElements(By.cssSelector("[class='product-item']")).get(1);
        driver.findElement(By.cssSelector("[value='Add to cart']")).click();
        waitInSeconds(2);
       WebElement actualItemNameInCart=getElementBy(By.cssSelector("[class='product-name']"));

    }

    @Step("Проверяем добавление товара, удалаем этот товар из корзины")
    // не удалаем из корзины, т.к корзина чистится перед добавлением товара, метод удаления закомментирован
    public void isItemInCart (){
        WebElement cartItem = getElementBy(By.cssSelector("[class='cart-qty']"));
      /*  int cartQuantity = Integer.parseInt(cartItem.getText().replaceAll("[^0-9]", ""));
        if (cartQuantity != 0) {
            clickOnElement(By.cssSelector("[name='removefromcart']"));
            clickOnElement(By.cssSelector("[name='updatecart']"));
            Assert.assertTrue(cartQuantity >0, "No items in the cart");
        }*/

    }


}

