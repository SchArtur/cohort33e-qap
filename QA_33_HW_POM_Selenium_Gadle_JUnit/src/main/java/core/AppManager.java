package core;

import googlePages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class AppManager {


    public static BasePage basePage;
    public static HomePage homePage;

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static final int WAIT_TIMEOUT = 3;

    private final String browser;

    public AppManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        switch (browser.toLowerCase()) {
            case "google":
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIMEOUT));
        driver.manage().window().maximize();

        //из BasePage берем метод для вызывания сылки, в скобки передать ссылку на url
        basePage.open(homePage.GOOGLE_URL);
    }

    // Метод для завершения работы драйвера
    public void stop() {
        // * Для владельцев ОС Windows, у которых не закрывается chromedriver.exe после завершения тестов и дальше висит в Диспетчере задач
        if (driver != null) {
            driver.quit();
        }
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException ignored) {
        }


    }
}
