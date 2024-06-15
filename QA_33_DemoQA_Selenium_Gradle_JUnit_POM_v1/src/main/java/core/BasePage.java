package core;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class BasePage {
  protected static WebDriver driver;
  JavascriptExecutor js;
  public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

  public BasePage() {
    driver = AppManager.driver;
    js = (JavascriptExecutor) driver;
    PageFactory.initElements(driver, this);
  }

  @Step("Открываем ссылку: [{url}]")
  public BasePage open(String url) {
    driver.get(url);
    return this;
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
    LOGGER.info("ТЕКСТ ПРОВЕРЕН: [" + text + "] В ЭЛЕМЕНТЕ: [" + element.getTagName() + "]");
    return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.textToBePresentInElement(element, text));
  }

  // Метод, который будет отключать рекламу и её блоки
  public void hideAds() {
    js.executeScript(
            "var hideAds = function() {" +
                    "document.getElementById('adplus-anchor').style.display='none';" +
                    "document.getElementById('fixedban').style.display='none';" +
                    "document.getElementById('Ad.Plus-300x250-1').style.display='none';" +
                    "document.getElementById('Ad.Plus-300x250-2').style.display='none';" +
                    "document.getElementById('Ad.Plus-970x250-1').style.display='none';" +
                    "document.getElementById('Ad.Plus-970x250-2').style.display='none';" +
                    "document.getElementById('RightSide_Advertisement').style.display='none';" +
                    "document.getElementById('mys-wrapper').style.display='none';" +
                    "document.getElementById('bnr').style.display='none';" +
                    "document.getElementById('banner').style.display='none';" +
                    "document.getElementById('bannerB').style.display='none';" +
                    "document.querySelectorAll('[class*=\"-bannerB\"], [class*=\"-banner\"], .ad-card').forEach(element => element.style.display = 'none');" +
                    "document.querySelectorAll('.ns-vwfjj-e-1.top-panel').forEach(element => element.style.display = 'none');" +
                    "document.querySelectorAll('.ns-jfama-l-bannerB.ns-jfama-v-0').forEach(element => element.style.display = 'none');" +
                    "document.querySelectorAll('.ns-jm633-l-bannerB.ns-jm633-v-0').forEach(element => element.style.display = 'none');" +
                    "document.querySelectorAll('.ad-container, .Google-Ad, .ad, .ads, .advert, .advertisement, .amp-animate, .i-amphtml-layout-container, .mys-wrapper, [class*=\"-banner\"]').forEach(element => element.style.display = 'none');" +
                    "document.querySelectorAll('#gwd-ad .gwd-page-container, #gwd-ad .gwd-page-wrapper, #gwd-ad .gwd-page-content, #gwd-ad .gwd-lightbox, #gwd-ad .gwd-play-animation, #gwd-ad .event-2-animation, #gwd-ad .gwd-gen-1igqgwdanimation, #gwd-ad .Logo_Start, #gwd-ad .Netto_Logo, #gwd-ad .gwd-gen-1rjsgwdanimation, #gwd-ad .gwd-gen-11gugwdanimation, #gwd-ad .gwd-gen-1pc9gwdanimation, #gwd-ad .gwd-gen-5a2ygwdanimation, #gwd-ad .gwd-gen-jn8rgwdanimation, #gwd-ad .gwd-gen-yllngwdanimation, #gwd-ad .gwd-gen-cc8ygwdanimation, #gwd-ad .gwd-gen-ixqigwdanimation, #gwd-ad .gwd-gen-krlngwdanimation, #gwd-ad .gwd-gen-11tigwdanimation, #gwd-ad .gwd-gen-1lq3gwdanimation, #gwd-ad .gwd-gen-1pc9gwdanimation').forEach(element => element.style.display = 'none');" +
                    "document.querySelectorAll('script[src*=\"googletagservices.com\"], script[src*=\"adsbygoogle.js\"]').forEach(element => element.remove());" +
                    "document.querySelectorAll('div[data-google-query-id]').forEach(element => element.style.display = 'none');" +
                     "document.querySelectorAll('.col-12.mt-4.col-md-6 > div:nth-child(1)').forEach(element => element.style.display = 'none');" +
                     "document.querySelectorAll('.col-12.mt-4.col-md-6 > div:nth-child(3)').forEach(element => element.style.display = 'none');" +
                    "document.querySelectorAll('.col-12.mt-4.col-md-6 > div:nth-child(1)').forEach(element => element.remove());" +
                    "document.querySelectorAll('.col-12.mt-4.col-md-6 > div:nth-child(3)').forEach(element => element.remove());" +
                    "};" +
                    "setInterval(hideAds, 0);"
    );
  }
}
