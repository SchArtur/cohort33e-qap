package com.ait.qa;

import core.DataProviders;
import model.NewAccount;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static core.AppManager.NEW_USER;

public class CreateAccountTest extends BaseTest {

    @BeforeMethod
    void precondition() {
        if (!app.getLoginHelper().isLoginLinkPresent()) {
            app.getLoginHelper().clickOnLogOutButton();
        }
    }

    @Test (description = "Проверка успешной регистрации нового пользователя", groups = {"Positive"})
    void registerAccountPositiveTest() {
        app.getCreateAccountHelper().clickOnRegisterLink();
        app.getCreateAccountHelper().clickOnGenderCheckbox();
        app.getCreateAccountHelper().fillRegisterForm(NEW_USER);
        app.getCreateAccountHelper().clickOnRegisterButton();
        Assert.assertTrue(app.getCreateAccountHelper().isConfirmationPresent());
    }

    @Test(dataProvider = "addNewAccount", dataProviderClass = DataProviders.class)
    void successRegisterNewAccountDataProvider(NewAccount newAccount) {
        app.getCreateAccountHelper().clickOnRegisterLink();
        app.getCreateAccountHelper().clickOnGenderCheckbox();
        app.getCreateAccountHelper().fillRegisterForm(newAccount);
        app.getCreateAccountHelper().clickOnRegisterButton();
        Assert.assertTrue(app.getCreateAccountHelper().isConfirmationPresent());
    }
//
//    @Test(dataProvider = "addNewAccountFromCsvFile", dataProviderClass = DataProviders.class)
//    void successRegisterNewAccountTestFromCsv(NewAccount newAccount, String result) {
//        app.getCreateAccountHelper().clickOnRegisterLink();
//        app.getCreateAccountHelper().clickOnGenderCheckbox();
//        app.getCreateAccountHelper().fillRegisterForm(newAccount);
//        if (result.equals("passed")) {
//            app.getCreateAccountHelper().clickOnRegisterButton();
//            Assert.assertTrue(app.getCreateAccountHelper().isConfirmationPresent());
//        } else {
//            Assert.assertTrue(app.getCreateAccountHelper().getAlertText().contains(" email already exists"),"Сообщение в уведомлении не содержит 'email already exists'");
//        }
//    }
}
