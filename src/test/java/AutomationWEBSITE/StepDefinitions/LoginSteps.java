package AutomationWEBSITE.StepDefinitions;

import AutomationWEBSITE.BaseTest;
import AutomationWEBSITE.page.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class LoginSteps extends BaseTest {

    private LoginPage loginPage;
    private String currentUsername;
    private String currentPassword;

    // Initialize Driver
    @Before
    public void setup(){
        loginPage = new LoginPage(driver);
    }

    //** STEP DEFINITON ** //
    @Given("user is launch the website")
    public void userIsLaunchWebsite() {
    }

//    @And("user click form and input username with {string}")
//    public void userInputUsernameWithUsername(String username) {
//        loginPage.validateLoginPage();
//        loginPage.inputUsername(username);
//    }

@And("user click form and input username with {string}")
public void userInputUsernameWithUsername(String username) {
    currentUsername = username;
    loginPage.validateLoginPage();
    if (!username.isEmpty()) {
        loginPage.inputUsername(username);
    }
}

//    @And("user click form and input password with {string}")
//    public void userInputPasswordWithPassword(String password) {
//        loginPage.inputPassword(password);
//    }

    @And("user click form and input password with {string}")
    public void userInputPasswordWithPassword(String password) {
        currentPassword = password;
        if (!password.isEmpty()) {
            loginPage.inputPassword(password);
        }
    }

    @When("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user is on CMS dashboard")
    public void userisondashboard() {
    }

    //  Negative Case
//    @Then("user get alert")
//    public void usergetalert(){
//        loginPage.validateAlertLoginPage();
//        loginPage.WrongCredAlertMethod();
//    }

    @Then("user get login error based on input condition")
    public void userGetLoginErrorBasedOnCondition() {

        // CASE 1: EMPTY FIELD
        if (currentUsername.isEmpty() || currentPassword.isEmpty()) {
            loginPage.validateInlineAlertForEmptyField(
                    currentUsername,
                    currentPassword
            );
        }
        // CASE 2: WRONG CREDENTIAL
        else {
            loginPage.validateWrongCredentialAlert();
        }
    }
}