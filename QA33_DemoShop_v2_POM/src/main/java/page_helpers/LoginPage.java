//package page_helpers;
//
//import io.qameta.allure.Step;
//import model.User;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//
//public class LoginPage extends BasePage {
//    @FindBy(css = "[href='/login']")
//    WebElement loginLink;
//
//    @FindBy(xpath="//*[text()='Log out']")
//    WebElement logOutButton;
//
//    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
//    WebElement login;
//
//    @Step("Переходим на страницу авторизации")
//    public void clickOnHomeLink() {
//        clickOnElement(loginLink);
//    }
//
//    @Step("Проверяем отображение 'Register'")
//    public boolean checkRegisterIsPresent() {
//        return login.isDisplayed();
//    }
//
//    @Step("Проверяем наличие кнопки 'LOGIN'")
//    public boolean isLoginLinkPresent() {
//        return isElementPresent(loginLink);
//    }
//
//    public boolean isLogOutButtonPresent() {
//        return isElementPresent(logOutButton);
//    }
//
//    public void clickOnLoginLink() {
//        clickOnElement(By.xpath("//*[text()='Log in']"));
//    }
//
//    public void clickOnLoginButton() {
//        clickOnElement(By.xpath("//input[@class='button-1 login-button']"));
//    }
//
//    public boolean isLoginLinkPresent() {
//        return isElementPresent(By.xpath("//*[text()='Log in']"));
//    }
//
//    public void fillLoginRegisterForm(User user) {
//        fillInputField(By.id("Email"), user.getEmail());
//        fillInputField(By.id("Password"), user.getPassword());
//    }
//
//    public void clickOnLogOutButton() {
//        clickOnElement(By.xpath("//*[text()='Log out']"));
//    }
//}
