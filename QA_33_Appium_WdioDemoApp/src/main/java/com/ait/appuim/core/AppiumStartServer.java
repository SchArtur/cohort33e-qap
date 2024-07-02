package com.ait.appuim.core;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class AppiumStartServer {
    //Сам аппиум сервер
    private static AppiumDriverLocalService service;
    private static final Logger LOG = LoggerFactory.getLogger(AppiumStartServer.class);

    public static void startServer() throws IOException {
        //Создаем билдер с настройками нашего appium сервера
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        // Устанавливаем путь до appium (cmd: where appium)
        builder.withAppiumJS(new File("/opt/homebrew/bin/appium"));
        // Указываем адрес и порт
        builder.withIPAddress("127.0.0.1").usingPort(4723);

        service = AppiumDriverLocalService.buildService(builder);
        // Запускаем сервер
        try {
            service.start();
        } catch (AppiumServerHasNotBeenStartedLocallyException e) {
            LOG.info("Server started - failed");
            LOG.info("Попытка перезапуска");
            // для закрытия на windows- taskkill /F /IM node.exe
            Runtime.getRuntime().exec("pkill -9 -f appium");
            service.start();
        }

        //выводим в консоль инфо, что сервер запущен
        if (service.isRunning()) {
            LOG.info("Server started - ok");
        } else {
            LOG.info("Server started - failed");
        }
    }

    public static void stopServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            LOG.info("Server stopped");
        }
    }
}
