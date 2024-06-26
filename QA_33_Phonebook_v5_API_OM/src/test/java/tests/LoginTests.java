package tests;

import ait.phonebook.dto.TokenDto;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginTests extends BaseTest {

    @Test
    void test1() {
        TokenDto tokenDto = given()//Начало запроса
                .contentType(ContentType.JSON)//Указываем тип контента
                .body(getLoginRq())// Тело запроса (POST & PUT) ------------сюда бади с контактом или логины
                .when()// с каким методом и на какой эндпойнт отправляем запрос.
                .log().all()// логирование в консоль
                .post(LOGIN_ENDPOINT)// на какой адрес (или endpoint) отправляем запрос --------- эндрпоинт
                .then()// Что делаем когда получаем ответ
                .log().all()//Логируем ответ
                .assertThat().statusCode(200)//Проверяем статус код пришедшего ответа
                .extract().response().as(TokenDto.class);//извлекаем ответ.

        System.out.println();
        System.out.println(tokenDto.getToken());
    }
}
