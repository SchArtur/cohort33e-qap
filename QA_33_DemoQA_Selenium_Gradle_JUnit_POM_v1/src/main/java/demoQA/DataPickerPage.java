package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class DataPickerPage extends BasePage {
    @FindBy(xpath = "//span[text()='Date Picker']")
    public WebElement datePicker;

    @FindBy(id = "datePickerMonthYearInput")
    public WebElement dateMonthYearInput;

    @FindBy(id = "dateAndTimePickerInput")
    public WebElement dateAndTimeInput;


    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthSelect;

    @FindBy(xpath = "//select[contains(@class, 'react-datepicker__year-select')]")
    public WebElement yearSelect;

    @FindBy(xpath = "//div[contains(@class, 'react-datepicker__day')]")
    public WebElement daySelect;

    @FindBy(className = "react-datepicker__time-list-item")
    public  WebElement timeSelect;
    public Scanner random;


    public void openDatePicker() {
        datePicker.click();
    }

    public void openDateMonthYearInput() {
        dateMonthYearInput.click();
        }

    public void openDateAndTimeInput() {
        dateAndTimeInput.click();
    }

    public void monthSelectFromList(String month) {
        Select select = new Select(monthSelect);
        select.selectByVisibleText(month);
        List<WebElement> options = select.getOptions();
        System.out.println("[" + options.get(0).getText() + "] month");
        for (WebElement listItem : options) {
            System.out.println("There is chosen [" + listItem.getText() + "] with index [" + listItem.getAttribute("value") + "]");
        }
    }

    public void yearSelectFromList(String year) {
        Select select = new Select(yearSelect);
        select.selectByVisibleText(year);
        List<WebElement> options = select.getOptions();
        out.println("[" + options.get(0).getText() + "] year");
        for (WebElement listItem : options) {
            out.println("There is chosen [" + listItem.getText() + "] with index [" + listItem.getAttribute("value") + "]");
        }
    }
    public void daySelectFromList(int day) {
        Select select = new Select(daySelect);
        select.selectByVisibleText(String.valueOf(day));
        List<WebElement> options = select.getOptions();
        out.println("[" + options.get(0).getText() + "] day");
        for (WebElement listItem : options) {
            out.println("There is chosen [" + listItem.getText() + "] with index [" + listItem.getAttribute("value") + "]");
        }
    }
    public void timeSelectFromList(String time) {
        Select select = new Select(daySelect);
        select.selectByVisibleText(String.valueOf(time));
        List<WebElement> options = select.getOptions();
        out.println("[" + options.get(0).getText() + "] time");
        for (WebElement listItem : options) {
            out.println("There is chosen [" + listItem.getText() + "] with index [" + listItem.getAttribute("value") + "]");
        }
    }
    public String formatTime(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        String minutes = parts[1];
        String period = hours < 12 ? "AM" : "PM";
        if (hours == 0) {
            hours = 12;
        } else if (hours > 12) {
            hours -= 12;
        }
        return String.format("%d:%s %s", hours, minutes, period);
    }

    public String[] generateRandomDateTime() {
        Random random = new Random();
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] times = {"00:00", "00:15", "00:30", "00:45", "01:00", "01:15", "01:30", "01:45", "02:15", "02:30", "02:45", "03:00", "03:15", "03:30", "03:45", "04:00", "04:15", "04:30", "04:45", "05:00", "05:15", "05:30", "05:45", "06:00", "06:15", "06:30", "06:45", "07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00"};
        String randomDay = String.valueOf(1 + random.nextInt(28));
        String randomMonth = months[random.nextInt(months.length)];
        String randomYear = String.valueOf(2020 + random.nextInt(10)); // Random year from 2020 to 2029

        String randomTime = times[random.nextInt(times.length)];
        return new String[]{randomDay,randomMonth, randomYear,  randomTime};
    }



}

   /* public int monthsNumberSelect (String month_select){
    ){
        switch (month_select){
            case "January":
                return 0;
            case "February":
                return 1;
            case "March":
                return 2;
            case "April":
                return 3;
            case "May":
                return 4;
            case "June":
                return 5;
            case "July":
                return 6;
            case "August":
                return 7;
            case "September":
                return 8;
            case "October":
                return 9;
            case "November":
                return 10;
            case "December":
                return 11;
            default:
                throw new IllegalArgumentException("Invalid month name" + month_select);

        }
    }



}
