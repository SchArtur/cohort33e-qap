
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class FirstSeleniumTest {
    private static final String URL="https://telranedu.web.app/home";
    public WebDriver driver;
    @BeforeEach
    void startDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterEach
    void quitDriver(){
        driver.quit();
    }
    @Test

    @DisplayName("Проверка заголовка страницы")

    void testOpenBrowser(){
        driver.get("http:/www.google.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        Assertions.assertEquals("Google", driver.getTitle(), "Открыта страница с другим  Title" );

    }
}
