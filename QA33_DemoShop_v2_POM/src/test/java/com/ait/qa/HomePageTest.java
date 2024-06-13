//package com.ait.qa;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class HomePageTest extends BaseTest {
//
//    @BeforeMethod
//    void precondition() {
//        app.getHomePageHelper().clickOnHomeLink();
//    }
//
//        @Test(description = "Проверка домашней страницы", groups = {"Positive"})
//    void checkHomePage() {
//        Assert.assertTrue(app.getHomePageHelper().checkHomeComponentIsPresent());
//    }
//}
