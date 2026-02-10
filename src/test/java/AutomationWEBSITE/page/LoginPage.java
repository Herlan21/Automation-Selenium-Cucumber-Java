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

//login form locator
    By emailForm = By.id("login_username");
    By passwordForm = By.id("login_password");
    By loginButton = By.xpath("//button[.//span[normalize-space()='Sign In']]");

//login form validation
   By  welcomeWordingCms = By.xpath("//h1[@class='text-5xl lg:text-6xl font-bold leading-tight text-slate-800']");

//    By loginSuccessAlert = By.xpath("/html/body/div[3]/div/div[3]/div/button");
//    By errorEmailForm = By.xpath("//div[contains(@class,'ant-form-item-explain-error') and normalize-space()='Please input your username!']");
//    By errorPasswordForm = By.xpath("//div[contains(@class,'ant-form-item-explain-error') and normalize-space()='Please input your password!']");

//Login page validation
    public void validateLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailForm)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordForm)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeWordingCms)).isDisplayed();
    }

//Login form action method
    public void inputUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailForm)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailForm)).sendKeys(username);
    }

    public void inputPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordForm)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordForm)).sendKeys(password);
    }

    public void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }
}