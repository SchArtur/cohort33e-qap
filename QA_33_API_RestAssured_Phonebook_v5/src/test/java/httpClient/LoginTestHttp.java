package httpClient;

import ait.phonebook.dto.AuthenticationBodyDto;
import ait.phonebook.dto.ErrorMessageDto;
import ait.phonebook.dto.TokenDto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginTestHttp {

    @Test
    void test1() throws IOException {
        String body = "{\n" +
                "  \"username\": \"manuel@gm.com\",\n" +
                "  \"password\": \"Manuel1234$\"\n" +
                "}";
        String url = "https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword";
        Response response = Request
                .Post(url)
                .bodyString(body, ContentType.APPLICATION_JSON)
                .execute();

        String responseJson = response.returnContent().asString();
        System.out.println(responseJson);

        JsonElement element = JsonParser.parseString(responseJson);
        JsonElement token = element.getAsJsonObject().get("token");

        System.out.println(token.getAsString());
    }

    @Test
    void test2() throws IOException {
        AuthenticationBodyDto authenticationBodyDto = AuthenticationBodyDto.builder()
                .username("manuel@gm.com")
                .password("Manuel1234$").
                build();

        Gson gson = new Gson();

        String url = "https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword";
        Response response = Request
                .Post(url)
                .bodyString(gson.toJson(authenticationBodyDto), ContentType.APPLICATION_JSON)
                .execute();

        String responseJson = response.returnContent().asString();
        TokenDto tokenDto = gson.fromJson(responseJson, TokenDto.class);
        System.out.println("===============================");
        System.out.println();
        System.out.println(tokenDto.getToken());
        System.out.println();
        System.out.println("===============================");
    }

    @Test
    void test3() throws IOException {
        AuthenticationBodyDto authenticationBodyDto = AuthenticationBodyDto.builder()
                .username("manuel@gm.com")
                .password("Manuel123").
                build();

        Gson gson = new Gson();

        String url = "https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword";
        Response response = Request
                .Post(url)
                .bodyString(gson.toJson(authenticationBodyDto), ContentType.APPLICATION_JSON)
                .execute();

        HttpResponse httpResponse = response.returnResponse();
        System.out.println(httpResponse);

        BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }


        ErrorMessageDto errorMessageDto = gson.fromJson(sb.toString(), ErrorMessageDto.class);
        System.out.println("===============================");
        System.out.println();
        System.out.println(errorMessageDto.toString());
        System.out.println();
        System.out.println("===============================");
    }
}
