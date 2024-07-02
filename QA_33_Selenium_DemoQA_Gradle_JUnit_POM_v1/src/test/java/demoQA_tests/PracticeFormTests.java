package demoQA_tests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static core.AppManager.*;

@DisplayName("Тестовый класс для проверки \"Forms\" --> \"Practice Form\"")
public class PracticeFormTests extends BaseTest {
private final String IMG_PATH = new File("src/test/resources/img.png").getAbsolutePath();
  @BeforeEach
  public void precondition() {
    homePage.getForms().selectPracticeForm().hideAds();
  }
  String name = "Issac";
  String lastName = "Asimov";
  String email = "jak@gmail.com";
  String phone = "1234567890";
  String genderM = "Male";
  String date = "07 nov 1985";
  String[] subjects = {"Maths", "English", "Chemistry"};
  String[] hobbies = {"Sports", "Music"};
  String stateNCR = "NCR";
  String cityDelhi = "Delhi";

  @Test
  @DisplayName("Forms -->  \"Practice Form\" --> Ввод даты как строка \"Student Registration Form\"")
  public void registerNewStudentTest() {
    practiceFormPage.enterPersonalData(name, lastName, email, phone)
            .selectGender(genderM)
            .enterDate(date) // дата вводится как строка в формате "07 nov 1985"
            .enterSubjects(subjects)
            .selectHobbies(hobbies)
            .uploadFile(IMG_PATH)
            .selectState(stateNCR)
            .selectCity(cityDelhi)
            .submit();
  }

  @Test
  @DisplayName("Forms -->  \"Practice Form\" --> Выбор даты из списка \"Student Registration Form\"")
  public void registerNewStudentWithChooseDateTest() {
    practiceFormPage.enterPersonalData(name, lastName, email, phone)
            .selectGender(genderM)
            .enterSubjects(subjects)
            .selectHobbies(hobbies)
            .uploadFile(IMG_PATH)
            .selectState(stateNCR)
            .selectCity(cityDelhi)
            .submit();
  }
}
