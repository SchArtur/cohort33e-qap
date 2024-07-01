package demoQA;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage {

    @FindBy(id = "draggable")
    WebElement draggable;

    @FindBy(id = "droppable")
    WebElement droppable;

    public DroppablePage dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable)
                .perform();

        Assertions.assertEquals("Dropped!", droppable.getText(), "Объект не перенесен");
        return this;
    }

}
