package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static core.AppManager.homePage;
import static core.AppManager.linksPage;

public class LinksPageTests extends BaseTest {

    @BeforeEach
    void precondition() {
//        homePage.clickOnElements();
//        sidePanel.clickOnLinks();
        homePage
                .clickOnElements()
                .clickOnLinks();
    }

    @DisplayName("Открытие в новой вкладке корректной ссылки")
    @Test
    void test1() {
        linksPage.checkValidLink();
    }

    @DisplayName("Открытие в новой вкладке динамической ссылки")
    @Test
    void test2() {
        linksPage.checkDynamicLink();
    }

    @DisplayName("Получение статуса 201 при запросе api")
    @Test
    void test3() {
        linksPage.checkApiCreated();
    }

    @DisplayName("Получение статуса 204 при запросе api")
    @Test
    void test4() {
        linksPage.checkApiNoContent();
    }

    @DisplayName("Получение статуса 301 при запросе api")
    @Test
    void test5() {
        linksPage.checkApiMoved();
    }

    @DisplayName("Получение статуса 400 при запросе api")
    @Test
    void test6() {
        linksPage.checkApiBadRequest();
    }

    @DisplayName("Получение статуса 401 при запросе api")
    @Test
    void test7() {
        linksPage.checkApiUnauthorized();
    }

    @DisplayName("Получение статуса 403 при запросе api")
    @Test
    void test8() {
        linksPage.checkApiForbidden();
    }

    @DisplayName("Получение статуса 404 при запросе api")
    @Test
    void test9() {
        linksPage.checkApiInvalidUrl();
    }
}
