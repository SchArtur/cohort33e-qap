package demoQA;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {
  @FindBy(css = ".top-card:nth-child(1)")
  public WebElement elements;
  @FindBy(xpath = "//span[contains(text(),'Buttons')]")
  public WebElement buttonsButton;
  @FindBy(id = "rightClickBtn")
  WebElement rightClickBtn;
  @FindBy(id = "doubleClickBtn")
  WebElement doubleClickBtn;
  @FindBy(id = "doubleClickMessage")
  WebElement doubleClickMessage;
  @FindBy(id = "rightClickMessage")
  WebElement rightClickMessage;
  @FindBy(xpath = "//button[text()='Click Me']")
  public static WebElement clickMeButton;
  @FindBy(id = "dynamicClickMessage")
  WebElement clickMeMessage;

  public ButtonsPage getElementButton() {
    click(elements);
    return new ButtonsPage();
  }

  public ButtonsPage getButtonsButton() {
    click(buttonsButton);
    return new ButtonsPage();
  }

  public ButtonsPage rightClick() {
    new Actions(driver).contextClick(rightClickBtn).perform();
    return new ButtonsPage();
  }

  public ButtonsPage doubleClick() {
    new Actions(driver).doubleClick(doubleClickBtn).perform();
    return new ButtonsPage();
  }

  public void assertDoubleClick(String text) {
    Assertions.assertEquals(text, doubleClickMessage.getText());
  }

  public void assertRightClick(String text) {
    Assertions.assertEquals(text, rightClickMessage.getText());
  }
  public void assertClickMe(String text) {
    Assertions.assertEquals(text, clickMeMessage.getText());
  }
}
