package page_helpers;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.cssSelector;

public class AddToCartHelper extends BaseHelper {


    public AddToCartHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void fillLoginForm(User loginUser) {
        clickOnElement(By.cssSelector("[class='ico-login']"));
        fillInputField(By.id("Email"), loginUser.getEmail());
        fillInputField(By.id("Password"), loginUser.getPassword());
    }

    public void clickOnLoginButton() {
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));
    }

    public boolean isLoggedIn() {
        return checkElementIsPresent(By.cssSelector("[class='ico-logout']"));
    }

    public void openCart() {
        clickOnElement(By.xpath("//*[text()='Shopping cart']"));
    }

    public void clearCartIfNotEmpty() {
        openCart();
        WebElement cartQuantityElement = getElementBy(By.cssSelector(".cart-qty"));
        int cartQuantity = Integer.parseInt(cartQuantityElement.getText().replaceAll("[^0-9]", ""));
        if (cartQuantity != 0) {
            clickOnElement(By.cssSelector("[name='removefromcart']"));
        }
    }

    public void addItemToCart() {
        isElementPresent(By.xpath("//*[text()='Your registration completed']"));
        ;
        clickOnElement(cssSelector("[value='Add to cart']"));
    }

    public void isItemInCart (){
        isElementPresent(By.cssSelector("[class='cart-qty']"));
    }
}
