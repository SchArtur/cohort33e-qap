package page_helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(css = "[href='/']")
    WebElement homeLink;

    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement homeComponent;

    @Step("Переходим на главную страницу")
    public void clickOnHomeLink() {
        clickOnElement(homeLink);
    }

    @Step("Проверяем отображение 'Home Component'")
    public boolean checkHomeComponentIsPresent() {
        return homeComponent.isDisplayed();
    }
}
