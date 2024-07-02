package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static core.AppManager.homePage;

public class DroppableTests extends BaseTest {

    @Test
    void dropTest() {
        homePage.clickOnInteractions()
                .clickOnDroppable()
                .dragAndDrop();
    }
}
