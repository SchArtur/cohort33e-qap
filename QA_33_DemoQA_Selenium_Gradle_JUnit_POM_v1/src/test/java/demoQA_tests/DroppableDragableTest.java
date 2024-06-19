package demoQA_tests;

import core.BaseTest;

import static core.AppManager.homePage;

public class DroppableDragableTest extends BaseTest {

    void dragTest(){
        homePage.clickOnInteractions()
                .clickOnDroppableDragable()
                .dragPannel()
                .getDraggableTexts()
                .getDaggablePosition()
                .checkDraggablePosition(100,200);

    }

}
