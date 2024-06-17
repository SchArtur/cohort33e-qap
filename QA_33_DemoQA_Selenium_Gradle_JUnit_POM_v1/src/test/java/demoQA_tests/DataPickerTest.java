package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;


import static core.AppManager.dataPickerPage;
import static core.AppManager.homePage;

public class DataPickerTest extends BaseTest {

    @Test
    void testDateSelection() {
        // Click on Widgets button on the HomePage
        homePage.getWidgets();

        for (int i = 0; i < 5; i++) {
            // Generate random data
            String[] randomDateAndTime = dataPickerPage.generateRandomDateTime();
            String randomDay = randomDateAndTime[0];
            String randomMonth = randomDateAndTime[1];
            String randomYear = randomDateAndTime[2];
            String randomTime = randomDateAndTime[3];

            // Open the Date Picker
            dataPickerPage.openDatePicker();

            // Select date and
            dataPickerPage.openDateMonthYearInput();
            dataPickerPage.monthSelectFromList(randomMonth);
            dataPickerPage.yearSelectFromList(randomYear);
            dataPickerPage.daySelectFromList((randomDay));
            //TODO Добавить проверку даты
//            dataPickerPage.checkDateInDateMonthYearInput(date);


            // Open the Date Picker
//            dataPickerPage.openDatePicker();
//            // Select time
//            June 17, 2024 11:15 PM

            String date = String.format("%s %s, %s %s PM", randomMonth, randomDay, randomYear, randomTime);
            dataPickerPage.fillDateAndTimeInput(date);
            dataPickerPage.checkDateInDateAndTimeInput(date);

//            dataPickerPage.openDateAndTimeInput();
//            dataPickerPage.daySelectFromList(randomDay);
//            dataPickerPage.monthSelectFromList(randomMonth);
//            dataPickerPage.yearSelectFromList(randomYear);
//            dataPickerPage.timeSelectFromList(randomTime);

        }
    }
}
