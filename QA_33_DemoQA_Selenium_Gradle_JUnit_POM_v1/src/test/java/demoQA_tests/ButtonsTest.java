package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static core.AppManager.buttonsPage;
import static demoQA.ButtonsPage.clickMeButton;

@DisplayName("Тестовый класс для проверки \"Elements\" --> \"Buttons\"")
public class ButtonsTest extends BaseTest {

  @BeforeEach
  public void precondition() {
    buttonsPage.getElementButton().getButtonsButton().hideAds();
  }

  @DisplayName("Elements --> \"Buttons\" --> \"Double Click Me\"")
  @Test
  public void doubleClickTest() {
    buttonsPage.doubleClick().assertDoubleClick("You have done a double click");
  }

  @DisplayName("Elements --> \"Buttons\" --> \"Right Click Me\"")
  @Test
  public void rightClickTest() {
    buttonsPage.rightClick().assertRightClick("You have done a right click");
  }

  @DisplayName("Elements --> \"Buttons\" --> \"Click Me\"")
  @Test
  public void clickTest() {
    buttonsPage.click(clickMeButton);
    buttonsPage.assertClickMe("You have done a dynamic click");
  }
}

