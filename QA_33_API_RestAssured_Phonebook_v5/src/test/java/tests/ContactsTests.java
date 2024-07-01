package tests;

import ait.phonebook.dto.ContactsDto;
import ait.phonebook.dto.ResponseMessageDto;
import ait.phonebook.dto.TokenDto;
import ait.phonebook.utils.HttpUtils;
import org.junit.jupiter.api.*;

import java.util.Set;

import static ait.phonebook.utils.HttpUtils.*;
import static ait.phonebook.utils.Utils.isNullOrEmpty;

public class ContactsTests extends BaseTest {

    private String token;

    @BeforeEach
    void precondition(TestInfo testInfo) {
        Set<String> tags = testInfo.getTags();
        if (tags.contains("@ADD")) {
            token = HttpUtils.postResponse(getDeleteTestUserLoginBody(), LOGIN_ENDPOINT, 200, TokenDto.class).getToken();
            HttpUtils.deleteResponse(token, CONTACTS_ENDPOINT + "/clear", 200, ResponseMessageDto.class);
        } else if (tags.contains("@DELETE")) {
            token = HttpUtils.postResponse(getDeleteTestUserLoginBody(), LOGIN_ENDPOINT, 200, TokenDto.class).getToken();
            postResponseWithToken(getContactBody(), CONTACTS_ENDPOINT, 200, token, ResponseMessageDto.class);
        } else {
            token = HttpUtils.postResponse(getTestUserLoginBody(), LOGIN_ENDPOINT, 200, TokenDto.class).getToken();
        }
    }

    @Test
    @DisplayName("Проверка получения списка контактов у авторизованного пользователя")
    void test1() {
        ContactsDto contacts = getResponse(token, CONTACTS_ENDPOINT, 200, ContactsDto.class);
        Assertions.assertFalse(contacts.getContacts().isEmpty());
    }

    @Test
    @DisplayName("Проверка получения списка контактов без авторизации")
    void test2() {
        HttpUtils.getResponse(HttpMethods.GET, CONTACTS_ENDPOINT, null, 403, null);
    }

    @Test
    @Tag("@ADD")
    @DisplayName("Проверка добавления контакта у авторизованного пользователя")
    void test3() {
        ResponseMessageDto responseMessageDto = postResponseWithToken(getContactBody(), CONTACTS_ENDPOINT, 200, token, ResponseMessageDto.class);
        Assertions.assertFalse(isNullOrEmpty(responseMessageDto.getMessage()));
        String id = responseMessageDto.getMessage().replace("Contact was added! ID: ", "");

        ContactsDto contacts = getResponse(token, CONTACTS_ENDPOINT, 200, ContactsDto.class);
        Assertions.assertTrue(contacts.getContacts().size() == 1);
        Assertions.assertEquals(id, contacts.getContacts().get(0).getId(), "Добавлен контакт с другим id");
        HttpUtils.deleteResponse(token, CONTACTS_ENDPOINT + "/clear", 200, ResponseMessageDto.class);
    }

    @Test
    @Tag("@DELETE")
    @DisplayName("Проверка удаления контакта у авторизованного пользователя по id")
    void test4() throws Exception {
        ContactsDto contacts = getResponse(token, CONTACTS_ENDPOINT, 200, ContactsDto.class);
        Assertions.assertTrue(contacts.getContacts().size() == 1);
        String id = contacts.getContacts().get(0).getId();

        ResponseMessageDto responseMessageDto = deleteResponse(token, CONTACTS_ENDPOINT + "/" + id, 200, ResponseMessageDto.class);
        Assertions.assertEquals("Contact was deleted!", responseMessageDto.getMessage(), "Сообщение об удалении не соответствует ожидаемому");

        contacts = getResponse(token, CONTACTS_ENDPOINT, 200, ContactsDto.class);
        //TODO написать вторую проверку по списку
        Assertions.assertTrue(contacts.getContacts().size() == 0);

        //Альтернативная проверка
//        for (ContactDto contact : contacts.getContacts()) {
//            if (contact.getId().equals(id)) {
////                throw new Exception("Контакт не удалён");
//                //AutotestExc
//                Assertions.assertFalse(contact.getId().equals(id), "Контакт не удалён");
//            }
//        }
    }

}

