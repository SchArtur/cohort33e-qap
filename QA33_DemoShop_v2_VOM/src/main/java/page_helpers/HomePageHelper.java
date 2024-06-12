package page_helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageHelper extends BaseHelper {


    public HomePageHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Переходим на главную страницу")
    public void clickOnHomeLink() {
        clickOnElement(By.cssSelector("[href='/']"));
    }

    @Step("Проверяем отображение 'Home Component'")
    public boolean checkHomeComponentIsPresent() {
        return isElementPresent(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
    }
}
