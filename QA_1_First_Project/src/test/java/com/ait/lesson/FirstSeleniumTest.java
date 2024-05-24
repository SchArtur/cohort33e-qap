<<<<<<<< HEAD:QA_1_First_Project/src/test/java/java/com/ait/lesson/FirstSeleniumTest.java
package java.com.ait.lesson;
========
package com.ait.lesson;
>>>>>>>> faff0f4 (add new Project):QA_1_First_Project/src/test/java/com/ait/lesson/FirstSeleniumTest.java

import org.junit.jupiter.api.*;

public class FirstSeleniumTest extends BaseTest {

    @Test
    @DisplayName("Проверка заголовка страницы")
    void testOpenBrowser() {
        driver.get("https://www.google.com/");//Открытие страницы

        driver.navigate().back();//Возврат на предыдущую страницу
        driver.navigate().forward();//Переход на следующую страницу
        driver.navigate().refresh();//Обновление страницы
        Assertions.assertEquals("Google", driver.getTitle(), "Открыта страница с другим Title");//Проверка заголовка страницы
    }
}
