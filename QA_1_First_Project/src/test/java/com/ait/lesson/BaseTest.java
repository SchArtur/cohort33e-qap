package com.ait.lesson;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    //Драйвер
    public WebDriver driver;
    //Адреса страниц
    protected static final String URL_PHONE_BOOK = "https://telranedu.web.app/home";
    protected static final String URL_ILCARRO = "https://ilcarro.web.app/search";
    protected static final String URL_DEMO_WEB_SHOP = "https://demowebshop.tricentis.com";
    //Явное ожидание
    WebDriverWait wait;

    @BeforeEach
    void startDriver() {
        //Создание драйвера
        driver = new ChromeDriver();

        //Инициализация явного ожидания
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Настройка не явного ожидания появления элементов на странице
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Ожидание полной загрузки страницы
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        //Ожидание выполнения асинхронного запроса
        //driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        //Задаёт размер окна браузера
        driver.manage().window().maximize();
    }

    @AfterEach
    void quitDriver() {
        driver.quit();//Закрытие браузера
    }

    //Поиск элемента на странице, с явным ожиданием его появления
    public WebElement getElementBy(By locator){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
    //Ожидание кликабельности элемента
    private WebElement waitForClickableElement(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Ожидание появления уведомления от браузера
    protected Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void fillInputField(By locator, String value) {
        WebElement element = waitForClickableElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"), "Введенный текст отличается от того что в элементе");
    }

    protected void clickOnElement(By locator) {
        WebElement element = waitForClickableElement(locator);
        element.click();
    }

    protected void waitInSeconds(int seconds) {
        try{
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
