package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.devtools.v125.debugger.Debugger.pause;

public class TextBoxPage extends BasePage {

    @FindBy(id = "userName")
    WebElement fullNameFillIn;

    @FindBy(id = "userEmail")
    WebElement eMailFillIn;

    @FindBy(id="currentAddress")
    WebElement currentAddressFillIn;

    @FindBy(id="permanentAddress")
    WebElement permanentAddressFillIn;

    @FindBy(id = "submit")
    WebElement submitButton;


    @FindBy(id = "name")
    WebElement nameSubmit;

    @FindBy(id = "email")
    WebElement emailSubmit;

    public WebElement getNameSubmit() {
        return nameSubmit;
    }

    public void setNameSubmit(WebElement nameSubmit) {
        this.nameSubmit = nameSubmit;
    }

    public WebElement getEmailSubmit() {
        return emailSubmit;
    }

    public void setEmailSubmit(WebElement emailSubmit) {
        this.emailSubmit = emailSubmit;
    }

    public WebElement getCurrentAddressSubmit() {
        return currentAddressSubmit;
    }

    public void setCurrentAddressSubmit(WebElement currentAddressSubmit) {
        this.currentAddressSubmit = currentAddressSubmit;
    }

    public WebElement getPermanentAddressSubmit() {
        return permanentAddressSubmit;
    }

    public void setPermanentAddressSubmit(WebElement permanentAddressSubmit) {
        this.permanentAddressSubmit = permanentAddressSubmit;
    }

    @FindBy(xpath = "*(//*[@id='currentAddress'])[2])")
    WebElement currentAddressSubmit;


    @FindBy(xpath = "(//*[@id='permanentAddress'])[2])")
    WebElement permanentAddressSubmit;

    public TextBoxPage() {
        this.fullNameFillIn = fullNameFillIn;
        this.eMailFillIn = eMailFillIn;
        this.currentAddressFillIn = currentAddressFillIn;
        this.permanentAddressFillIn = permanentAddressFillIn;
    }




    public void  filledForm(String fullName, String email, String currentAddress, String permanentAddress) {
        type(fullNameFillIn, fullName);
        type(eMailFillIn,email);
        pause();
        type(currentAddressFillIn,currentAddress);
        pause();
        type(permanentAddressFillIn, permanentAddress);
    }

    public void submitFilledForm() {
        click(submitButton);
        System.out.println("Button is pressed");
    }



}

