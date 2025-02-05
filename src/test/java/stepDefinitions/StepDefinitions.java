package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import java.util.Map;
import static hooks.GlobalHooks.driver;

public class StepDefinitions {

    private static int userCounter = 1; // Counter static pentru username
    private static String uniqueUser;

    @Given("customer is on the homepage")
    public void customerIsOnTheHomePage() {
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
    }

    @And("customer clicks on Register button")
    public void customerClicksOnRegisterButton() {
        HomePage homePage = new HomePage(driver);
        homePage.registerButton();
    }




    @When("Customer completes registration form using following data:")
    public void customerCompletesRegistrationFormUsingFollowingData(DataTable dataTable) {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Convertim tabelul Gherkin într-o hartă (Map)
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        // Populăm câmpurile formularului cu valorile din tabel
        registrationPage.inputFirstName(data.get("firstName"));
        registrationPage.inputLastName(data.get("lastName"));
        registrationPage.inputStreetAddress(data.get("address"));
        registrationPage.inputCity(data.get("city"));
        registrationPage.inputState(data.get("state"));
        registrationPage.inputZipCode(data.get("zip_code"));
        registrationPage.inputPhoneNumber(data.get("phoneNumber"));
        registrationPage.inputSSN(data.get("SSN"));

        // Generăm un username unic și îl folosim în test
        uniqueUser = utilities.userCounter.generateUniqueUser();
        registrationPage.inputUsername(uniqueUser);

        registrationPage.inputPassword(data.get("password"));
        registrationPage.inputConfirmPassword(data.get("confPassword"));

        // Click pe butonul de înregistrare
        registrationPage.clickRegisterButton();
    }




    @And("customer clicks create account button")
    public void customerClicksCreateAccountButton() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
                registrationPage.clickRegisterButton();
    }


    //@Then("customer should see a confirmation message with the username")
    public void customerShouldSeeConfirmationMessage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String confirmationText = registrationPage.getConfirmationMessage();

        // Verificăm dacă mesajul conține username-ul generat
        String expectedText = "Welcome " + uniqueUser;

        Assert.assertTrue("Confirmation message does not contain the expected username!",
                confirmationText.contains(expectedText));
    }

}