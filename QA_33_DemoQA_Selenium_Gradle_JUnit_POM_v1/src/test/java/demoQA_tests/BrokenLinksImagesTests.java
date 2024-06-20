package demoQA_tests;

import core.BasePage;
import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static core.AppManager.*;

public class BrokenLinksImagesTests extends BaseTest {

    @BeforeEach
    void precondition() {
//        homePage.clickOnElements();
//        sidePanel.clickOnBrokenLinksImages();
        homePage
                .clickOnElements()
                .clickOnBrokenLinksImages();
    }

    @DisplayName("Проверка корректной ссылки")
    @Test
    void test1() {
        brokenLinksImagesPage.checkValidLink();
    }

    @DisplayName("Проверка не корректной ссылки")
    @Test
    void test2() {
        brokenLinksImagesPage.checkBrokenLink();
    }

    @DisplayName("Проверка корректного изображения")
    @Test
    void test3() {
        brokenLinksImagesPage.checkValidImage();
    }

    @DisplayName("Проверка не корректного изображения")
    @Test
    void test4() {
        brokenLinksImagesPage.checkBrokenImage();
    }

}
