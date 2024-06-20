package demoQA_tests;

import core.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;


import static core.AppManager.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // ! Аннотация для запуска тестов в порядке возрастания
@DisplayName("Тестовый класс для проверки \"Alerts, Frame & Windows\" --> \"Alerts\"") // ! Аннотация для отображения названия тестового класса в отчете
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
    homePage.getAlertsFrameWindow().hideAds();
    sidePanel.selectAlert();
  }

  @Story("Button 1 with alert")
  @DisplayName("Alerts, Frame & Windows --> \"Alerts\" --> Button 1 {Click Button to see alert}")
  @Order(1)
  @RepeatedTest(value = 3, name = "{displayName} :: итерация [{currentRepetition}] из [{totalRepetitions}] ::")
  public void alertFirstButton() {
    alertsPage.clickAlertButtonFirst();
    assertTrue(alertsPage.isAlertPresent(), ERROR_MASSAGE);
  }

  @Story("Button 2 with timer")
  @DisplayName("Alerts, Frame & Windows --> \"Alerts\" --> Button 2 {On button click, alert will appear after 5 seconds}")
  @Order(2)
  @Test
  public void alertWithTimer() {
    alertsPage.alertWithTimer();
    assertTrue(alertsPage.isAlertPresent(), ERROR_MASSAGE);
  }

  @Story("Button 3 with choose Cancel")
  @DisplayName("Alerts, Frame & Windows --> \"Alerts\" --> Button 3 {On button click, confirm box will appear} with [Cancel] button")
  @Order(3)
  @Test
  public void alertWithSelectCancel() {
    alertsPage.selectResult(CANCEL).verifyResult(CANCEL);
  }

  @Story("Button 3 with choose Ok")
  @DisplayName("Alerts, Frame & Windows --> \"Alerts\" --> Button 3 {On button click, confirm box will appear} with [OK] button")
  @Order(4)
  @Test
  public void alertWithSelectOk() {
    alertsPage.selectResult(OK_CHOSEN).verifyResult(OK_RESULT); // ! Две константы потому что "ОК" и "Ок" - разные значения
  }

  @Story("Button 4 send massage 'Hello, World!'")
  @DisplayName("Alerts, Frame & Windows --> \"Alerts\" --> Button 4 {On button click, prompt box will appear} with [Hello, World!] text")
  @Order(5)
  @Test
  public void alertMessageToAlertTest() {
    alertsPage.sendMassageToAlert(HELLO_TEXT).verifyMessage(HELLO_TEXT);
  }
}
