package core;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class BasePage {
  protected static WebDriver driver;
  JavascriptExecutor js;

  public BasePage() {
    driver = AppManager.driver;
    js = (JavascriptExecutor) driver;
    PageFactory.initElements(driver, this);
  }

  @Step("Открываем ссылку: [{url}]")
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

  @Step("Кликаем по элементу: [{element}]")
  public void click(WebElement element) {
    element.click();
  }

  @Step("Кликаем по элементу с JS: [{element}]")
  protected void clickJS(WebElement element, int x, int y) {
    js.executeScript("window.scrollBy(" + x + "," + y + ")");
    click(element);
  }

  @Step("Вводим текст: [{text}] в элемент: [{element}]")
  public void type(WebElement element, String text) {
    if (text != null) {
      click(element);
      element.clear();
      element.sendKeys(text);
    }
  }

  // Метод, который будет искать текст в локаторе
  public boolean shouldHaveText(WebElement element, String text, int timeout) {
    System.out.println("ТЕКСТ ПРОВЕРЕН: [" + text + "] В ЭЛЕМЕНТЕ: [" + element.getTagName() + "]");
    return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.textToBePresentInElement(element, text));
  }
}
