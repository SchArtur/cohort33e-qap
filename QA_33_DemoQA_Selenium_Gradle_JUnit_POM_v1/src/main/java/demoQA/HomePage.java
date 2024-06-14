package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public final String HOME_PAGE_URL = "https://demoqa.com/";

    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertsFrameWindow;

    public void getAlertsFrameWindow() {
        alertsFrameWindow.click();
        new SidePanel();
    }
}
