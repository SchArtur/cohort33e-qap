import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ColomboClockTest {

    @Test
    void clockTest() throws MalformedURLException {
        AppiumStartServer.startServer();
        //Аналог DesiredCapabilities, но уже с предустановленными настройками платфомы и драйвера
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.google.android.deskclock")
                .setAppActivity("com.android.deskclock.DeskClock")
                .setAvd("Pixel");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement elementCities = driver.findElement(AppiumBy.accessibilityId("Cities"));
        elementCities.click();
        WebElement elementSearch = driver.findElement(AppiumBy.accessibilityId("Search"));
        elementSearch.click();
        WebElement searchField = driver.findElement(AppiumBy.id("com.google.android.deskclock:id/search_src_text"));
        searchField.click();
        searchField.sendKeys("Colombo");
        WebElement elementCheckBoxColombo = driver.findElement(AppiumBy.accessibilityId("Colombo"));
        elementCheckBoxColombo.click();
        driver.navigate().back();

        WebElement colomboElement = driver.findElement(AppiumBy.id("com.google.android.deskclock:id/city_name"));
        Assertions.assertEquals("Colombo", colomboElement.getText());
        driver.navigate().back();
        AppiumStartServer.stopServer();
    }
}
