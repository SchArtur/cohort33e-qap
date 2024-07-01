package page_helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Нажимаем на кнопку 'HOME'")
    public void clickOnHomeLink() {
        clickOnElement(By.cssSelector("[href='/home']"));
    }

    @Step("Проверяем отображение 'Home Component'")
    public boolean checkHomeComponentIsPresent(){
        return isElementPresent(By.xpath("//*[text()='Home Component']"));
    }

    @Step("Проверяем отображение 'React Contacts App'")
    public boolean checkReactAppInfoIsPresent() {
        return isElementPresent(By.xpath("//*[text()='React Contacts App']"));
    }

    @Step("Проверяем отображение 'For QA Testing'")
    public boolean checkForQaInfoIsPresent() {
        return isElementPresent(By.xpath("//*[text()='For QA Testing']"));
    }
}
