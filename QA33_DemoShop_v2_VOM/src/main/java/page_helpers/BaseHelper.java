package page_helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

import java.time.Duration;


public class BaseHelper {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseHelper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected WebElement getElementBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    private WebElement waitForClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Step("Получаем текст всплывающего уведомления и нажимаем 'accept'")
    protected Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    //    @Step("Заполняем элемент с локатором {0}, значением {1}")
    protected void fillInputField(By locator, String value) {
        WebElement element = waitForClickableElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
        assertEquals(value, element.getAttribute("value"), "Введенный текст отличается от того что в элементе");
    }

    @Step("Получаем текст всплывающего уведомления и нажимаем 'accept'")
    public String getAlertText() {
        String allerText = getAlert().getText();
        getAlert().accept();
        return allerText;
    }

    //    @Step("Делаем клик по элементу с локатором {0}")
    protected void clickOnElement(By locator) {
        WebElement element = waitForClickableElement(locator);
        element.click();
    }

    //    @Step("Проверяем наличие на экране элемента с локатором {0}")
    protected void checkElementIsPresent(By locator) {
        assertTrue(getElementBy(locator).isDisplayed(), String.format("Ожидаемый элемент с локатором %s не найден на странице", locator));
    }

    @Step("Ожидаем {0} секунд")
    protected void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
