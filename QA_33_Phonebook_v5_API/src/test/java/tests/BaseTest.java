package tests;

import ait.phonebook.dto.AuthenticationBodyDto;
import ait.phonebook.utils.TestProperties;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.util.Properties;

public class BaseTest {

    public static Properties properties = TestProperties.getINSTANCE().getProperties();
    public static final String LOGIN_ENDPOINT = properties.getProperty("login.endpoint");

    @BeforeAll
    public static void load() {
        RestAssured.baseURI = properties.getProperty("base.url");
        RestAssured.basePath =properties.getProperty("base.version");
    }

    static AuthenticationBodyDto getLoginRq() {
        return  AuthenticationBodyDto.builder()
                .username(properties.getProperty("testuser.name"))
                .password(properties.getProperty("testuser.pass")).
                build();
    }
}
