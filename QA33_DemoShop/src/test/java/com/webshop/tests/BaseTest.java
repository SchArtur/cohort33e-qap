package com.webshop.tests;

import com.webshop.tests.data.User;
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
    static final String URL_DEMO_WEBSHOP = "https://demowebshop.tricentis.com/";
    static final String LOGIN = "Log in";
    static final String REGISTRATION = "Registration";
    static final User TEST_USER = new User("AntonAntonov@gmail.com", "WvN3W$VUTA72T");

    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().window().maximize();
        driver.get(URL_DEMO_WEBSHOP);
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

    protected void clickOnElement(By locator) {
        WebElement element = waitForClickableElement(locator);
        element.click();
    }

    protected void loginOrRegistration(User user, String loginOrRegistration) {
        clickOnElement(By.xpath("//*[text()='Log in']"));
        fillInputField(By.name("Email"), user.getEmail());
        fillInputField(By.name("Password"), user.getPassword());
        if (LOGIN.equals(loginOrRegistration)) {
            clickOnElement(By.xpath("//input[@class='button-1 login-button']"));
        } else if (REGISTRATION.equals(loginOrRegistration)) {
            clickOnElement(By.name("ico-register"));
        }
    }

    protected void loginTestUser() {
        loginOrRegistration(TEST_USER, LOGIN);
    }

    protected void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


