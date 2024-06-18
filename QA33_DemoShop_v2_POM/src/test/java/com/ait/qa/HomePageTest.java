package com.ait.qa;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.homePage;

public class HomePageTest extends BaseTest {

    @BeforeMethod
    void precondition() {
        homePage.clickOnHomeLink();
    }

        @Test(description = "Проверка домашней страницы", groups = {"Positive"})
    void checkHomePage() {
        Assert.assertTrue(homePage.checkHomeComponentIsPresent());
    }
}
