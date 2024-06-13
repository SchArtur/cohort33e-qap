package demoQA_tests;

import core.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import static core.AppManager.alertsPage;
import static core.AppManager.homePage;
import static core.AppManager.sidePanel;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // ! Аннотация для запуска тестов в порядке возрастания
@DisplayName("Тестовый класс для проверки алертов") // ! Аннотация для отображения названия тестового класса в отчете
@Feature("Alert buttons") // ! Аннотация для отображения названия фичи в отчете, которая относится ко всему тестовому классу сразу
public class AlertsPageTests extends BaseTest {
  protected final String CANCEL = "Cancel";
  protected final String OK_CHOSEN = "OK";
  protected final String OK_RESULT = "Ok";
  protected final String ERROR_MASSAGE = "Алерт должен быть";
  protected final String HELLO_TEXT = "Hello, World!";

  @Story("Precondition for alert tests")
  @BeforeEach
  public void precondition() {
    homePage.getAlertsFrameWindow();
    sidePanel.selectAlert();
  }

  @Story("Button 1 with alert")
  @DisplayName("Button 1 with alert immediately")
  @Order(1)
  @RepeatedTest(value = 5, name = "{displayName} :: итерация [{currentRepetition}] из [{totalRepetitions}]")
  public void alertFirstButton() {
    alertsPage.clickAlertButtonFirst();
    assertTrue(alertsPage.isAlertPresent(), ERROR_MASSAGE);
  }

  @Story("Button 2 with timer")
  @DisplayName("Button 2 with alert in 5 seconds")
  @Order(2)
  @Test
  public void alertWithTimer() {
    alertsPage.alertWithTimer();
    assertTrue(alertsPage.isAlertPresent(), ERROR_MASSAGE);
  }

  @Story("Button 3 with choose Cancel")
  @DisplayName("Button 3 with choose Cancel")
  @Order(3)
  @Test
  public void alertWithSelectCancel() {
    alertsPage.selectResult(CANCEL).verifyResult(CANCEL);
  }

  @Story("Button 3 with choose Ok")
  @DisplayName("Button 3 with choose OK")
  @Order(4)
  @Test
  public void alertWithSelectOk() {
    alertsPage.selectResult(OK_CHOSEN).verifyResult(OK_RESULT); // ! Две константы потому что "ОК" и "Ок" - разные значения
  }

  @Story("Button 4 send massage 'Hello, World!'")
  @DisplayName("Button 4 send message 'Hello, World!' to alert")
  @Order(5)
  @Test
  public void alertMessageToAlertTest() {
    alertsPage.sendMassageToAlert(HELLO_TEXT).verifyMessage(HELLO_TEXT);
  }
}
