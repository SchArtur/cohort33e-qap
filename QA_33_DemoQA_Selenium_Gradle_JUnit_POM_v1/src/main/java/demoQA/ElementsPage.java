package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

    @FindBy(css = ".top-card:nth-child(1)")
    public WebElement elementsDemoQAButton;

    @FindBy(xpath = "//span[text()='Text Box']")
    public WebElement textBoxButton;

    public ElementsPage clickOnElementButton() {
        click(elementsDemoQAButton);
        return new ElementsPage();
    }

    public void clickOnTextButton() {
        click(textBoxButton);
    }


}

