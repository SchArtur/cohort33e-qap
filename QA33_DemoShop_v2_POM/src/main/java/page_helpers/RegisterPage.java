//package page_helpers;
//
//import io.qameta.allure.Step;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class RegisterPage extends BasePage {
//
//    public RegisterPage(WebDriver driver, WebDriverWait wait) {
//        super(driver, wait);
//    }
//
//    @Step("Переходим на страницу регистрации")
//    public void clickOnHomeLink() {
//        clickOnElement(By.cssSelector("[href='/register']"));
//    }
//
//    @Step("Проверяем отображение 'Register'")
//    public boolean checkHomeComponentIsPresent() {
//        return isElementPresent(By.xpath("//h1[(text()='Register')]"));
//    }
//}
