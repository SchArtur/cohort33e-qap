
package google;

        import core.AppManager;
        import io.qameta.allure.Attachment;
        import io.qameta.allure.Step;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.junit.jupiter.api.extension.ExtensionContext;
        import org.junit.jupiter.api.extension.TestWatcher;
        import org.openqa.selenium.OutputType;
        import org.openqa.selenium.TakesScreenshot;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.io.FileHandler;
        import org.openqa.selenium.support.PageFactory;
        import org.slf4j.LoggerFactory;

        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.logging.Logger;


public class BasePage {
    protected static WebDriver driver;

    public BasePage() {
        driver = AppManager.driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Открываем ссылку: {url}")
    public void open(String url) {
        driver.get(url);
    }

    @Step("Получаем скриншот ошибки и прикрепляем к отчету Allure")
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        if (driver instanceof TakesScreenshot ts) {
            File scrFile = ts.getScreenshotAs(OutputType.FILE);
            Path destination = Paths.get("./screenshots", scrFile.getName());
            try {
                Files.createDirectories(destination.getParent());
                FileHandler.copy(scrFile, destination.toFile());
                return Files.readAllBytes(destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return new byte[0];
    }
}
