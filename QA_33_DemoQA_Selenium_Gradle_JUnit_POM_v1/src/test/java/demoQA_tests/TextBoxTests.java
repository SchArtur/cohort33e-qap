package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static core.AppManager.elementsPage;
import static core.AppManager.textBoxPage;
import static demoQA.TextBoxPage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxTests extends BaseTest {

  protected static String fullName = "test test";
  protected static String email = "test@test.com";
  protected static String currentAddress = "test";
  protected static String permanentAddress = "test";

  @Test
  public void testFilledForm() {
    elementsPage.clickOnElementButton().clickOnTextButton();
    textBoxPage.filledForm(fullName, email, currentAddress, permanentAddress).clickOnSubmitFilledFormButton();
    assertEquals(fullName, extractData(fullNameSubmit));
    assertEquals(email, extractData(emailSubmit));
    assertEquals(currentAddress, extractData(currentAddressSubmit));
    assertEquals(permanentAddress, extractData(permanentAddressSubmit));
  }
}
