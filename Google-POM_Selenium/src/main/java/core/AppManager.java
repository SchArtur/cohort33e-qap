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
    public static WebDriver driver;
    private final String browser;
    public static WebDriverWait wait;
    public static final int WAIT_TIMEOUT =5;


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
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIMEOUT));
        driver.manage().window().maximize();
        basePage = new BasePage();
        homePage = new HomePage();
    }

    public void stop(){
        driver.quit();
    }
}
