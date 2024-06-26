package tests;

import ait.phonebook.dto.AuthenticationBodyDto;
import ait.phonebook.dto.ErrorMessageDto;
import ait.phonebook.dto.TokenDto;
import ait.phonebook.utils.HttpUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ait.phonebook.utils.HttpUtils.LOGIN_ENDPOINT;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("Проверка успешной авторизации")
    void test2() {
        TokenDto tokenDto = HttpUtils.postResponse(getLoginRq(), LOGIN_ENDPOINT, 200, TokenDto.class);

        Assertions.assertFalse(tokenDto.getToken().isEmpty(), "Пришел пустой токен");
    }

    @Test
    @DisplayName("Проверка авторизации с не корректным логином")
    void test3() {
        AuthenticationBodyDto loginRqBody = AuthenticationBodyDto.builder()
                .username("login.com")
                .password("QwertY123!")
                .build();

        ErrorMessageDto errorMessageDto = HttpUtils.postResponse(loginRqBody, LOGIN_ENDPOINT, 401, ErrorMessageDto.class);

        Assertions.assertEquals("Login or Password incorrect", errorMessageDto.getMessage(), "Текст ошибки не соответствует ожидаемому");
        Assertions.assertEquals("Unauthorized", errorMessageDto.getError(), "Тип ошибки не соответствует ожидаемому");
    }
}
