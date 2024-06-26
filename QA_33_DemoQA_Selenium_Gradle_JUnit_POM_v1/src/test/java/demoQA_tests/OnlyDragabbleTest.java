package demoQA_tests;

import core.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static core.AppManager.homePage;
import static core.AppManager.onlyDragabblePage;
import static core.AppManager.sidePanel;

public class OnlyDragabbleTest extends BaseTest {

    @BeforeEach
    public void precondition() {
        sidePanel.scrollPage();
        homePage.clickOnInteractions();
        sidePanel.scrollPage();
        sidePanel.clickOnDraggable();
        onlyDragabblePage.draggableAxisRestriction();
    }

    @Feature("OnlyDragabble tests")
    @Story("drag OnlyX")
    @DisplayName("drag for 20px to the right  and after for -40px to the left ")
    @Test
    public void dragOnlyXTest(){
        // Сдвигаем  OnlyX на 20 px  вправо
        onlyDragabblePage.dragOnlyX(20);
        // Сдвигаем  OnlyX на 40 px  влево
        onlyDragabblePage.dragOnlyX(-40);
    }
}
