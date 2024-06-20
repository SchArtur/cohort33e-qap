package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationPanel extends BasePage{

    @FindBy(xpath = "//*[text()='LOGIN']")
    public List<WebElement> loginLink;

    @FindBy(css = "[href='/home']")
    public List<WebElement> homeLink;

    @FindBy(css = "[href='/add']")
    public List<WebElement> addLink;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public List<WebElement> signOut;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOutButton;

    @Step("Проверяем наличие кнопки 'Sign Out'")
    public boolean isSignOutButtonPresent() {
        return isElementPresent(signOut);
    }

    public void clickOnLink(List<WebElement> link) {
        clickOnElement(link.get(0));
    }

    public boolean linkIsPresent(List<WebElement> link) {
        return isElementPresent(link);
    }

    @Step("Проверяем наличие кнопки 'LOGIN'")
    public boolean isLoginLinkPresent() {
        return isElementPresent(loginLink);
    }

    @Step("Нажимаем на кнопку 'LOGIN' в заголовке")
    public LoginPage clickOnLoginLink() {
        clickOnElement(loginLink.get(0));
        return new LoginPage();
    }

}
