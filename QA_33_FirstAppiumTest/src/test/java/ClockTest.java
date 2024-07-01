import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ClockTest {

    @Test
    void calcTest() throws MalformedURLException {
        //Создаем объект Capability для настройки параметров сеанса Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Платформа - Андроид
        capabilities.setCapability("platformName", Platform.ANDROID);
        //Указываем драйвер для автоматизации
        capabilities.setCapability("automationName", "UiAutomator2");
        // Пакет приложения
        capabilities.setCapability("appPackage", "com.google.android.deskclock");
        // Активити приложения
        capabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");

//        com.google.android.deskclock/com.android.deskclock.DeskClock - либо LogCat (ActivityManager -Displayed ) либо в cmd: adb -e shell dumpsys window windows | grep Focus
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement elementCities = driver.findElement(AppiumBy.accessibilityId("Cities"));
        elementCities.click();
        WebElement elementCheckBoxAbidjan = driver.findElement(AppiumBy.accessibilityId("Abidjan"));
        elementCheckBoxAbidjan.click();
        driver.navigate().back();

        WebElement abidjanElement = driver.findElement(AppiumBy.id("com.google.android.deskclock:id/city_name"));
        Assertions.assertEquals("Abidjan", abidjanElement.getText());
    }

//    1) cmd: appium  (запускает appium server)   для закрытия - taskkill /F /IM node.exe
//    2) cmd: emulator -avd Pixel (start emulator)
//    3) Appium Inspector (для получения локаторов)

}
