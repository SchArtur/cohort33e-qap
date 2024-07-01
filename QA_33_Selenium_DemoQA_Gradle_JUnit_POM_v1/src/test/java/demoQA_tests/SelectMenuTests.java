package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static core.AppManager.homePage;
import static core.AppManager.selectMenuPage;

@DisplayName("Тестовый класс для проверки \"Widgets\" --> \"Select Menu\"")
public class SelectMenuTests extends BaseTest {
  @BeforeEach
  public void precondition() {
    homePage.getWidgets().getSelectMenu().hideAds(); // ! getSelectMenu возможно с JS
  }

  @DisplayName("Widgets --> \"Old Style Menu\"")
  @Test
  public void selectOldStyleMenuTest() {
    selectMenuPage.selectOldStyle("Green");
  }

  @DisplayName("Widgets --> \"Multi Select\"")
  @Test
  public void multiSelectOldStyleTest() {
    selectMenuPage.multiSelect(new String[]{"Red", "Blue"});
  }

  @DisplayName("Widgets --> \"Standard multi select\"")
  @Test
  public void standardMultiSelectTest() {
    int[] indices = {0, 5};
    selectMenuPage.standardMultiSelect(indices);
  }
}
