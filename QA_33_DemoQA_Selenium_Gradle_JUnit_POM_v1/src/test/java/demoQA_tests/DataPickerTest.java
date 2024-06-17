package demoQA_tests;

import core.BaseTest;
import org.junit.Assert;

import org.testng.annotations.Test;

import static core.AppManager.dataPickerPage;
import static core.AppManager.homePage;

public class DataPickerTest extends BaseTest {

    @Test
    public void testDateSelection() {
        // Click on Widgets button on the HomePage
        homePage.getWidgets();

        for (int i = 0; i < 5; i++) {
            // Generate random data
            String[] randomDateAndTime = dataPickerPage.generateRandomDateTime();
            String randomDay = randomDateAndTime[2];
            String randomMonth = randomDateAndTime[3];
            String randomYear = randomDateAndTime[1];
            String randomTime = randomDateAndTime[3];

            // Open the Date Picker
            dataPickerPage.openDatePicker();

            // Select date and
            dataPickerPage.openDateMonthYearInput();
            dataPickerPage.daySelectFromList(Integer.parseInt(randomDay));
            dataPickerPage.monthSelectFromList(randomMonth);
            dataPickerPage.yearSelectFromList(randomYear);

            // Open the Date Picker
            dataPickerPage.openDatePicker();
            // Select time
            dataPickerPage.openDateAndTimeInput();
            dataPickerPage.daySelectFromList(Integer.parseInt(randomDay));
            dataPickerPage.monthSelectFromList(randomMonth);
            dataPickerPage.yearSelectFromList(randomYear);
            dataPickerPage.timeSelectFromList(randomTime);

        }
    }
}
