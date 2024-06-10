package page_helpers;

import core.AppManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Random;

import static org.testng.Assert.*;

public class BaseHelper {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseHelper(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }

    @Step ("Webelement  получаем по локатору")
    protected WebElement getElementBy (By locator){
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    @Step("Ожидаем кликабельности элемента")
    private  WebElement waitForClickableElement (By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected Alert getAlert(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    @Step("Получаем текст всплывающего уведомления и нажимаем 'accept'")
    public String getAlertText() {
        String allerText = getAlert().getText();
        getAlert().accept();
        return allerText;
    }

    @Step ("Заполняем данные контакта")
    protected  void fillInputField(By locator, String value){
        WebElement element = waitForClickableElement(locator);
        element.click();
        element.clear();
        element.sendKeys(value);
        assertEquals(value, element.getAttribute("value"), "Введенный текст отличается от того что в элементе");
    }

    @Step ("Кликаем на елемент")
    protected void clickOnElement(By locator){
        WebElement element = waitForClickableElement(locator);
        element.click();
    }
    @Step ("Ожидаем {0} секундах")
    public void waitInSeconds(int seconds){
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Проверяем наличие элемента")
    protected boolean checkElementIsPresent(By locator){
        assertTrue(getElementBy(locator).isDisplayed(), String.format("Ожидаемый элемент с локатором %s не найден на странице", locator));
   return true;
    }

    @Step("Элемент  представлен по локатору")
    protected boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }





    //Делает скриншот и добавляет его в аллюр репорт
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
       return ((TakesScreenshot) AppManager.driver).getScreenshotAs(OutputType.BYTES);
    }


    //Делает скриншот и сохраняет его в папке screenshots и добавляет его в аллюр репорт
//    @Step("Делаем screenshot")
//    public static String takeScreenshot() {
//        File tmp = ((TakesScreenshot) AppManager.driver).getScreenshotAs(OutputType.FILE);
//        File screenshot = new File(String.format("screenshots/screen%s.png", System.currentTimeMillis()));
//        try {
//            Files.copy(tmp.toPath(), screenshot.toPath());
//            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return screenshot.getAbsolutePath();
//    }
}
