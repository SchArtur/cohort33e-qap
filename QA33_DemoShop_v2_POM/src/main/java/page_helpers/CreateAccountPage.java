//package page_helpers;
//
//import model.NewAccount;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class CreateAccountPage extends BasePage {
//
//    @FindBy(xpath ="//*[text()='Register']")
//    WebElement RegisterLink;
//
//    @FindBy(xpath ="//*[text()='Register']")
//    WebElement RegisterLink;
//
//    @FindBy(xpath ="//*[text()='Register']")
//    WebElement RegisterLink;
//
//    @FindBy(xpath ="//*[text()='Register']")
//    WebElement RegisterLink;
//
//
//
//    public void clickOnRegisterLink(){
//        clickOnElement(By.xpath("//*[text()='Register']"));
//    }
//
////    public void clickOnGenderCheckbox(){
////        clickOnElement(By.xpath("//*[@id='gender-male']"));
////    }
//
//    public void clickOnGenderCheckbox(String gender) {
//        if (gender.equalsIgnoreCase("male")) {
//            clickOnElement(By.xpath("//*[@id='gender-male']"));
//        } else if (gender.equalsIgnoreCase("female")) {
//            clickOnElement(By.xpath("//*[@id='gender-female']"));
//        } else {
//            throw new IllegalArgumentException("Invalid gender: " + gender);
//        }
//    }
//
//    public boolean isRegistrationCompleted(){
//        return isElementPresent(By.xpath("//div[@class='result']"));
//    }
//
//    public void fillRegisterForm(NewAccount newAccount) {
//        fillInputField(By.id("FirstName"), newAccount.getFirstName());
//        fillInputField(By.id("LastName"), newAccount.getLastName());
//        fillInputField(By.id("Email"), newAccount.geteMail());
//        fillInputField(By.id("Password"), newAccount.getPassword());
//        fillInputField(By.id("ConfirmPassword"), newAccount.getConfirmPassword());
//    }
//
//    public void clickOnRegisterButton(){
//        clickOnElement(By.xpath("//*[@id='register-button']"));
//    }
//
//    public boolean isConfirmationPresent() {
//        return isElementPresent(By.xpath("//div[@class='result']"));
//    }
//
//}
