package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    @FindBy(xpath = "//span[text()='Alerts']")
    WebElement alertsButton;
    @FindBy(xpath = "//span[text()='Broken Links - Images']")
    WebElement brokenLinksImages;
    @FindBy(xpath = "//span[text()='Droppable']")
    WebElement droppable;

    @FindBy(xpath = "//span[text()='Select Menu']")
    WebElement selectMenu;

    public AlertsPage selectAlert() {
        click(alertsButton);
        return new AlertsPage();
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    WebElement browserButton;

    public SidePanel selectBrowserWindows() {
        click(browserButton);
        return this;
    }

    public SelectMenuPage getSelectMenu() {
        clickJS(selectMenu, 0, 500);
        return new SelectMenuPage();
    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage();
    }

    public BrokenLinksImagesPage clickOnBrokenLinksImages() {
        click(brokenLinksImages);
        return new BrokenLinksImagesPage();
    }

    public DroppablePage clickOnDroppable() {
        click(droppable);
        return new DroppablePage();
    }
}
