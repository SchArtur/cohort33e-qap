package demoQA;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DroppableDragablePage extends BasePage {

    @FindBy(id = "draggable")
    WebElement draggable;

    @FindBy(id = "droppable")
    WebElement droppable;

    @FindBy(id = "draggableExample-tab-simple")
    WebElement draggableSimple;
    //style="position: relative; left: 87px; top: 20px;"
    @FindBy(id = "dragBox")
    WebElement dragMe;


    @FindBy(id = "draggableExample-tab-axisRestriction")
    WebElement draggableAxisRestriction;
    @FindBy(id = "restrictedX")
    WebElement onlyX;
    @FindBy(id = "restrictedY")
    WebElement onlyY;


    @FindBy(id = "draggableExample-tab-containerRestriction")
    WebElement draggableContainerRestriction;
    @FindBy(id = "containmentWrapper")
    WebElement containmentWrapper;
    @FindBy(xpath = "//div[contains(text(),'I'm contained within the box')]")
    //style="position: relative; left: 0px; top: 0px;"
    WebElement containmentBox;
    @FindBy(xpath = "//div[@class='draggable ui-widget-content']")
    WebElement parentContainer;
    @FindBy(xpath = "//div[@class='draggable ui-widget-content']//span[contains(text(),'I'm contained within my parent')]")
    //@FindBy (xpath = "//div[@class='draggable ui-widget-content']// child:: text(),'I'm contained within my parent')]")
    WebElement childText;


    @FindBy(id = "draggableExample-tab-cursorStyle")
    WebElement draggableCursorStyle;
    @FindBy(className = "cursor-style-container mt-4")
    WebElement styleContainer;

    @FindBy(xpath = "//div[@id='cursorCenter'] contains(text(),'I will always stick to the center')]")
    //style="position: relative; left: 134.188px; top: 98.3333px;"
    WebElement cursorCenter;
    @FindBy(xpath = "//div[@id='cursorTopLeft'] contains(text(),'My cursor is at top left']")
    //style="position: relative; left: -9.5625px; top: -112.99px;"
    WebElement cursorTopLeft;
    @FindBy(xpath = "div[@id='cursorBottom'] contains(text(),'My cursor is at bottom")
    //style="position: relative; left: 276px; top: -15px;"
    WebElement cursorBottom;


    public DroppableDragablePage dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable)
                .perform();

        Assertions.assertEquals("Dropped!", droppable.getText(), "Объект не перенесен");
        return this;
    }

    public DroppableDragablePage dragPannel() {
        return (DroppableDragablePage) List.of(draggableSimple, draggableAxisRestriction, draggableContainerRestriction, draggableCursorStyle);
    }

    public DroppableDragablePage draggingElements() {
        return (DroppableDragablePage) List.of(dragMe, onlyX, onlyY, containmentBox, childText, cursorTopLeft, cursorCenter, cursorBottom);
    }

    public DroppableDragablePage getDraggableTexts() {
        return (DroppableDragablePage) List.of(dragMe.getText(), onlyX.getText(), onlyY.getText(), containmentBox.getText(), childText.getText(), cursorTopLeft.getText(), cursorCenter.getText(), cursorBottom.getText());
    }

    public DroppableDragablePage getDaggablePosition() {
        return (DroppableDragablePage) List.of(dragMe.getLocation(), onlyX.getLocation(), onlyY.getLocation(), containmentBox.getLocation(), childText.getLocation(), cursorTopLeft.getLocation(), cursorCenter.getLocation(), cursorBottom.getLocation());
    }

    public DroppableDragablePage checkDraggablePosition(int expectedLeft, int expectedTop) {
        List<WebElement> elements = (List<WebElement>) draggingElements();

        for (WebElement element : elements) {
            Point location = element.getLocation();
            Point actualLeft =element.getLocation();
            Point actualTop = element.getLocation();

            Assertions.assertEquals(actualLeft, expectedLeft, "Position left for element " + element + " does not match the expected value");
            Assertions.assertEquals(actualTop, expectedTop, "Position top for element " + element + " does not match the expected value");
        }

        return this;
    }
}








