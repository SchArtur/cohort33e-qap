package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static core.AppManager.elementsPage;
import static core.AppManager.textBoxPage;
import static demoQA.TextBoxPage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тестовый класс для проверки \"Elements\" --> \"Text Box\"")
public class TextBoxTests extends BaseTest {

  protected static final String FULL_NAME = "test test";
  protected static final String EMAIL = "test@test.com";
  protected static final String CURRENT_ADDRESS = "test";
  protected static final String PERMANENT_ADDRESS = "test";

  @BeforeEach
  public void precondition() {
    elementsPage.clickOnElementButton().clickOnTextButton().hideAds();
  }

  @DisplayName("Elements --> \"Text Box\" --> Заполнение всех полей формы")
  @Test
  public void testAllFilledForm() {
    textBoxPage.filledForm(FULL_NAME, EMAIL, CURRENT_ADDRESS, PERMANENT_ADDRESS).clickOnSubmitFilledFormButton();
    assertEquals(FULL_NAME, extractData(fullNameSubmit));
    assertEquals(EMAIL, extractData(emailSubmit));
    assertEquals(CURRENT_ADDRESS, extractData(currentAddressSubmit));
    assertEquals(PERMANENT_ADDRESS, extractData(permanentAddressSubmit));
  }

  @DisplayName("Elements --> \"Text Box\" --> Заполнение поля {Full Name}")
  @Test
  public void testNameFilledForm() {
    textBoxPage.filledForm(fullNameFillIn, FULL_NAME).clickOnSubmitFilledFormButton();
    assertEquals(FULL_NAME, extractData(fullNameSubmit));
  }

  @DisplayName("Elements --> \"Text Box\" --> Заполнение поля {Email}")
  @Test
  public void testEmailFilledForm() {
    textBoxPage.filledForm(eMailFillIn, EMAIL).clickOnSubmitFilledFormButton();
    assertEquals(EMAIL, extractData(emailSubmit));
  }

  @DisplayName("Elements --> \"Text Box\" --> Заполнение поля {Current Address}")
  @Test
  public void testCurrentAddressFilledForm() {
    textBoxPage.filledForm(currentAddressFillIn, CURRENT_ADDRESS).clickOnSubmitFilledFormButton();
    assertEquals(CURRENT_ADDRESS, extractData(currentAddressSubmit));
  }

  @DisplayName("Elements --> \"Text Box\" --> Заполнение поля {Permanent Address}")
  @Test
  public void testPermanentAddressFilledForm() {
    textBoxPage.filledForm(permanentAddressFillIn, PERMANENT_ADDRESS).clickOnSubmitFilledFormButton();
    assertEquals(PERMANENT_ADDRESS, extractData(permanentAddressSubmit));
  }

  @DisplayName("Elements --> \"Text Box\" --> Заполнение поля {Current Address} клавиатурным событием")
  @Test
  public void keyBoardEventTest() {
    textBoxPage.enterPersonalData(FULL_NAME, EMAIL).keyBoardEventTest(CURRENT_ADDRESS).clickOnSubmitFilledFormButton().assertCopyPastAddress();
  }
}
