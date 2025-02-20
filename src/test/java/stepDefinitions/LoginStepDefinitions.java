package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import utilities.userCounter;

import static hooks.GlobalHooks.driver;  // Folosește driver-ul din GlobalHooks

public class LoginStepDefinitions {

    HomePage homePage;

    @Given("customer is on the homePage")
    public void customer_is_on_the_homepage() {
        homePage = new HomePage(driver);  // Folosește driver-ul existent
    }

    //Login valid credentials
    @When("customer enters valid credentials")
    public void customer_enters_valid_credentials() {
        String lastCreatedUsername = userCounter.getLastUsername();  // Preia ultimul username generat
        homePage.enterUsername(lastCreatedUsername);
        homePage.enterPassword("123456");  // Parola folosită în scenariul de înregistrare
        homePage.clickLoginButton();


    }

    @Then("customer should be redirected to the account overview page")
    public void customer_should_be_redirected_to_the_account_overview_page() {
        String expectedTitle = "Accounts Overview";
        String actualTitle = homePage.getAccountOverviewTitle();
        assertEquals(expectedTitle, actualTitle);

        //Log-out
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogOutLink();
    }

    //Login missing username
    @When("customer enters valid password")
    public void customerEntersValidPassword() {
        homePage.enterPassword("123456");  // Parola folosită în scenariul de înregistrare
        homePage.clickLoginButton();
    }

    @Then("customer should see error message for missing username")
    public void customerShouldSeeErrorMessageForMissingUsername() {
        String expectedTitle = "Please enter a username and password.";
        String actualTitle = homePage.missingUserPassMessage();
        assertEquals(expectedTitle, actualTitle);
    }

    //Login missing password
    @When("customer enters valid username")
    public void customerEntersValidUsername() {
        String lastCreatedUsername = userCounter.getLastUsername();  // Preia ultimul username generat
        homePage.enterUsername(lastCreatedUsername);
        homePage.clickLoginButton();
    }

    @Then("customer should see error message for missing password")
    public void customerShouldSeeErrorMessageForMissingPassword() {
        String expectedTitle = "Please enter a username and password.";
        String actualTitle = homePage.missingUserPassMessage();
        assertEquals(expectedTitle, actualTitle);
    }

    //Login valid username invalid password
    @When("customer enters valid username and invalid password")
    public void customerEntersValidUsernameAndInvalidPassword() {
        String lastCreatedUsername = userCounter.getLastUsername();  // Preia ultimul username generat
        homePage.enterUsername(lastCreatedUsername);
        homePage.enterPassword("invalidPassword");  // Parola folosită în scenariul de înregistrare
        homePage.clickLoginButton();
    }

    @Then("customer should see error message invalid credentials")
    public void customerShouldSeeErrorMessageInvalidCredentials() {
        String expectedTitle = "An internal error has occurred and has been logged.";
        String actualTitle = homePage.missingUserPassMessage();
        assertEquals(expectedTitle, actualTitle);
    }


    //login invalid username
    @When("customer enters invalid username")
    public void customerEntersInvalidUsername() {
        String lastCreatedUsername = userCounter.getLastUsername();  // Preia ultimul username generat
        homePage.enterUsername("487invalidUsername");
        homePage.enterPassword("123456");  // Parola folosită în scenariul de înregistrare
        homePage.clickLoginButton();
    }

}