import com.beust.ah.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{
@BeforeMethod
    void precondition(){
    app.getHomePageHelper().clickOnDemoWebShopLink();
}

@Test(description = "Check for Demo Web Shop Home page", groups = {"Positive"} )
    void  checkDemoWebShopHomePage(){
    Assert.assertTrue((app.getHomePageHelper().checkForDemoWebShopComponentIsPresent()));
    if (!app.getHomePageHelper().checkForLogInComponentIsPresent()) {
        app.getHomePageHelper().clickOnLogOutInLink();
        Assert.assertTrue (app.getHomePageHelper().checkForLogInComponentIsPresent());
    }
   else {app.getHomePageHelper().clickOnLogInLink();
        Assert.assertTrue(app.getHomePageHelper().checkForLogInComponentIsPresent());

    }
}

}
