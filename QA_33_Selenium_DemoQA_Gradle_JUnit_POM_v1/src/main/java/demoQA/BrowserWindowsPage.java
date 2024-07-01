package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowserWindowsPage extends BasePage {
  public static final String THIS_IS_A_SAMPLE_TEXT = "This is a sample page";

  @FindBy(id = "tabButton")
  public static WebElement newTabButton;
  @FindBy(id = "windowButton")
  public static WebElement newWindowButton;
  @FindBy(id = "messageWindowButton")
  public static WebElement newMessageButton;
  @FindBy(id = "sampleHeading")
  public static WebElement sampleHeadingText;
  @FindBy(xpath = "//body[contains(text(), 'Knowledge increases by sharing')]")
  WebElement bodyText;



  public void verifyNewWindowsMessage(String text) {
    assertTrue(shouldHaveText(sampleHeadingText, text, 5));
  }

  public BrowserWindowsPage switchToNextWindow(int index) {
    List<String> windows = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(windows.get(index));
    return new BrowserWindowsPage();
  }

  public BrowserWindowsPage switchToToLastOpenWindow() {
    List<String> windows = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(windows.get(windows.size()-1));
    return new BrowserWindowsPage();
  }

  public void verifyBodyTextExist() {
    assertNotNull(bodyText, "Body text does not exist");
  }
}
