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

public class TestBase {
    public WebDriver driver;
    protected static final String DEMO_SHOP_URL = "https://demowebshop.tricentis.com/";
    static final String REGISTER ="Register";
    static final String LOG_IN= "Log_in";

    WebDriverWait wait;

    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().window().fullscreen();
        driver.get(DEMO_SHOP_URL);
    }
    @AfterEach
    void quitDriver(){ driver.quit();}

    public WebElement getElementBy(By locator){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public WebElement waitForClickableElement (By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected Alert getAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void  fillInputField(By locator, String value){
        WebElement element = waitForClickableElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
        Assertions.assertEquals(value, element.getAttribute("value"), " The input text is different from pointed in Element ");
    }
    protected void clickOnElement(By locator){
        WebElement element = waitForClickableElement(locator);
        element.click();
    }

}
