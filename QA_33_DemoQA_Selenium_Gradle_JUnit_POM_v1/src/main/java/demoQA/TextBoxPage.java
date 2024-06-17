package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

  @FindBy(id = "userName")
  WebElement fullNameFillIn; // Локатор элемента "Full Name"
  @FindBy(id = "name")
  public static WebElement fullNameSubmit; // Локатор проверки элемента "Full Name"
  @FindBy(id = "userEmail")
  WebElement eMailFillIn;
  @FindBy(id = "email")
  public static WebElement emailSubmit;
  @FindBy(xpath = "(//*[@id='currentAddress'])[1]")
  WebElement currentAddressFillIn;
  @FindBy(xpath = "(//*[@id='currentAddress'])[2]")
  public static WebElement currentAddressSubmit;
  @FindBy(xpath = "(//*[@id='permanentAddress'])[1]")
  WebElement permanentAddressFillIn;
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

  // Метод, который нажимает на кнопку "Submit"
  public void clickOnSubmitFilledFormButton() {
    clickJS(submitButton, 0, 200);
    System.out.println("Button is pressed");
  }

  // Метод, который извлекает и возвращает данные из элемента в ответе
  public static String extractData(WebElement element) {
    return element.getText().split(":")[1].trim(); // Возвращает текст элемента справа от знака двоеточия ":" и удаляет пробелы
  }
}

