package core;

import model.NewAccount;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_helpers.CreateAccountPage;
import page_helpers.HomePage;
import page_helpers.LoginPage;

import java.time.Duration;

import static model.NewAccount.randomEmail;

public class AppManager {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static User TEST_USER = new User("antonantonov@gmail.com", "WvN3W$VUTA72T");
    public static NewAccount NEW_USER = new NewAccount("Anton","Antonov",randomEmail(), "WvN3W$VUTA72T","WvN3W$VUTA72T");
    static final String URL_DEMO_WEBSHOP = "https://demowebshop.tricentis.com/";
    private String browser;

    public static CreateAccountPage createAccountPage;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static RegisterPage registerPage;
    public LoginPage loginPage;

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

        createAccountPage = new CreateAccountPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
    }

    public void stop() {
        driver.quit();
    }
}
