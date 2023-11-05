package StepDefinitions;

import Pages.Login.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static StepDefinitions.StepDefinitions.driver;
import static StepDefinitions.StepDefinitions.url;

public class LoginStepDefinitions {

    private StepDefinitions stepDefinitions = new StepDefinitions();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("user is on home page")
    public void user_is_on_home_page() {
        driver.get(url);
    }

    @When("logging in with username: {string} and password {string}")
    public void enteringUsernameAndPassword(String username, String password) {
        loginPage.writeUsername(username);
        loginPage.writePassword(password);
    }

    @And("submitting login form")
    public void submitLoginForm() {
        loginPage.submitLoginForm();
    }

    @Then("user is not logged in and the message: {string} is displayed")
    public void assertUserNotLoggedIn(String errorMessage) {
        String actualErrorMessage = loginPage.returnLoginErrorMessage();
        Assert.assertEquals(actualErrorMessage, errorMessage);
    }

    @Then("user is logged in and redirected to {string}")
    public void isRedirectedTo(String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @And("is logged in with {string}")
    public void isLoggedInWith(String username){
        loginPage.loginWithUsernameAndPassword(username, "secret_sauce");
    }
}