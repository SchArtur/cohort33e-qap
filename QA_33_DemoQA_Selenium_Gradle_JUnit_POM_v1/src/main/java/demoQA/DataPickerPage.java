package demoQA;

import core.BasePage;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    public WebElement monthSelect;

    @FindBy(xpath = "//select[contains(@class, 'react-datepicker__year-select')]")
    public WebElement yearSelect;

    @FindBy(xpath = "//div[contains(@class, 'react-datepicker__day ')]")
    public WebElement daySelect;

    @FindBy(css = "[class='react-datepicker__time-list-item']")
    public WebElement timeSelect;

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

    public void fillDateAndTimeInput(String date) {
        dateAndTimeInput.click();
        dateAndTimeInput.sendKeys(Keys.COMMAND + "A");
        dateAndTimeInput.sendKeys(date);
        dateAndTimeInput.sendKeys(Keys.ENTER);
    }

    public void checkDateInDateAndTimeInput(String date) {
//        waitInSeconds(5);
//        WebElement element = driver.findElement(By.id("dateAndTimePickerInput"));
        Assertions.assertEquals(date, dateAndTimeInput.getAttribute("value"));
    }

    public void monthSelectFromList(String month) {
        Select select = new Select(monthSelect);
        select.selectByVisibleText(month);
//        List<WebElement> options = select.getOptions();
//        System.out.println("[" + options.get(0).getText() + "] month");
//        for (WebElement listItem : options) {
//            System.out.println("There is chosen [" + listItem.getText() + "] with index [" + listItem.getAttribute("value") + "]");
//        }
    }

    public void yearSelectFromList(String year) {
        Select select = new Select(yearSelect);
        select.selectByVisibleText(year);
//        List<WebElement> options = select.getOptions();
//        out.println("[" + options.get(0).getText() + "] year");
//        for (WebElement listItem : options) {
//            out.println("There is chosen [" + listItem.getText() + "] with index [" + listItem.getAttribute("value") + "]");
//        }
    }

    public void daySelectFromList(String day) {
        String xpath = String.format("//*[text() = '%s']", day);
     daySelect.findElement(By.xpath(xpath)).click();
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
        String[] times = {"00:00", "00:15", "00:30", "00:45", "1:00", "1:15", "1:30", "1:45", "2:15", "2:30", "2:45", "3:00", "3:15", "3:30", "3:45", "4:00", "4:15", "4:30", "4:45", "5:00", "5:15", "5:30", "5:45", "6:00", "6:15", "6:30", "6:45", "7:00", "7:15", "7:30", "7:45", "8:00", "8:15", "8:30", "8:45", "9:00", "9:15", "9:30", "9:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00"};
        String randomDay = String.valueOf(1 + random.nextInt(28));
        String randomMonth = months[random.nextInt(months.length)];
        String randomYear = String.valueOf(2020 + random.nextInt(10)); // Random year from 2020 to 2029

        String randomTime = times[random.nextInt(times.length)];
        return new String[]{randomDay, randomMonth, randomYear, randomTime};
    }

    public int monthsNumberSelect(String month_select) {
        switch (month_select) {
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