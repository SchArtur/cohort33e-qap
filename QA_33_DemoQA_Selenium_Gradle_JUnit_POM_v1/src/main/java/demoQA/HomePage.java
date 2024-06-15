package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
  public static final String HOME_PAGE_URL = "https://demoqa.com/";

  @FindBy(css = ".top-card:nth-child(3)")
  WebElement alertsFrameWindow;
  @FindBy(css = ".top-card:nth-child(4)")
  WebElement widgets;
  @FindBy(css = ".card:nth-child(2)") //находим элемент формы
  WebElement forms;


  public SidePanel getAlertsFrameWindow() {
    click(alertsFrameWindow);
    return new SidePanel();
  }

  public SidePanel getWidgets() {
    click(widgets);
    return new SidePanel();
  }

  public SidePanel getForms() {
    click(forms);
    return new SidePanel();
  }


}
