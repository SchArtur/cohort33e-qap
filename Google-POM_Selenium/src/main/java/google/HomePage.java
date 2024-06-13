package google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[text()='Alle akzeptieren']")
    WebElement clickTermButton;

    public void clickTermButton() {
            clickTermButton.click();
    }
}
