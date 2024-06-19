package demoQA;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OnlyDragabblePage extends BasePage {

    @FindBy(id = "draggable")
    WebElement draggable;
    @FindBy(id = "droppable")
    WebElement droppable;
    @FindBy(id = "draggableExample-tab-axisRestriction")
    WebElement draggableAxisRestriction;
    @FindBy(id = "restrictedX")
    WebElement onlyX;
    @FindBy(id = "restrictedY")
    WebElement onlyY;


    public OnlyDragabblePage dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable)
                .perform();

        Assertions.assertEquals("Dropped!", droppable.getText(), "Объект не перенесен");
        return this;
    }

    public OnlyDragabblePage draggableAxisRestriction() {
        draggableAxisRestriction.click();
        return this;

    }

    public OnlyDragabblePage dragOnlyX(int px) {
        Actions actions = new Actions(driver);
        Point initialPosition = onlyX.getLocation();
        int initialX = initialPosition.getX();

        //сдвигаем на 20px вправо
        actions.dragAndDropBy(onlyX, px, 0).perform();
        Point draggedToTheRightPosition = onlyX.getLocation();
        int draggedToRightX = draggedToTheRightPosition.getX();

        Assertions.assertEquals(initialX + px, draggedToRightX, "OnlyX dragged not correctly");

//        //сдвигаем на 40px влево
//        actions.dragAndDropBy(onlyX, -40, 0).perform();
//        Point draggedToTheLeftPosition = onlyX.getLocation();
//        int draggedToLeftX = draggedToTheLeftPosition.getX();
//
//        Assertions.assertEquals(draggedToRightX - 40, draggedToLeftX, "OnlyX dragged not correctly");
        return this;
    }

}
