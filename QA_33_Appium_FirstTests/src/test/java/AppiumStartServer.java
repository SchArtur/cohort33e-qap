import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumStartServer {
    //Сам аппиум сервер
    private static AppiumDriverLocalService service;

    public static void startServer() {
        //Создаем билдер с настройками нашего appium сервера
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        // Устанавливаем путь до appium (cmd: where appium)
        builder.withAppiumJS(new File("C:\\Users\\Andrii\\AppData\\Roaming\\npm\\appium.cmd"));
        // Указываем адрес и порт
        builder.withIPAddress("127.0.0.1").usingPort(4723);

        service = AppiumDriverLocalService.buildService(builder);
        // Запускаем сервер
        service.start();
        //выводим в консоль инфо, что сервер запущен
        if (service.isRunning()) {
            System.out.println("Server started - ok");
        } else {
            System.out.println("Server started - failed");
        }
    }

    public static void stopServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Server stopped");
        }
    }
}
