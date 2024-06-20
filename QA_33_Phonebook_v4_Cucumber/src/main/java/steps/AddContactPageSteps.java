package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import model.Contact;
import pages.BasePage;

import java.util.Map;

import static core.AppManager.TEST_CONTACT;
import static core.AppManager.addContactPage;

public class AddContactPageSteps extends BasePage {

    @И("нажимаем на кнопку 'Save'")
    public void clickOnSaveButton() {
        addContactPage.clickOnSaveButton();
    }

    @Тогда("заполняем данные тестового контакта для добавления в записную книжку")
    public void fillAddContact() {
        addContactPage.fillAddContact(TEST_CONTACT);
    }

    @Тогда("заполняем данные контакта для добавления в записную книжку")
    public void fillAddContact(Map<String, String> contactFields) {
        Contact contact = new Contact(contactFields.get("name"), contactFields.get("lastName"), contactFields.get("phone"), contactFields.get("email"), contactFields.get("address"), contactFields.get("description"));
        addContactPage.fillAddContact(contact);
    }
}
