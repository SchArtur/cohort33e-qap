package core;

import model.NewAccount;
import model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<NewAccount> addNewAccount() {
        List<NewAccount> accounts = new ArrayList<>();
        accounts.add(new NewAccount("Test", "Test1", "Test@gm.com", "Test1234!", "Test1234!"));
        accounts.add(new NewAccount("Test1", "Antonovvv", "antonantonovvv@gmail.com", "WvN3W$VUTA73T", "WvN3W$VUTA73T"));
        accounts.add(new NewAccount("Test2", "Test22", "Test22@gm.com", "Test12347!", "Test12347!"));
        return accounts.iterator();
    }

    @DataProvider
    public Iterator<User> loginUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("antonantonov@gmail.com", "WvN3W$VUTA72T"));
//        users.add(new User("antonantonovvv@gmail.com", "WvN3W$VUTA72T"));
        return users.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewAccountFromCsvFile() {
        List<Object[]> objects = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/newAccounts.csv")));

            String line = reader.readLine();

            while (line != null) {
                String[] split = line.split(",");
                NewAccount newAccount = new NewAccount(split[0], split[1], split[2], split[3], split[4]);
                objects.add(new Object[]{newAccount, split[5]});
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return objects.iterator();
    }
}
