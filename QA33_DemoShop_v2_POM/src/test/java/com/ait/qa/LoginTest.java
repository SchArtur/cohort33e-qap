//package com.ait.qa;
//
//import core.DataProviders;
//import model.User;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import static core.AppManager.TEST_USER;
//import static core.AppManager.loginPage;
//
//public class LoginTest extends BaseTest{
//
//    @BeforeMethod
//    void precondition() {
//        if (!loginPage.isLoginLinkPresent()) {
//            loginPage.clickOnLogOutButton();
//        }
//    }
//
//    @Test(description = "Проверка успешной авторизации", groups = {"Positive"})
//    void loginPositiveTest(){
//        loginPage.clickOnLoginLink();
//        loginPage.fillLoginRegisterForm(TEST_USER);
//        loginPage.clickOnLoginButton();
//        Assert.assertTrue(loginPage.isLogOutButtonPresent());
//    }
//
//    @Test(dataProvider = "loginUsers", dataProviderClass = DataProviders.class)
//    void loginPositiveTestDataProvider(User user) {
//        loginPage.clickOnLoginLink();
//        loginPage.fillLoginRegisterForm(user);
//        loginPage.clickOnLoginButton();
//        Assert.assertTrue(loginPage.isLogOutButtonPresent());
//    }
//}
