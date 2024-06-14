package core;

import model.User;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<User> logInUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Tramp@test.com", "Tramp123!"));
        users.add(new User("Tramp@test.com", "Tramp123!"));
        users.add(new User("Tramp@test.com", "Tramp123!"));
        return users.iterator();
    }

  /*  @DataProvider
    public Iterator<Object[]> addNewContactFromCsvFile() {
        List<Object[]> objects = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));

            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                User user = new User(split[0], split[1]);
                objects.add(new Object[]{user, split[2]});
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return objects.iterator();
    }*/

    @DataProvider
    public Iterator<User> loginUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Tramp@test.com", "Tramp123!"));
        users.add(new User("Tramp@test.com", "Tramp123!"));
        return users.iterator();

    }

}
