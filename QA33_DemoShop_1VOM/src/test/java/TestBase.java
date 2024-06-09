import core.AppManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite; //After all
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite; //BeforeAll

import java.lang.reflect.Method;

import static page_helpers.BaseHelper.takeScreenshot;

public class TestBase {
    protected static AppManager app = new AppManager("chrome");
    private final Logger logger = LoggerFactory.getLogger(TestBase.class);
    @BeforeSuite //@BeforeAll
    static void startTest() {
        app.init();
    }

    @AfterSuite //@AfterAll
    static void stopTest() {
        app.stop();
    }

    @BeforeMethod
    void startTest(Method method) {
       logger.info("Start test" + method.getName());
    }

    @AfterMethod
    void stopTest(ITestResult result) {
        if (result.isSuccess()) {
           logger.info("PASSED: " + result.getMethod().getMethodName());
          // takeScreenshot();
        } else {
            logger.info("FAILED: " + result.getMethod().getMethodName());
            takeScreenshot();

        }
     logger.info("===================================================");

    }
}
