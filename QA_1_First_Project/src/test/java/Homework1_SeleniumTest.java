import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework1_SeleniumTest {
   private static final String URL = "https://ilcarro.web.app/search";
   public WebDriver driver;

   @BeforeEach
    void startDriver(){
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   }

   @AfterEach
    void quitDriver() { driver.quit();}

@Test
@DisplayName("Checking search page")
void testOpenBrowser(){
    driver.get("https://ilcarro.web.app/search");
   driver.navigate().back();
   driver.navigate().forward();
   driver.navigate().refresh();
    Assertions.assertEquals("Search", driver.getTitle(), "Opened page with other Title");
   }
}
