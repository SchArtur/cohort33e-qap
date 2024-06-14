package demoQA;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

    @FindBy(xpath = "//span[text()='Elements'])")
    public WebElement elementsDemoQAButton;

    @FindBy(xpath = "//span[text()='Text Box'])")
    public WebElement textBoxButton;

    public void clickOnElementButton() {
        click(elementsDemoQAButton);
    }

    public void clickOnTextButton() {
        click(textBoxButton);
    }


}

