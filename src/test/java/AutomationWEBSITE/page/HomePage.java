package AutomationWEBSITE.page;

import AutomationWEBSITE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseTest {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator Home Page
    By brainboostBanner= By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]");


    // Permission Pop up
    By permissionNotificationShow = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.android.permissioncontroller:id/grant_dialog\"]");
    By allowButton = By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]");

    //transfer feature locator


    //validate transfer
    By checkAccountNameDestination = By.xpath("//android.widget.TextView[@resource-id='com.example.jangkau:id/tvName']");
    By checkAccountNumber = By.xpath("//android.widget.TextView[@resource-id='com.example.jangkau:id/tvRekening']");
    By checkAmountTransfer = By.xpath("//android.widget.TextView[@resource-id='com.example.jangkau:id/tvNominal']");
    By checkTotalAmount = By.xpath("//android.widget.TextView[@resource-id='com.example.jangkau:id/tvTransfer']");
    By checkAccountSource = By.xpath("//android.widget.TextView[@resource-id='com.example.jangkau:id/tvLabelRekening']");

    //PIN locator


    //validate transfer success

    By checkIDTransaction = By.xpath("//android.widget.TextView[@resource-id='com.example.jangkau:id/tvTransactionId']");
    By accountRecipient = By.xpath("//android.widget.TextView[@resource-id='com.example.jangkau:id/tvRekening']");
    By checkAmount = By.xpath("//android.widget.TextView[@resource-id='com.example.jangkau:id/tvNominal']");
    By checkTransactionTime = By.xpath("//android.widget.TextView[@resource-id='com.example.jangkau:id/tvDate']");


    //Method Action
    public void setPermissionNotification(){
        wait.until(ExpectedConditions.presenceOfElementLocated(permissionNotificationShow));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allowButton)).click();
    }

    public void validateHomePage(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(brainboostBanner));
    }

    public void validateBeforeTransfer(){
        wait.until(ExpectedConditions.presenceOfElementLocated(checkAccountNameDestination));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkAccountNumber));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkAmountTransfer));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkTotalAmount));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkAccountSource));
    }

    public void validateTransferSuccess(){
//        wait.until(ExpectedConditions.presenceOfElementLocated(checkSuccessIcon));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkIDTransaction));
        wait.until(ExpectedConditions.presenceOfElementLocated(accountRecipient));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkAmount));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkTransactionTime));
    }





}
