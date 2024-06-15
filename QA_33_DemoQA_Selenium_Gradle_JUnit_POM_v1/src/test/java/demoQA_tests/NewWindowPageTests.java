package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static core.AppManager.*;
import static demoQA.BrowserWindowsPage.*;
@DisplayName("Тестовый класс для проверки \"Alerts, Frame & Windows\" --> \"Browser Windows\"")
public class NewWindowPageTests extends BaseTest {
  @BeforeEach
  public void precondition() {
    homePage.getAlertsFrameWindow().selectBrowserWindows().hideAds();
  }

  @DisplayName("Browser Windows -->  \"New Tab\"")
  @Test
  public void newTabTest() {
    basePage.click(newTabButton);
    browserWindowsPage.switchToNextWindow(1).verifyNewWindowsMessage(THIS_IS_A_SAMPLE_TEXT);
  }

  @DisplayName("Browser Windows -->  \"New Window\"")
  @Test
  public void newWindowTest() {
    basePage.click(newWindowButton);
    browserWindowsPage.switchToNextWindow(1).verifyNewWindowsMessage(THIS_IS_A_SAMPLE_TEXT);
  }

  @DisplayName("Browser Windows -->  \"New Window Message\"")
  @Test
  public void messageWindowTest() {
    basePage.click(newMessageButton);
    browserWindowsPage.switchToToLastOpenWindow().verifyBodyTextExist();
  }
}
