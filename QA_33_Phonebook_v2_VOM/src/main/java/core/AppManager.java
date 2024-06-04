package core;

import model.User;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_helpers.HomePageHelper;
import page_helpers.UserHelper;

import java.time.Duration;

public class AppManager {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static User TEST_USER = new User("manuel@gm.com", "Manuel1234$");
    static final String URL_PHONE_BOOK = "https://telranedu.web.app";
    private String browser;

    private HomePageHelper homePageHelper;
    private UserHelper userHelper;

    public AppManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(URL_PHONE_BOOK);

        homePageHelper = new HomePageHelper(driver, wait);
        userHelper = new UserHelper(driver, wait);
    }

    public HomePageHelper getHomePageHelper() {
        return homePageHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public void stop() {
        driver.quit();
    }
}
