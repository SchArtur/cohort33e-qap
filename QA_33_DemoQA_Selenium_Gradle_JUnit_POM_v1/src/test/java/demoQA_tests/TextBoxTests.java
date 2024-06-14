package demoQA_tests;

import core.BaseTest;
import demoQA.ElementsPage;
import demoQA.TextBoxPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxTests extends BaseTest {
    @Test
    public void testFilledForm() {


        ElementsPage elementsPage= new ElementsPage();
        TextBoxPage textBoxPage = new TextBoxPage();

        elementsPage.clickOnElementButton();
        elementsPage.clickOnTextButton();

        String  fullName = "test test";
        String email = "test@test.com";
        String currentAddress = "test";
        String permanentAddress = "test";

       textBoxPage.filledForm(fullName, email, currentAddress, permanentAddress);

      // expectedFormDetails = textBoxPage.filledForm(fullName, email, currentAddress, permanentAddress);

        assertEquals(fullName, textBoxPage.getNameSubmit());
        assertEquals(email, textBoxPage.getEmailSubmit());
        assertEquals(currentAddress, textBoxPage.getCurrentAddressSubmit());
        assertEquals(permanentAddress, textBoxPage.getPermanentAddressSubmit());

       // System.out.println(expectedFormDetails);
    }
    }
