package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    @FindBy(xpath = "//span[text()='Alerts']")
    WebElement alertsButton;

    public AlertsPage selectAlert() {
        click(alertsButton);
        return new AlertsPage();
    }
}