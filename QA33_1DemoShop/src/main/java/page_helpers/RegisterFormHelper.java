package page_helpers;

import model.RegisterForm;
import model.User;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterFormHelper extends BaseHelper {
    public RegisterFormHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
        public boolean islogInLinkPresent() {
            HomePageHelper homePageHelper = new HomePageHelper(driver, wait);
            if (homePageHelper.checkForLogOutComponentIsPresent()) {
                homePageHelper.clickOnLogOutInLink();
            }
            return isElementPresent(By.xpath("//a[@class='ico-login']"));
        }

        public boolean isRegisterLinkPresent(){
        return isElementPresent(By.xpath("//a[@class='ico-register']"));
        }

    public void clickOnRegisterLink() {
          //clickOnElement(By.xpath("//*[text()='Register']"));
    clickOnElement(By.xpath("//a[class='ico-register']"));
    }
    public void fillRegisterForm(@NotNull RegisterForm registerForm) {

        if ("male".equals(registerForm.getGender())) {
            getElementBy(By.id("gender-male")).click();
        } else {
            getElementBy(By.id("gender-female")).click();
        }

        fillInputField(By.id("FirstName"), registerForm.getFirstName());
        fillInputField(By.id("LastName"), registerForm.getLastName());
        fillInputField(By.id("Email"),  registerForm.getEmail());
        fillInputField(By.id("Password"), registerForm.getPassword() );
        fillInputField(By.id("ConfirmPassword"), registerForm.getConfirmPassword());
    }

    public void clickOnRegisterButton() {
        clickOnElement(By.xpath("//input[@id='register-button']"));
        //clickOnElement(By.id("register-button"));
        // или по clickOnElement(By.cssSelector("[class='button-1 register-next-step-button']"));
    }
    public boolean isRegisterConfirmationPresent() {
        return isElementPresent(By.xpath("//*[text()='Your registration completed']"));
         // (By.xpath("//div[@class=class='result']));
    }
}
