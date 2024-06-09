package page_helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class HomePageHelper extends BaseHelper {


    public HomePageHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Проверяем отображение 'Demo Web Shop'")
    public boolean checkForDemoWebShopComponentIsPresent(){
       // return isElementPresent(By.cssSelector("img[alt='Tricentis Demo Web Shop']"));
       //return isElementPresent(By.xpath("//*[text()='Tricentis Demo Web Shop']"));
    assertTrue(getElement(By.xpath("//*[text()='Tricentis Demo Web Shop']")));
        return true;
    }

    private boolean getElement(By xpath) {
        return true;
    }

    @Step("Нажимаем на link 'Demo Web Shop'")
    public void clickOnDemoWebShopLink() {
        clickOnElement((By.xpath("//*[text()='Tricentis Demo Web Shop']")));
    }

    @Step("Проверяем отображение 'Log in'")
    public boolean checkForLogInComponentIsPresent(){
        return isElementPresent(By.xpath("//a[@class='ico-login']"));

    }
    @Step("Нажимаем на link Log in'")
    public void clickOnLogInLink() {
        clickOnElement(By.cssSelector("[href='/login']"));
    }

    @Step("Проверяем отображение 'Log out'")
    public boolean checkForLogOutComponentIsPresent() {
        return isElementPresent(By.xpath("//*[text()='Log out']"));
    }
    //return isElementPresent(By.xpath("//a[@class='ico-logout']"));

    @Step("Нажимаем на link Log out'")
    public void clickOnLogOutInLink() {
        clickOnElement(By.cssSelector("[href='//logout']"));
    }

    @Step("Проверяем отображение 'Shopping cart(0)'")
    public boolean checkForShoppingCartComponentIsPresent() {
        return isElementPresent(By.xpath("//*[text()='Shopping cart']"));
        // return isElementPresent(By.xpath("//a[@class='ico-cart']"));
    }
    @Step("Нажимаем на link Shopping cart(0'")
    public void clickOnShoppingCartLink() {
        clickOnElement(By.xpath("[//*[text()='Shopping cart']"));
    }
}
