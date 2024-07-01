package steps;

import core.AppManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.И;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import pages.BasePage;

import java.util.List;

import static core.AppManager.*;

public class BaseSteps {

    protected static AppManager app = new AppManager(System.getProperty("browser", Browser.CHROME.browserName()));

    @BeforeAll
    public static void startTests() {
        app.init();
    }

    @AfterAll
    public static void stopTests() {
        app.stop();
    }

    @Before("@BeforeLogin")
    public static void precondition() {
        if (!navigationPanel.linkIsPresent(navigationPanel.loginLink)) {
            navigationPanel.clickOnLink(navigationPanel.signOut);
        }
    }

    @When("нет кнопки '{webElement}' то нажимаем '{webElement}'")
    public void loginPrecondition(List<WebElement> link1, List<WebElement> link2) {
        if (!navigationPanel.linkIsPresent(link1)) {
            navigationPanel.clickOnLink(link2);
        }
    }

    @When("ожидаем {int} секунд(ы)")
    public void waitInSeconds(int seconds) {
        navigationPanel.waitInSeconds(seconds);
    }

    @И("проверяем, что текст всплывающего уведомления содержит - \"(.+)\"$")
    public void checkAlertMsg(String msg) {
        Assertions.assertTrue(homePage.getAlertText().contains(msg), "Текст ошибки в всплывающем уведомлении не соответствует ожидаемому");
    }

    //Создание параметра в лице webElement оригинал метода лежит в NavigationPanelSteps
//    @ParameterType("LOGIN|ADD|HOME|SIGN_OUT")
//    public List<WebElement> webElement(String elementName) {
//        switch (elementName) {
//            case "LOGIN":
//                return navigationPanel.loginLink;
//            case "ADD":
//                return navigationPanel.addLink;
//            case "HOME":
//                return navigationPanel.homeLink;
//            case "SIGN_OUT":
//                return navigationPanel.signOut;
//            default:
//                return null;
//        }
//    }
}
