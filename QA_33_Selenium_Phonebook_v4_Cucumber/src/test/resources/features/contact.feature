@all @ContactPage
Feature: Contact Page Test

  Background:
    * нет кнопки 'LOGIN' то нажимаем 'SIGN_OUT'
    * нажимаем на кнопку 'LOGIN' в заголовке
    * авторизуемся под тестовым пользователем

  Scenario: Проверка успешного добавления контакта
    * нажимаем на кнопку 'ADD' в заголовке
    * заполняем данные тестового контакта для добавления в записную книжку
    * нажимаем на кнопку 'Save'
    * ожидаем 5 секунд
    * проверяем, что контакт - "Test" добавился
    * удаляем контакт - Test

  Scenario: Проверка добавления контакта с не корректным номером телефона
    * нажимаем на кнопку 'ADD' в заголовке
    * заполняем данные контакта для добавления в записную книжку
      | name        | Test          |
      | lastName    | Testovij      |
      | phone       | 1234          |
      | email       | qwerty@qw.com |
      | address     | address       |
      | description | description   |
    * нажимаем на кнопку 'Save'
    * проверяем, что текст всплывающего уведомления содержит - "Phone not valid"

  Scenario Outline: Проверка успешного добавления контакта c параметрами
    * нажимаем на кнопку 'ADD' в заголовке
    * заполняем данные контакта для добавления в записную книжку
      | name        | <name>        |
      | lastName    | <lastName>    |
      | phone       | <phone>       |
      | email       | <email>       |
      | address     | <address>     |
      | description | <description> |
    * нажимаем на кнопку 'Save'
    * ожидаем 5 секунд
    * проверяем, что контакт - "<name>" добавился
    * удаляем контакт - <name>
    Examples:
      | name  | lastName | phone      | email           | address | description |
      | Test  | Test     | 1234567890 | qwerty@qwer.com | qwe     | desc        |
      | Test1 | Test     | 1234567890 | qwerty@qwer.com | qwe     | desc        |
      | Test2 | Test     | 1234567890 | qwerty@qwer.com | qwe     | desc        |
      | Test3 | Test     | 1234567890 | qwerty@qwer.com | qwe     | desc        |
      | Test4 | Test     | 1234567890 | qwerty@qwer.com | qwe     | desc        |
      | Test5 | Test     | 1234567890 | qwerty@qwer.com | qwe     | desc        |