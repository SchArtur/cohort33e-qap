import core.AppManager;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static AppManager app = new AppManager("chrome");

    @BeforeSuite
    static void startTest() {
        app.init();
    }

    @AfterSuite
    static void stopTest() {
        app.stop();
    }
}
