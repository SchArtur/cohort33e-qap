package core;

import demoQA.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.time.Duration;

public class AppManager {
  public static BasePage basePage;
  public static HomePage homePage;
  public static AlertsPage alertsPage;
  public static SidePanel sidePanel;
  public static BrowserWindowsPage browserWindowsPage;
  public static SelectMenuPage selectMenuPage;

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
      case "edge":
        driver = new EdgeDriver();
        break;
      case "safari":
        driver = new SafariDriver();
        break;
      case "chrome":
      default:
        driver = new ChromeDriver();
    }
    wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT)); // Инициализируем wait с таймаутом ожидания в 5 секунд
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIMEOUT)); // Устанавливаем неявное ожидание до 5 секунд
    driver.manage().window().maximize();
    // ! Инициализируем объект basePage и др., чтобы иметь доступ к методам этих классов из любого места программы
    basePage = new BasePage();
    homePage = new HomePage();
    sidePanel = new SidePanel();
    alertsPage = new AlertsPage();
    browserWindowsPage = new BrowserWindowsPage();
    selectMenuPage = new  SelectMenuPage();
    // ! Открываем домашнюю страницу как первый шаг в каждом тесте
    basePage.open(homePage.HOME_PAGE_URL);
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






