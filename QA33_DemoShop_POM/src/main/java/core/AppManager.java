package core;

import google.BasePage;
import google.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppManager {
    public static BasePage basePage;
    public static HomePage homePage;
    public static WebDriver driver; // Объявляем драйвер как статическое поле, чтобы иметь к нему доступ из любого места программы
    private final String browser; // Объявляем переменную browser, чтобы хранить значение браузера
    public static WebDriverWait wait; // Объявляем wait как статическое поле, чтобы иметь к нему доступ из любого места программы
    public static final int WAIT_TIMEOUT = 5; // Объявляем константу WAIT_TIMEOUT, чтобы хранить значение таймаута ожидания

    public AppManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT)); // Инициализируем wait с таймаутом ожидания в 5 секунд
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIMEOUT)); // Устанавливаем неявное ожидание до 5 секунд
        driver.manage().window().maximize();
        basePage = new BasePage();
        homePage = new HomePage();
    }

    public void stop() {
        //driver.quit(); // Закрываем браузер
    }
}

