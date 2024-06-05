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
import page_helpers.LoginPageHelper;

import java.time.Duration;

public class AppManager {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static User TEST_USER = new User("ivanivanov4@gmail.com", "GhUl20DsaVx");
    public static NewAccount NEW_USER = new NewAccount("Ivan", "Ivanov", NewAccount.randomEmail(), "GhUl20DsaVx", "GhUl20DsaVx");
    static final String URL_DEMO_WEB_SHOP = "https://demowebshop.tricentis.com/";
    private String browser;

    private CreateAccountHelper createAccountHelper;
    private LoginPageHelper loginPageHelper;

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
        driver.get(URL_DEMO_WEB_SHOP);

        createAccountHelper = new CreateAccountHelper(driver, wait);
        loginPageHelper = new LoginPageHelper(driver, wait);

    }

    public CreateAccountHelper getCreateAccountHelper() {
        return createAccountHelper;
    }

    public LoginPageHelper getLoginPageHelper() {
        return loginPageHelper;
    }

    public void stop() {
        driver.quit();
    }


}
