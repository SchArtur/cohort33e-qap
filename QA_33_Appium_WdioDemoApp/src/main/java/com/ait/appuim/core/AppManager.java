package com.ait.appuim.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class AppManager {

    public static AppiumDriver driver;
    public static WebDriverWait wait;

    public static void startApp() throws IOException {
//        AppiumStartServer.startServer();

        UiAutomator2Options options = new UiAutomator2Options()
                //установка приложения на телефон
                // /Users/Artur/IdeaProjects/_AIT/33/cohort33e-qap/QA_33_Appium_WdioDemoApp/src/main/resources/wdio_app.apk
                // .setApp("Users/Artur/IdeaProjects/_AIT/33/cohort33e-qap/QA_33_Appium_WdioDemoApp/src/main/resources/wdio_app.apk")
                .setApp(new File("src/main/resources/wdio_app.apk").getAbsolutePath())
                //com.wdiodemoapp/com.wdiodemoapp.MainActivity
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity("com.wdiodemoapp.MainActivity")
                //Запуск эмулятора (cmd: emulator -list-avds  посмотреть имя эмулятора)
                //TODO указать версию android эмулятора
                .setPlatformVersion("8")
//                TODO указать имя эмулятора
                .setAvd("android_jenkins_26");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static void stopApp() throws IOException {
        driver.quit();
        //TODO указать id эмулятора
//        closeEmulator("emulator-5554");
//        AppiumStartServer.stopServer();
    }

    private static void closeEmulator(String id) throws IOException {
        //Закрываем эмулятор с id emulator-5554
        //Получить id у запущенного эмулятора cmd: adb devices
        String cmdLine = String.format("adb -s %s emu kill", id);
        Runtime.getRuntime().exec(cmdLine);
    }
}
