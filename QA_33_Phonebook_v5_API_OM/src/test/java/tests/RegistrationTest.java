package tests;

import ait.phonebook.dto.ContactDto;
import ait.phonebook.dto.TokenDto;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RegistrationTest extends BaseTest {
    @Test
    void positiveRegistrationTest() {
        ContactDto registrationBody = ContactDto.builder()
                .id(null)
                .name("Jane")
                .lastName("Jany Jane")
                .phone("0123456789")
                .email("jane@test.com")
                .description("New user registration")
                .build();

        TokenDto tokenDto = given()//Начало запроса
                .contentType(ContentType.JSON)//Указываем тип контента
                .body(registrationBody)// Тело запроса (POST & PUT) ------------сюда бади с контактом или логины
                .when()// с каким методом и на какой эндпойнт отправляем запрос.
                .log().all()// логирование в консоль
                .post(REGISTER_ENDPOINT)// на какой адрес (или endpoint) отправляем запрос --------- эндрпоинт
                .then()// Что делаем когда получаем ответ
                .log().all()//Логируем ответ
                .assertThat().statusCode(200)//Проверяем статус код пришедшего ответа
                .extract().response().as(TokenDto.class);//извлекаем ответ.

        System.out.println();
        System.out.println(tokenDto.getToken());


    }
    void negativeRegistrationTest() {
        ContactDto registrationBody = ContactDto.builder()
                .id(null)
                .name("X")
                .lastName("Jany X")
                .phone("0123456789")
                .email("xtest.com")
                .description("New user registration with invalid Data")
                .build();

        TokenDto tokenDto = given()//Начало запроса
                .contentType(ContentType.JSON)//Указываем тип контента
                .body(registrationBody)// Тело запроса (POST & PUT) ------------сюда бади с контактом или логины
                .when()// с каким методом и на какой эндпойнт отправляем запрос.
                .log().all()// логирование в консоль
                .post(REGISTER_ENDPOINT)// на какой адрес (или endpoint) отправляем запрос --------- эндрпоинт
                .then()// Что делаем когда получаем ответ
                .log().all()//Логируем ответ
                .assertThat().statusCode(400)//Проверяем статус код пришедшего ответа
                .extract().response().as(TokenDto.class);//извлекаем ответ.

        System.out.println();
        System.out.println(tokenDto.getToken());
}
}
