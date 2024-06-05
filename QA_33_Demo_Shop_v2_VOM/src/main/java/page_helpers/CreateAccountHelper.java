package page_helpers;

import model.NewAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountHelper extends BaseHelper {

    public CreateAccountHelper(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }

    public void clickOnRegisterLink() {

        clickOnElement(By.xpath("//*[text()='Register']"));
    }

    public void clickOnGenderCheckbox() {
        clickOnElement(By.xpath("//*[@id='gender-male']\""));
    }

    public boolean isRegistrationCompleted() {

        return isElementPresent(By.xpath("//div[@class='result']']"));
    }

    public void fillRegisterForm(NewAccount newAccount) {
        fillInputField(By.id("FirstName"), newAccount.getFirstName());
        fillInputField(By.id("LastName"), newAccount.getLastName());
        fillInputField(By.id("Email"), newAccount.getEmail());
        fillInputField(By.id("Password"), newAccount.getPassword());
        fillInputField(By.id("ConfirmPassword"), newAccount.getConfirmPassword());
    }

    public void clickOnRegistrationButton() {
        clickOnElement(By.xpath("//*[@id='register-button']"));
    }


    public boolean isConfirmationPresent() {
        return isElementPresent(By.xpath("//div[@class='result']"));

    }

}
