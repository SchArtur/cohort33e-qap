import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW1_CheckingPageTitle {

    //Адрес страницы
    private static final String URL = "https://ilcarro.web.app/";
    //Драйвер
    public WebDriver driver;

    @BeforeEach
    void startDriver() {
        //Создание драйвера
        driver = new ChromeDriver();
        //Настройка ожидания появления элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void quitDriver() {
        driver.quit();//Закрытие браузера
    }

    @Test
    @DisplayName("Проверка заголовка страницы")
    void testOpenBrowser() {
        driver.get("https://ilcarro.web.app/");//Открытие страницы

        driver.navigate().back();//Возврат на предыдущую страницу
        driver.navigate().forward();//Переход на следующую страницу
        driver.navigate().refresh();//Обновление страницы
        Assertions.assertEquals("Search", driver.getTitle(), "Открыта страница с другим Title");//Проверка заголовка страницы
}
    }
