package demoQA;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends BasePage {
  @FindBy(id = "oldSelectMenu")
  WebElement oldSelectMenuList;
  @FindBy(id = "react-select-4-input")
  WebElement selectInput;
  @FindBy(id = "cars")
  WebElement cars;

  public void selectOldStyle(String color) {
    Select select = new Select(oldSelectMenuList);
    select.selectByVisibleText(color);

    List<WebElement> options = select.getOptions();
    System.out.println("[" + select.getFirstSelectedOption().getText() + "] это первый элемент в списке.");

    for (WebElement listItem : options) {
      System.out.println("[" + listItem.getText() + "] " + listItem.getAttribute("value"));
    }
  }

  public void multiSelect(String[] colors) {
    for (String color : colors) {
      if (color != null) {
        selectInput.sendKeys(color);
        selectInput.sendKeys(Keys.ENTER);
      }
    }
  }

  public void standardMultiSelect(int[] indices) {
    Select select = new Select(cars);
    List<WebElement> options = select.getOptions();
    if (select.isMultiple()) {
      for (int index : indices) {
        if (index >=0 && index < options.size()){
          select.selectByIndex(index);
        } else{
          System.out.println("Индекс " + index + " выходит за пределы допустимого диапазона");
        }
      }
    }
  }
}
