package com.phonebook.tests;

import io.qameta.allure.Step;
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

    WebDriver driver;
    WebDriverWait wait;
    static final String URL_PHONE_BOOK = "https://telranedu.web.app";
    static final String LOGIN = "Login";
    static final String REGISTRATION = "Registration";

    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(URL_PHONE_BOOK);
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }

    protected WebElement getElementBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    private WebElement waitForClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

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

    @Step("Делаем клик по элементу с локатором {0}")
    protected void clickOnElement(By locator) {
        WebElement element = waitForClickableElement(locator);
        element.click();
    }

//    @Step("Заполняем форму авторизации {0} , {1} и нажимаем {2}")
    protected void login(String email, String password, String loginOrRegistration) {
        clickOnElement(By.xpath("//*[text()='LOGIN']"));
        fillInputField(By.name("email"), email);
        fillInputField(By.name("password"), password);
        if (LOGIN.equals(loginOrRegistration)) {
            clickOnElement(By.name("login"));
        } else if (REGISTRATION.equals(loginOrRegistration)) {
            clickOnElement(By.name("registration"));
        }
    }

    protected void loginTestUser() {
        login("manuel@gm.com", "Manuel1234$","Login");
    }
}
