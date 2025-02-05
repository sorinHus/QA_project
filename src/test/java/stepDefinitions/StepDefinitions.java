package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

import java.util.Map;

import static hooks.GlobalHooks.driver;

public class StepDefinitions {

    private static int userCounter = 1; // Counter static pentru username
    private String uniqueUser;

    @Given("customer is on the homepage")
    public void customerIsOnTheHomePage() {
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
    }

    @And("customer clicks on Register button")
    public void customerClicksOnRegisterButton() {
        HomePage homePage = new HomePage(driver);
        homePage.registerButton();
    }




    @When("customer completes registration form using following data:")
    public void customerCompletesRegistrationFormUsingFollowingData(DataTable dataTable) {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Convertim tabelul în Map
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        // Completăm formularul
        registrationPage.inputFirstName(data.get("firstName"));
        registrationPage.inputLastName(data.get("lastName"));
        registrationPage.inputStreetAddress(data.get("address"));
        registrationPage.inputCity(data.get("city"));
        registrationPage.inputState(data.get("state"));
        registrationPage.inputZipCode(data.get("zip_code"));
        registrationPage.inputPhoneNumber(data.get("phoneNumber"));
        registrationPage.inputSSN(data.get("SSN"));

        // Generăm username unic și îl folosim în test
        uniqueUser = utilities.userCounter.generateUniqueUser();
        registrationPage.inputUsername(uniqueUser);

        registrationPage.inputPassword(data.get("password"));
        registrationPage.inputConfirmPassword(data.get("confPassword"));

        //registrationPage.clickRegisterButton();
    }



    @And("customer clicks create account button")
    public void customerClicksCreateAccountButton() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
                registrationPage.clickRegisterButton();
    }
    @Then("customer should see a confirmation message")
    public void customerShouldSeeConfirmationMessage() {
        // Localizează mesajul de confirmare
        WebElement confirmationMessageElement = driver.findElement(By.xpath("//*[@id='rightPanel']/p"));

        // Obține textul efectiv al mesajului
        String actualMessage = confirmationMessageElement.getText();

        // Mesajul așteptat
        String expectedMessage = "Your account was created successfully. You are now logged in.";

        // Debugging - Print mesaj real în consolă
        System.out.println("Actual confirmation message: " + actualMessage);

        // Asigură-te că mesajul este cel așteptat
        Assert.assertEquals("Confirmation message is incorrect!", expectedMessage, actualMessage);
    }

}