package core;

import model.RegisterForm;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import page_helpers.AddToCartHelper;
import page_helpers.HomePageHelper;
import page_helpers.LoginHelper;
import page_helpers.RegisterFormHelper;

import java.time.Duration;

public class AppManager {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static User LOGIN_USER = new User("tramp1@test.com", "Tramp123!");
    public static RegisterForm REGISTER_USER= new RegisterForm ("male", "Tramp", "Tramp", "tramp1@test.com", "Tramp123!", "Tramp123!");
    static final String DEMO_SHOP_URL = "https://demowebshop.tricentis.com/";
    private String browser;

    public HomePageHelper homePageHelper;
    public LoginHelper loginHelper;
    public RegisterFormHelper registerFormHelper;
    public AddToCartHelper addToCartHelper;


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
        driver.get(DEMO_SHOP_URL);

        homePageHelper = new HomePageHelper(driver, wait);
        loginHelper = new LoginHelper(driver, wait);
        registerFormHelper = new RegisterFormHelper(driver, wait);
    }

    public HomePageHelper getHomePageHelper() {
        return homePageHelper;
    }
    public LoginHelper getLoginHelper(){
        return loginHelper;
    }

    public RegisterFormHelper getRegisterFormHelper() {
        return registerFormHelper;
    }
    public void stop(){
        driver.quit();
    }
    }


