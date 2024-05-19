import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Homework_2 {
    private static final String URL_DEMO_WEB_SHOP = "https://demowebshop.tricentis.com/";
    public WebDriver driver;
    WebDriverWait wait;
    @BeforeEach
    void startDriver() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @AfterEach
    void quitDriver() {
        driver.quit();
    }
    public WebElement getElementBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    private WebElement waitForClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    @Test
    @DisplayName("Проверка заголовка страницы")
    void testOpenBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demowebshop.tricentis.com/");
        //driver.navigate().forward();
       // driver.navigate().back();
       // driver.navigate().refresh();
        Assertions.assertEquals("Demo Web Shop", driver.getTitle(), "Открыта другая страница с другим Title");
    }
    @Test
    @DisplayName("Поиск  элементов по тегу")
    void test1() {
        driver.get(URL_DEMO_WEB_SHOP);

        //WebElement elementTitle= (WebElement) driver.findElements(By.tagName("title"));
        //Assertions.assertEquals("Demo Web Shop", elementTitle.getText(),"Заголовок страницы не Demo Web Shop");

        List<WebElement> listAElements = driver.findElements(By.tagName("a"));
        Assertions.assertFalse(listAElements.isEmpty(),"Нет элементов с тегом \"a\"");
       //97 st.

        List<WebElement> listAElements2 = driver.findElements(By.tagName("img"));
        Assertions.assertFalse(listAElements2.isEmpty(),"Нет элементов с тегом \"img\"");



        WebElement elementByClassName = getElementBy(By.className("header-logo"));
        Assertions.assertTrue(elementByClassName.isDisplayed(), "elementByClassName нет на странице");

        // WebElement elementByPartialLinkText;
        //elementByPartialLinkText = getElementBy(By.partialLinkText("Popular "));
        //Assertions.assertTrue(elementByPartialLinkText.isDisplayed(), "elementByPartialLinkText нет на странице");


        //WebElement elementByLinkText = getElementBy(By.linkText("Community poll"));
       //Assertions.assertTrue(elementByLinkText.isDisplayed(), "elementByLinkText нет на странице");

       // WebElement elementByLinkText3 = getElementBy(By.linkText("Wishlist"));
        //Assertions.assertTrue(elementByLinkText3.isDisplayed(), "elementByLinkText нет на странице");

        //WebElement elementByName = getElementBy(By.name("Email"));
       // Assertions.assertTrue(elementByName.isDisplayed(), "elementByName нет на странице");

        //WebElement elementByCss = getElementBy(By.cssSelector("[label for='email']"));
        //Assertions.assertTrue(elementByCss.isDisplayed(), "elementByName нет на странице");

        /*WebElement elementByxPath = getElementBy(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]"));
        Assertions.assertTrue(elementByName.isDisplayed(), "elementByName нет на странице");*/
    }
}
