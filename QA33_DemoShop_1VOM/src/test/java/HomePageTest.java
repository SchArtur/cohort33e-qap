import com.beust.ah.A;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTest extends TestBase{
@BeforeMethod
    void precondition(){
    app.getHomePageHelper().clickOnDemoWebShopLink();
}

@Test(description = "Check for Demo Web Shop Home page", groups = {"Positive"} )
   @Step ("Проверка наличия элементов на домашней странице ")
    void  checkDemoWebShopHomePage(){
    assertTrue((app.getHomePageHelper().checkForDemoWebShopComponentIsPresent()));
    if (!app.getHomePageHelper().checkForLogInComponentIsPresent()) {
        app.getHomePageHelper().clickOnLogOutInLink();
        assertTrue (app.getHomePageHelper().checkForLogInComponentIsPresent());
    }
   else {app.getHomePageHelper().clickOnLogInLink();
        assertTrue(app.getHomePageHelper().checkForLogInComponentIsPresent());

    }
}

}
