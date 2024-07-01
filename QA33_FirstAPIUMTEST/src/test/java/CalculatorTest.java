import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void calcTest() throws MalformedURLException {
        //Создаем объект Capability для настройки параметров сеанса Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Платформа - Андроид
        capabilities.setCapability("platformName", Platform.ANDROID);
        //Указываем драйвер для автоматизации
        capabilities.setCapability("automationName", "UiAutomator2");
        // Пакет приложения
        capabilities.setCapability("appPackage", "com.android.calculator2");
        // Активити приложения
       capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

//        com.google.android.deskclock/com.android.deskclock.DeskClock - либо LogCat (ActivityManager -Displayed ) либо в cmd: adb -e shell dumpsys window windows | grep Focus
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement elementCalculatorTwo = driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2"));
        elementCalculatorTwo.click();

        WebElement elementCalculatorPlus = driver.findElement(AppiumBy.accessibilityId("plus"));
        elementCalculatorPlus.click();

        WebElement elementCalculatorAgainTwo = driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2"));
        elementCalculatorAgainTwo.click();

        WebElement elementCalculatorEquals = driver.findElement(AppiumBy.accessibilityId("equals"));
       elementCalculatorEquals.click();

        WebElement elementCalculatorResult = driver.findElement(AppiumBy.id("com.android.calculator2:id/result"));
        elementCalculatorResult.click();
        assertEquals("4", elementCalculatorResult.getText());

        WebElement elementCalculatorClear = driver.findElement(AppiumBy.accessibilityId("clear"));
        elementCalculatorClear.click();


    }

//    1) cmd: appium  (запускает appium server)   для закрытия - taskkill /F /IM node.exe
//    2) cmd: emulator -avd Pixel (start emulator)
//    3) Appium Inspector (для получения локаторов)

}
