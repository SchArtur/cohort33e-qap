package page_helpers;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageHelper extends BaseHelper {

    public LoginPageHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//*[text()='LOGIN']"));

    }

    public void clickOnLoginLink() {
        clickOnElement(By.xpath("//*[text()='LOGIN']"));
    }

    public void clickOnLoginButton() {
        clickOnElement(By.name("login"));
    }

    public void clickOnRegistrationButton() {
        clickOnElement(By.name("registration"));
    }

    public void clickOnSigOutButton() {
        clickOnElement(By.xpath("//*[text()='Sign Out']"));
    }

    public void fillLoginRegisterForm(User user) {
        fillInputField(By.name("email"), user.getEmail());
        fillInputField(By.name("password"), user.getPassword());
    }

//    By.xpath("//*[text()='Sign Out']")

//    new User("manuelgm.com", "Manuel1234$")
//    (By.xpath("//*[contains(text(), '401')]")
}




