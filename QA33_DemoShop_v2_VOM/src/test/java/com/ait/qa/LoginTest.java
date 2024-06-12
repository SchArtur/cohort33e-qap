package com.ait.qa;

import core.DataProviders;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.TEST_USER;

public class LoginTest extends BaseTest{

    @BeforeMethod
    void precondition() {
        if (!app.getLoginHelper().isLoginLinkPresent()) {
            app.getLoginHelper().clickOnLogOutButton();
        }
    }

    @Test(description = "Проверка успешной авторизации", groups = {"Positive"})
    void loginPositiveTest(){
        app.getLoginHelper().clickOnLoginLink();
        app.getLoginHelper().fillLoginRegisterForm(TEST_USER);
        app.getLoginHelper().clickOnLoginButton();
        Assert.assertTrue(app.getLoginHelper().isLogOutButtonPresent());
    }

    @Test(dataProvider = "loginUsers", dataProviderClass = DataProviders.class)
    void loginPositiveTestDataProvider(User user) {
        app.getLoginHelper().clickOnLoginLink();
        app.getLoginHelper().fillLoginRegisterForm(user);
        app.getLoginHelper().clickOnLoginButton();
        Assert.assertTrue(app.getLoginHelper().isLogOutButtonPresent());
    }
}
