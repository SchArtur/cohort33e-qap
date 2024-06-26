package core;

import model.Contact;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    public Iterator<Contact> addNewContact() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Test", "Test", "1234567890", "qwert@qwer.com", "wer", "qwer"));
        contacts.add(new Contact("Test1", "Test", "1234567890", "qwert@qwer.com", "wer", "qwer"));
        contacts.add(new Contact("Test2", "Test", "1234567890", "qwert@qwer.com", "wer", "qwer"));
        return contacts.iterator();
    }

    public Iterator<Object[]> addNewContactFromCsvFile() {
        List<Object[]> objects = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));

            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                Contact contact = new Contact(split[0], split[1], split[2], split[3], split[4], split[5]);
                objects.add(new Object[]{contact, split[6]});
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return objects.iterator();
    }

    public Iterator<User> loginUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("manuel@gm.com", "Manuel1234$"));
        users.add(new User("manuel@gm.com", "Manuel1234$"));
        return users.iterator();
    }

}