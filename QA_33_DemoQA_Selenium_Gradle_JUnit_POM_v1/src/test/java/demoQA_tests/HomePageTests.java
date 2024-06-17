package demoQA_tests;

import core.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static core.AppManager.basePage;

public class HomePageTests extends BaseTest {

    @BeforeEach
    public void precondition() {
        //Указываем предусловия для тестов тут
    }

    @Feature("Home page tests") // * Заголовок в отчете Allure
    @Story("Test Case #01")// * Подзаголовок в отчете Allure
    @DisplayName("Открыть {Домашняя страница DemoQA}") // * Название теста
    @Order(1)
    @Test
    @RepeatedTest(value = 5, name = "{displayName} :: итерация [{currentRepetition}] из [{totalRepetitions}]")
    void searchTest() {
        basePage.open("https://demoqa.com/");
    }
}