package core;

import model.NewAccount;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_helpers.CreateAccountHelper;
import page_helpers.LoginHelper;

import java.time.Duration;

import static model.NewAccount.randomEmail;

public class AppManager {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static User TEST_USER = new User("antonantonov@gmail.com", "WvN3W$VUTA72T");
    public static NewAccount NEW_USER = new NewAccount("Anton","Antonov",randomEmail(), "WvN3W$VUTA72T","WvN3W$VUTA72T");
    static final String URL_DEMO_WEBSHOP = "https://demowebshop.tricentis.com/";
    private String browser;

    public CreateAccountHelper createAccountHelper;
    public LoginHelper loginHelper;

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
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(URL_DEMO_WEBSHOP);

        createAccountHelper = new CreateAccountHelper(driver, wait);
        loginHelper = new LoginHelper(driver, wait);

    }

    public CreateAccountHelper getCreateAccountHelper() {
        return createAccountHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public void stop() {
        driver.quit();
    }
}
