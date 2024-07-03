package com.ait.appium.tests;

import com.ait.appuim.core.AppManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public class BaseTest {


    @BeforeAll
    public static void startTest() throws IOException {
        AppManager.startApp();
    }

    @AfterAll
    public static void stopTest() throws IOException {
        AppManager.stopApp();
    }
}
