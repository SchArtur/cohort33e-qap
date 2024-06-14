package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static core.AppManager.homePage;
import static core.AppManager.selectMenuPage;

public class SelectMenuTests extends BaseTest {
  @BeforeEach
  public void precondition(){
    homePage.getWidgets().getSelectMenu();
  }

  @Test
  public void selectOldStyleMenuTest(){
    selectMenuPage.selectOldStyle("Green");
  }

  @Test
  public void multiSelectOldStyleTest(){
    selectMenuPage.multiSelect(new String[] {"Red","Blue"});
  }

  @Test
  public void standardMultiSelectTest(){
    int[] indices = {0,5};
    selectMenuPage.standardMultiSelect(indices);
  }
}
