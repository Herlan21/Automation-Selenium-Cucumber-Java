package AutomationWEBSITE.page;


import AutomationWEBSITE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailForm = By.id("login_username");
    By passwordForm = By.id("login_password");
    By loginButton = By.xpath("//button[.//span[normalize-space()='Sign In']]");

//    By loginSuccessAlert = By.xpath("/html/body/div[3]/div/div[3]/div/button");
//    By errorEmailForm = By.xpath("//div[contains(@class,'ant-form-item-explain-error') and normalize-space()='Please input your username!']");
//    By errorPasswordForm = By.xpath("//div[contains(@class,'ant-form-item-explain-error') and normalize-space()='Please input your password!']");

    // Login method
    // validate login page
    public void validateLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailForm)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordForm)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }

//Login form
    public void inputUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailForm)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailForm)).sendKeys(username);
    }

    public void inputPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordForm)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordForm)).sendKeys(password);
    }
//
//    public void clickPasswordForm(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordForm)).click();
//    }
//
//    public void inputPassword(String password){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordForm)).sendKeys(password);
//    }
//
    public void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }
//
//    public void clickSkipButton(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(skipButton)).isDisplayed();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(skipButton)).click();
//    }
//
//    public String invalidNotification(){
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorAlert)).getText();
//    }

//    public void invalidAlert(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(errorAlert)).isDisplayed();
//    }
}