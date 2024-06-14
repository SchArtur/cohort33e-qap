package googlePages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public final String GOOGLE_URL = "https://www.google.com/";

    @FindBy(xpath = "//textarea[@role='none']")
    WebElement alertsFrameWindow;


}
