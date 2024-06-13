package core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static google.BasePage.takeScreenshot;

@ExtendWith(BaseTest.BaseTestLogger.class)
public class BaseTest {
    protected static AppManager app = new AppManager(System.getProperty("browser", "chrome"));
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    void testStarted(TestInfo testInfo) {
        LOGGER.info("=====================" + testInfo.getTestMethod().orElseThrow().getName() + "=====================");
        LOGGER.info("START TEST: " + testInfo.getDisplayName());
        app.init();
        BaseTestLogger.startTime = System.currentTimeMillis();
    }

    @AfterAll
    public static void afterAll() {
        app.stop();
        LOGGER.info("********************** ВСЕ ТЕСТЫ ЗАВЕРШИЛИСЬ **********************");
    }

    static class BaseTestLogger implements TestWatcher {
        private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
        static long startTime;

        @Override
        public void testSuccessful(ExtensionContext context){
            long elapsedTime = System.currentTimeMillis() - startTime;
            app.stop();
            LOGGER.info("Test passed: ["+ context.getRequiredTestMethod().getName() + "], TIME for execution: " + elapsedTime + "ms");
        }

        @Override
        public void testFailed(ExtensionContext context, Throwable cause){
            takeScreenshot();
            long elapsedTime = System.currentTimeMillis() - startTime;
            app.stop();
            LOGGER.info("TEST FAILED: [" + context.getRequiredTestMethod().getName() + "], TIME for test execution: [" + elapsedTime + "] ms " + cause);
        }

        @Override
        public void testDisabled(ExtensionContext context, Optional<String> reason){
            takeScreenshot();
            long elapsedTime = System.currentTimeMillis() - startTime;
            app.stop();
            LOGGER.info("TEST DISABLED: [" + context.getRequiredTestMethod().getName() + "], TIME for test execution: [" + elapsedTime + "] ms " );
        }
        @Override
        public void testAborted(ExtensionContext context, Throwable cause){
            takeScreenshot();
            long elapsedTime = System.currentTimeMillis() - startTime;
            app.stop();
            LOGGER.info("TEST ABORTED: [" + context.getRequiredTestMethod().getName() + "], TIME for test execution: [" + elapsedTime + "] ms " + cause);
        }

    }

}

