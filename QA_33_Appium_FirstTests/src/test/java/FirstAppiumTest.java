import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstAppiumTest {

    @Test
    void clockTest() throws MalformedURLException {
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

//        com.google.android.deskclock/com.android.deskclock.DeskClock - либо LogCat (ActivityManager -Displayed )
//        либо в cmd: adb -e shell dumpsys window windows | grep Focus
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

    @Test
    void clockTest2() throws MalformedURLException {
        AppiumStartServer.startServer();
        //Аналог DesiredCapabilities, но уже с предустановленными настройками платфомы и драйвера
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.google.android.deskclock")
                .setAppActivity("com.android.deskclock.DeskClock");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement elementCities = driver.findElement(AppiumBy.accessibilityId("Cities"));
        elementCities.click();
        WebElement elementCheckBoxAbidjan = driver.findElement(AppiumBy.accessibilityId("Abidjan"));
        elementCheckBoxAbidjan.click();
        driver.navigate().back();

        WebElement abidjanElement = driver.findElement(AppiumBy.id("com.google.android.deskclock:id/city_name"));
        Assertions.assertEquals("Abidjan", abidjanElement.getText());
        driver.navigate().back();
        AppiumStartServer.stopServer();
    }

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

//        com.google.android.deskclock/com.android.deskclock.DeskClock - либо LogCat (ActivityManager -Displayed )
//        либо в cmd: adb -e shell dumpsys window windows (| grep Focus - искать Focus)
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement twoDigit = driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2"));
        WebElement plus = driver.findElement(AppiumBy.accessibilityId("plus"));
        twoDigit.click();
        plus.click();
        twoDigit.click();
        WebElement equals = driver.findElement(AppiumBy.accessibilityId("equals"));
        equals.click();
        WebElement result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result"));
        Assertions.assertEquals("4", result.getText());
        WebElement clear = driver.findElement(AppiumBy.accessibilityId("clear"));
        clear.click();
    }

    @Test
    void calcTest2() throws IOException {
        AppiumStartServer.startServer();
        //Аналог DesiredCapabilities, но уже с предустановленными настройками платфомы и драйвера
        UiAutomator2Options options = new UiAutomator2Options()
                //установка приложения на телефон
                .setApp(new File("src/test/resources/mobiCalculatorApp.apk").getAbsolutePath())
                //Запуск эмулятора (cmd: emulator -list-avds  посмотреть имя эмулятора)
                .setPlatformVersion("8")
                .setAvd("android_jenkins_26");
//my.android.calc/my.android.calc.MainActivity

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.alertIsPresent()).accept();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        WebElement twoDigit = driver.findElement(AppiumBy.id("my.android.calc:id/b031"));
        WebElement plus = driver.findElement(AppiumBy.id("my.android.calc:id/b043"));
        twoDigit.click();
        plus.click();
        twoDigit.click();
        WebElement equals = driver.findElement(AppiumBy.id("my.android.calc:id/b044"));
        equals.click();
        WebElement result = driver.findElement(AppiumBy.id("my.android.calc:id/result"));
        Assertions.assertEquals("4", result.getText());
        WebElement clear = driver.findElement(AppiumBy.id("my.android.calc:id/b003"));
        clear.click();

        Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");

        AppiumStartServer.stopServer();
    }


}
