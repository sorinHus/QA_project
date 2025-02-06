package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import utilities.userCounter;

public class LoginStepDefinitions {

    WebDriver driver;
    HomePage homePage;

    @Given("customer is on the homePage")
    public void customer_is_on_the_homepage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        homePage = new HomePage(driver);
    }

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
        driver.quit();
    }

    @When("customer enters valid password")
    public void customerEntersValidPassword() {
        homePage.enterPassword("123456");  // Parola folosită în scenariul de înregistrare
        homePage.clickLoginButton();
    }

    @Then("customer should error message for missing username")
    public void customerShouldErrorMessageForMissingUsername() {
        String expectedTitle = "Please enter a username and password.";
        String actualTitle = homePage.missingUserPassMessage();
        assertEquals(expectedTitle, actualTitle);
        driver.quit();
    }

    @When("customer enters valid username")
    public void customerEntersValidUsername() {
        String lastCreatedUsername = userCounter.getLastUsername();  // Preia ultimul username generat
        homePage.enterUsername(lastCreatedUsername);
        homePage.clickLoginButton();
    }

    @Then("customer should error message for missing password")
    public void customerShouldErrorMessageForMissingPassword() {
        String expectedTitle = "Please enter a username and password.";
        String actualTitle = homePage.missingUserPassMessage();
        assertEquals(expectedTitle, actualTitle);
        driver.quit();
    }
}