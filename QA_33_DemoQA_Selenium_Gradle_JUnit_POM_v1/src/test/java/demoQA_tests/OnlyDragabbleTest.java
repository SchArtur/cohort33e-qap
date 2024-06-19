package demoQA_tests;

import core.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;

import static core.AppManager.homePage;
import static core.AppManager.onlyDragabblePage;
import static core.AppManager.sidePanel;

public class OnlyDragabbleTest extends BaseTest {
    @Test

    @BeforeEach
    public void precondition() {
        homePage.clickOnInteractions();
        sidePanel.clickOnDroppableDragable();
        onlyDragabblePage.draggableAxisRestriction();
    }

    @Feature("OnlyDragabble tests")
    @Story("drag OnlyX")
    @DisplayName("drag for 20px to the right  and after for -40px to the left ")
    public void dragOnlyXTest(){
        // Сдвигаем  OnlyX на 20 px  вправо
        onlyDragabblePage.dragOnlyX();
        // Сдвигаем  OnlyX на 40 px  влево
        onlyDragabblePage.dragOnlyX();
    }
}
