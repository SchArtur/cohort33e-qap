package demoQA;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinksPage extends BasePage {
    @FindBy(xpath = "//a[@id='simpleLink']")
    WebElement homeLink;

    @FindBy(xpath = "//a[@id='dynamicLink']")
    WebElement dynamicLink;

    @FindBy(xpath = "//a[@id='created']")
    WebElement apiCreated;

    @FindBy(xpath = "//p[@id='linkResponse']")
    WebElement apiLinkResponse;


    @FindBy(xpath = "//a[@id='no-content']")
    WebElement apiNoContent;

    @FindBy(xpath = "//a[@id='bad-request']")
    WebElement apiBadRequest;

    @FindBy(xpath = "//a[@id='unauthorized']")
    WebElement apiUnauthorized;

    @FindBy(xpath = "//a[@id='moved']")
    WebElement apiMoved;

    @FindBy(xpath = "//a[@id='forbidden']")
    WebElement apiForbidden;

    @FindBy(xpath = "//a[@id='invalid-url']")
    WebElement apiInvalidUrl;



    public LinksPage checkValidLink() {
        String url = homeLink.getAttribute("href");
        Assertions.assertTrue(isLinkValid(url), "Ссылка не валидна");
        return this;
    }

    public LinksPage checkDynamicLink() {
        String url = dynamicLink.getAttribute("href");
        Assertions.assertTrue(isLinkValid(url), "Ссылка не валидна");
        return this;
    }

    public LinksPage checkApiCreated() {
        apiCreated.click();
        String responseText = apiLinkResponse.getText();
        Assertions.assertEquals("Link has responded with staus 201 and status text Created", responseText, "Status code is not 201");
        return this;
    }

    public LinksPage checkApiNoContent() {
        apiNoContent.click();
        String responseText = apiLinkResponse.getText();
        Assertions.assertEquals("Link has responded with staus 204 and status text No Content", responseText, "Status code is not 204");
        return this;
    }

    public LinksPage checkApiMoved() {
        apiMoved.click();
        String responseText = apiLinkResponse.getText();
        Assertions.assertEquals("Link has responded with staus 301 and status text Moved Permanently", responseText, "Status code is not 301");
        return this;
    }

    public LinksPage checkApiBadRequest() {
        apiBadRequest.click();
        String responseText = apiLinkResponse.getText();
        Assertions.assertEquals("Link has responded with staus 400 and status text Bad Request", responseText, "Status code is not 400");
        return this;
    }

    public LinksPage checkApiUnauthorized() {
        apiUnauthorized.click();
        String responseText = apiLinkResponse.getText();
        Assertions.assertEquals("Link has responded with staus 401 and status text Unauthorized", responseText, "Status code is not 401");
        return this;
    }

    public LinksPage checkApiForbidden() {
        apiForbidden.click();
        String responseText = apiLinkResponse.getText();
        Assertions.assertEquals("Link has responded with staus 403 and status text Forbidden", responseText, "Status code is not 403");
        return this;
    }

    public LinksPage checkApiInvalidUrl() {
        apiInvalidUrl.click();
        String responseText = apiLinkResponse.getText();
        Assertions.assertEquals("Link has responded with staus 404 and status text Not Found", responseText, "Status code is not 404");
        return this;
    }
}
