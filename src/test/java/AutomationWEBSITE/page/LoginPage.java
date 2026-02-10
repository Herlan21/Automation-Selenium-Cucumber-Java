package AutomationWEBSITE.page;


import AutomationWEBSITE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

//**LOGIN LOCATOR**//
//login form locator
    By emailForm = By.id("login_username");
    By passwordForm = By.id("login_password");
    By loginButton = By.xpath("//button[.//span[normalize-space()='Sign In']]");

//login form validation
   By welcomeWordingCms = By.xpath("//h1[@class='text-5xl lg:text-6xl font-bold leading-tight text-slate-800']");
   By inputUsernameAlert = By.xpath("//div[contains(text(),'Please input your username!')]");
   By inputPasswordAlert = By.xpath("//div[contains(text(),'Please input your password!')]");
   By wrongCredAlert =  By.xpath("//div[@class='ant-notification-notice ant-notification-notice-error ant-notification-notice-closable']");

//**LOGIN METHOD ACTION**//
//Login page validation
    public void validateLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailForm)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordForm)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeWordingCms)).isDisplayed();
    }

    public void validateAlertLoginPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsernameAlert)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPasswordAlert)).isDisplayed();
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    // ===== EMPTY FIELD ALERT (INLINE) =====
    public void validateInlineAlertForEmptyField(String username, String password) {

        if (username.isEmpty()) {
            assert isElementDisplayed(inputUsernameAlert);
        } else {
            assert !isElementDisplayed(inputUsernameAlert);
        }

        if (password.isEmpty()) {
            assert isElementDisplayed(inputPasswordAlert);
        } else {
            assert !isElementDisplayed(inputPasswordAlert);
        }

        // memastikan TIDAK ADA push notification
        assert !isElementDisplayed(wrongCredAlert);
    }

    // ===== WRONG CREDENTIAL ALERT (PUSH NOTIFICATION) =====
    public void validateWrongCredentialAlert() {
        assert isElementDisplayed(wrongCredAlert);

        // memastikan TIDAK ADA inline alert
        assert !isElementDisplayed(inputUsernameAlert);
        assert !isElementDisplayed(inputPasswordAlert);
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