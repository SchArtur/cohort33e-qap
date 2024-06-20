@all @HomePage
Feature: Проверка домашней страницы

  Background:
    * нажимаем на кнопку 'HOME' в заголовке

  Scenario: Проверка экрана страницы HOME
    * проверяем отображение 'Home Component'
    * check 'React Contacts App' is displayed
    * проверяем отображение 'For QA Testing'
