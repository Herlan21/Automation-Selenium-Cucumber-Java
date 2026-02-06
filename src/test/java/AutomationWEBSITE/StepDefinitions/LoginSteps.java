package AutomationWEBSITE.StepDefinitions;

import AutomationWEBSITE.BaseTest;
import AutomationWEBSITE.page.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.testng.AssertJUnit.assertEquals;


public class LoginSteps extends BaseTest {

    private LoginPage loginPage;

    // Initialize Driver
    @Before
    public void setup() throws MalformedURLException, URISyntaxException {
//        setupDriver();
        loginPage = new LoginPage(driver);
    }

    // Step definitions
    @Given("user is launch the website")
    public void userIsLaunchWebsite() {
    }

    @And("user click form and input username with {string}")
    public void userInputUsernameWithUsername(String username) {
        loginPage.validateLoginPage();
        loginPage.inputUsername(username);
    }

    @And("user click form and input password with {string}")
    public void userInputPasswordWithPassword(String password) {
        loginPage.inputPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user is on CMS dashboard")
    public void userisondashboard() {

    }
}