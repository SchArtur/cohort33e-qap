package demoQA;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenLinksImagesPage extends BasePage {


    @FindBy(xpath = "//p[contains(text(), 'Valid image')]/following::img[1]")
    WebElement validImage;

    @FindBy(xpath = "//p[contains(text(), 'Broken image')]/following::img[1]")
    WebElement brokenImage;

    @FindBy(xpath = "//p[contains(text(), 'Valid Link')]/following::a[1]")
    WebElement validLink;

    @FindBy(xpath = "//p[contains(text(), 'Broken Link')]/following::a[1]")
    WebElement brokenLink;

    public BrokenLinksImagesPage checkValidLink(){
        String url = validLink.getAttribute("href");
        Assertions.assertTrue(isLinkValid(url), "Ссылка не валидна");
        return this;
    }

    public BrokenLinksImagesPage checkValidImage(){
        String url = validImage.getAttribute("src");
        Assertions.assertTrue(isLinkValid(url), "Ссылка на изображение не валидна");
        Assertions.assertTrue(isImageValid(validImage), "Изображение не валидно");
        return this;
    }

    public BrokenLinksImagesPage checkBrokenLink(){
        String url = brokenLink.getAttribute("href");
        Assertions.assertFalse(isLinkValid(url), "Ссылка не валидна");
        return this;
    }

    public BrokenLinksImagesPage checkBrokenImage(){
        String url = brokenImage.getAttribute("src");
        Assertions.assertTrue(isLinkValid(url), "Ссылка на изображение валидна");
        Assertions.assertFalse(isImageValid(brokenImage), "Изображение валидно");
        return this;
    }

}
