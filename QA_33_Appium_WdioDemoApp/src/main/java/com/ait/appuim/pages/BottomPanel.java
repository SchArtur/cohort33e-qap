package com.ait.appuim.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class BottomPanel extends BasePage {

    @AndroidFindBy(accessibility = "Login")
    WebElement login;

    @Step("Нажимаем на кнопку 'Login' на нижней панели")
    public LoginPage tapOnLoginInPanel() {
        tapOnElement(login);
        return new LoginPage();
    }
}
