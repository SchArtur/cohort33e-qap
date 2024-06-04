package page_helpers;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHelper extends BaseHelper{
    public LoginHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean isLogOutButtonPresent() {
        return isElementPresent(By.xpath("//*[text()='Log out']"));
    }

    public void clickOnLoginLink(){
        clickOnElement(By.xpath("//*[text()='Log in']"));
    }

    public void clickOnLoginButton(){
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//*[text()='Log in']"));
    }

    public void fillLoginRegisterForm(User user) {
        fillInputField(By.id("Email"), user.getEmail());
        fillInputField(By.id("Password"), user.getPassword());
    }

    public void clickOnLogOutButton(){
        clickOnElement(By.xpath("//*[text()='Log out']"));
    }
}
