
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @BeforeMethod
    void precondition() {
        if (!app.getHomePageHelper().checkHomeComponentIsPresent()) {
            app.getHomePageHelper().clickOnHomeLink();
        }
    }

    @Test
    void checkHomePage() {
        Assert.assertTrue(app.getHomePageHelper().checkHomeComponentIsPresent());
        Assert.assertTrue(app.getHomePageHelper().checkReactAppInfoIsPresent());
        Assert.assertTrue(app.getHomePageHelper().checkForQaInfoIsPresent());
    }

}
