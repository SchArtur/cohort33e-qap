package page_helpers;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHelper extends BaseHelper {
    public LoginHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//*[text()='Log in']"));
    }
    // return isElementPresent(By.xpath("//a[@class='ico-login']"));

    public void clickOnLoginLink() {
        clickOnElement(By.xpath("//*[text()='Log in']"));
    }

    public void fillLoginForm(User user) {
        fillInputField(By.id("Email"), user.getEmail());
        fillInputField(By.id("Password"), user.getPassword() );
    }

    public void clickOnLoginButton() {
        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));

        // или по clickOnElement(By.cssSelector("[value='Log in']"));
    }
    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.xpath("//*[text()='Log out']"));
    }
    public void clickOnLogOutButton() {
       clickOnElement(By.xpath("//*[text()='Log out']"));
    }
    // clickOnElement(By.xpath("//a[@class='ico-logout']"));
}

