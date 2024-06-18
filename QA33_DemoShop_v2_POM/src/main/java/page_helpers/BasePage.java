package page_helpers;

import core.AppManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = AppManager.driver;
        this.wait = AppManager.wait;
        PageFactory.initElements(driver, this);
    }

//    protected WebElement getElementBy(WebElement element) {
//        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
//    }
//
//    private WebElement waitForClickableElement(WebElement element) {
//        return wait.until(ExpectedConditions.elementToBeClickable(locator));
//    }

    @Step("Получаем текст всплывающего уведомления и нажимаем 'accept'")
    protected Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    //    @Step("Заполняем элемент с локатором {0}, значением {1}")
    protected void fillInputField(WebElement element, String value) {
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
    protected void clickOnElement(WebElement element) {
        element.click();
    }

    //    @Step("Проверяем наличие на экране элемента с локатором {0}")
    protected void checkElementIsPresent(WebElement element) {
        assertTrue(element.isDisplayed(), "Ожидаемый элемент не найден на странице");
    }

    @Step("Ожидаем {0} секунд")
    protected void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Генерируем случайные e-mail")
    public static String getRandomEmail() {
        char[] chars = "0123456789abcdef".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[8];
        for (int i = 0; i < result.length; i++) {
            int randomIndex = random.nextInt(chars.length);
            result[i] = chars[randomIndex];
        }
        String email = new String(result) + "@test.com";
        return email;
    }

    //Делает скриншот и добавляет его в аллюр репорт
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) AppManager.driver).getScreenshotAs(OutputType.BYTES);
    }

    protected boolean isElementPresent(List<WebElement> elements) {
        return elements.size() > 0;
    }
}
