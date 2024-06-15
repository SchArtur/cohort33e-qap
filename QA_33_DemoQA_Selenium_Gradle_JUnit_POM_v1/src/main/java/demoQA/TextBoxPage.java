package demoQA;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxPage extends BasePage {

  @FindBy(id = "userName")
  public static WebElement fullNameFillIn; // Локатор элемента "Full Name"
  @FindBy(id = "name")
  public static WebElement fullNameSubmit; // Локатор проверки элемента "Full Name"
  @FindBy(id = "userEmail")
  public static WebElement eMailFillIn;
  @FindBy(id = "email")
  public static WebElement emailSubmit;
  @FindBy(xpath = "(//*[@id='currentAddress'])[1]")
  public static WebElement currentAddressFillIn;
  @FindBy(xpath = "(//*[@id='currentAddress'])[2]")
  public static WebElement currentAddressSubmit;
  @FindBy(xpath = "(//*[@id='permanentAddress'])[1]")
  public static WebElement permanentAddressFillIn;
  @FindBy(xpath = "(//*[@id='permanentAddress'])[2]")
  public static WebElement permanentAddressSubmit;
  @FindBy(id = "submit")
  WebElement submitButton;

  // Метод, который вводит данные в поля формы
  public TextBoxPage filledForm(String fullName, String email, String currentAddress, String permanentAddress) {
    type(fullNameFillIn, fullName);
    type(eMailFillIn, email);
    type(currentAddressFillIn, currentAddress);
    type(permanentAddressFillIn, permanentAddress);
    return new TextBoxPage();
  }

  public TextBoxPage filledForm(WebElement element, String text) {
    type(element, text);
    return new TextBoxPage();
  }

  // Метод, который нажимает на кнопку "Submit"
  public TextBoxPage clickOnSubmitFilledFormButton() {
    clickJS(submitButton, 0, 200);
    System.out.println("Button {Submit} is pressed");
    return new TextBoxPage();
  }

  // Метод, который извлекает и возвращает данные из элемента в ответе
  public static String extractData(WebElement element) {
    return element.getText().split(":")[1].trim(); // Возвращает текст элемента справа от знака двоеточия ":" и удаляет пробелы
  }

  @FindBy(id = "userName")
  WebElement userName;
  @FindBy(id = "userEmail")
  WebElement userEmail;

  public TextBoxPage enterPersonalData(String name, String email) {
    type(userName, name);
    type(userEmail, email);
    return this;
  }


  @FindBy(id = "currentAddress")
  WebElement currentAddress;

  // Метод, который вводит адрес в поле "Current Address" клавиатурным событием
  public TextBoxPage keyBoardEventTest(String address) {
    Actions actions = new Actions(driver);
    type(currentAddress, address);
    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); // perform потому что это класс Actions
    actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
    actions.keyDown(Keys.TAB).perform();
    actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    return this;
  }

  // <p> (параграф) с идентификатором permanentAddress. Это тег HTML-элемента. В данном случае это тег параграфа
  @FindBy(css = "p#currentAddress")
  WebElement currentAddressResult;
  @FindBy(css = "p#permanentAddress")
  WebElement permanentAddressResult;

  public void assertCopyPastAddress() {
    String[] current = currentAddressResult.getText().split(":");
    String[] permanent = permanentAddressResult.getText().split(":");
    assertEquals(permanent[1], current[1]);
  }
}

