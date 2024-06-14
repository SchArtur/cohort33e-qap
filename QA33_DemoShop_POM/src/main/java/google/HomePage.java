package google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[text()='Принять все']")
    WebElement accessTermButton;

    public void clickTermsButton() {
        accessTermButton.click();
    }
}
