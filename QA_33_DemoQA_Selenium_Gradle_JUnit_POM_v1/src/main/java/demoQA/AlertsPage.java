package demoQA;

import core.BasePage;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AlertsPage extends BasePage {


  @FindBy(id = "timerAlertButton")
  WebElement timerAlertButton;

  @FindBy(id = "alertButton")
  WebElement alertButton;

  @FindBy(id = "confirmButton")
  WebElement confirmButton;

  @FindBy(id = "confirmResult")
  WebElement confirmResult;

  @FindBy(id = "promtButton")
  WebElement promtButton;

  @FindBy(id = "promptResult")
  WebElement promptResult;

  public void alertWithTimer() {
    click(timerAlertButton);
    new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.alertIsPresent());
  }

  public void clickAlertButtonFirst() {
    click(alertButton);
  }

  // Метод, который проверяет, есть ли алерт на странице
  public boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  // Метод, который выбирает кнопки в алерте
  public AlertsPage selectResult(String confirm) {
    click(confirmButton);
    if (confirm != null && confirm.equals("OK")) {
      driver.switchTo().alert().accept();
    } else if (confirm != null && confirm.equals("Cancel")) {
      driver.switchTo().alert().dismiss();
    }
    return this;
  }

  // Метод, который проверяет результат
  public void verifyResult(String text) {
    assertTrue(confirmResult.getText().contains(text));
  }

  // Метод, который отправляет сообщение в алерт
  public AlertsPage sendMassageToAlert(String message) {
    click(promtButton);
    if (message != null) {
      driver.switchTo().alert().sendKeys(message);
      driver.switchTo().alert().accept();
    }
    return this;
  }

  // Метод, который проверяет сообщение
  public void verifyMessage(String message) {

    assertTrue(promptResult.getText().contains(message));
  }
}
