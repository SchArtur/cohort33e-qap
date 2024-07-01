package steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AddContactPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

import static core.AppManager.TEST_USER;
import static core.AppManager.navigationPanel;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationPanelSteps {

    @Тогда("проверяем наличие кнопки '{webElement}'")
    public void isLoginLinkPresent(List<WebElement> webElement) {
        assertTrue(navigationPanel.linkIsPresent(webElement));
    }

    @Когда("нажимаем на кнопку '{webElement}' в заголовке")
    public void clickOnLoginLink(List<WebElement> webElement) {
        navigationPanel.clickOnLink(webElement);
    }

    //Создание параметра в лице Юзера
    @ParameterType("LOGIN|ADD|HOME|SIGN_OUT")
    public List<WebElement> webElement(String elementName) {
        switch (elementName) {
            case "LOGIN":
                return navigationPanel.loginLink;
            case "ADD":
                return navigationPanel.addLink;
            case "HOME":
                return navigationPanel.homeLink;
            case "SIGN_OUT":
                return navigationPanel.signOut;
            default:
                return null;
        }
    }
}
