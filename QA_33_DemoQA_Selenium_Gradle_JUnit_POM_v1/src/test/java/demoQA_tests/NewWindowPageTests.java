package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static core.AppManager.*;
import static demoQA.BrowserWindowsPage.*;

public class NewWindowPageTests extends BaseTest {
  @BeforeEach
  public void precondition (){
    homePage.getAlertsFrameWindow().selectBrowserWindows();
  }

  @Test
  public void newTabTest() {
    basePage.click(newTabButton);
    browserWindowsPage.switchToNextWindow(1).verifyNewWindowsMessage(THIS_IS_A_SAMPLE_TEXT);
  }

  @Test
  public void newWindowTest() {
    basePage.click(newWindowButton);
    browserWindowsPage.switchToNextWindow(1).verifyNewWindowsMessage(THIS_IS_A_SAMPLE_TEXT);
  }

  @Test
  public void messageWindowTest() {
    basePage.click(newMessageButton);
    browserWindowsPage.switchToToLastOpenWindow().verifyBodyTextExist();
  }
}
