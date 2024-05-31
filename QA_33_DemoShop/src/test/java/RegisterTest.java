import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends TestBase {
    @Test
    @DisplayName("посик элемента по локаторам, тексту, атрибутам, тегам, имени")
    void RegisterElementTest() {
        driver.get(DEMO_SHOP_URL);
        WebElement registerByCss = driver.findElement(By.cssSelector("a[href= '/register']"));
        Assertions.assertTrue(registerByCss.isDisplayed(), "registerByCss is not found");

        WebElement registerByXPath = getElementBy(By.xpath("//*[@[href= 'register']"));
        Assertions.assertTrue(registerByXPath.isDisplayed(), "registerByCss is not found");

        WebElement registerByText = driver.findElement(By.linkText("Register")) ;
        Assertions.assertEquals("Register", registerByText.getText(), "registerByText is not Register");

        WebElement registerByPartlyText = driver.findElement(By.partialLinkText("Reg"));
        Assertions.assertEquals("Register", registerByPartlyText.getText(),"registerByPartlyText is not Register");

    }


}
