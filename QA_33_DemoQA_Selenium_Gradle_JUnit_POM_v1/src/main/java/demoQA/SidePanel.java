package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

  @FindBy(xpath = "//span[text()='Alerts']")
  WebElement alertsButton;

  @FindBy(xpath = "//span[text()='Select Menu']")
  WebElement selectMenu;
  public AlertsPage selectAlert() {
    click(alertsButton);
    return new AlertsPage();
  }


  @FindBy(xpath = "//span[text()='Browser Windows']")
  WebElement browserButton;
  public void selectBrowserWindows() {
    click(browserButton);
  }

  public SelectMenuPage getSelectMenu() {
    clickJS(selectMenu,0,500);
    return new SelectMenuPage();
  }
}
