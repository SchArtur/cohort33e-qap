package com.ait.appuim.pages;

import com.ait.appuim.core.AppManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage {

    AppiumDriver driver;
    WebDriverWait wait;

    public BasePage() {
        this.driver = AppManager.driver;
        this.wait = AppManager.wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //    @Step("Получаем элемент с локатором - {0}")
    protected WebElement getElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //    @Step("Ожидаем всплывающее уведомление")
    protected Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    @Step("Получаем текст всплывающего уведомления и нажимаем 'accept'")
    public String getAlertText() {
        String allerText = getAlert().getText();
        getAlert().accept();
        return allerText;
    }

    //    @Step("Заполняем элемент с локатором {0}, значением {1}")
    protected void fillInputField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
        assertEquals(value, element.getAttribute("value"), "Введенный текст отличается от того что в элементе");
    }

    //    @Step("Делаем клик по элементу с локатором {0}")
    protected void tapOnElement(WebElement element) {
        element.click();
    }

    //    @Step("Проверяем наличие на экране элемента с локатором {0}")
    protected void checkElementIsPresent(WebElement element) {
        assertTrue(element.isDisplayed(), "Ожидаемый элемент не найден на странице");
    }

    //    @Step("Проверяем наличие на экране элемента с локатором {0}")
    protected boolean isElementPresent(List<WebElement> elements) {
        return elements.size() > 0;
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

    @Step("Ожидаем {0} секунд")
    public void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
