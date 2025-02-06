package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import utilities.userCounter;

import java.time.Duration;

import static hooks.GlobalHooks.driver;
import static org.junit.Assert.assertEquals;

public class AccountStepDefinitions {

    HomePage homePage;
    AccountPage accountPage;  // Declară AccountPage o dată la nivelul clasei

    @Given("customer is on the Homepage")
    public void customerIsOnTheHomepage() {
        homePage = new HomePage(driver);  // Folosește driver-ul existent
    }

    @When("customer enters valid Credentials")
    public void customerEntersValidCredentials() {
        String lastCreatedUsername = userCounter.getLastUsername();  // Preia ultimul username generat
        homePage.enterUsername(lastCreatedUsername);
        homePage.enterPassword("123456");  // Parola folosită în scenariul de înregistrare
        homePage.clickLoginButton();
    }

    @And("customer clicks Open New Account link")
    public void clicksOpenNewAccountLink() {
        accountPage = new AccountPage(driver);  // Creează instanța odată pentru a o folosi în continuare
        accountPage.clickNewAccountLink();

        // Așteaptă ca pagina să fie încărcată
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("openaccount"));  // Verifică dacă URL-ul conține "account"
    }

    @And("customer clicks Open New Account button")
    public void clicksOpenNewAccountButton() {
        accountPage.clickNewAccountButton();  // Folosește instanța deja creată
    }

    @Then("customer will see Account opened confirmation")
    public void customerWillSeeAccountOpenedConfirmation() {
        String expectedTitle = "Account Opened!";
        String actualTitle = accountPage.NewAccountOpened();
        assertEquals(expectedTitle, actualTitle);
    }

    @And("customer clicks Request loan link")
    public void clicksRequestLoanLink() {
        accountPage = new AccountPage(driver);
        accountPage.clickNewLoanRequestLink();
    }

    @And("customer fills in the form")
    public void fillsInTheForm() {
        accountPage.inputLoanAmount("1000");
        accountPage.inputDownPayment("100");
        accountPage.selectFirstDropdownOption();
    }

    @And("customer clicks the Apply now button")
    public void customerClicksTheApplyNowButton() {
        accountPage.clickApplyButton();
    }

//
//
//    @Then("customer will see Loan Request confirmation")
//    public void customerWillSeeLoanRequestConfirmation() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(accountPage.getLoanConfirmationMessage()));
//
//        assertEquals("Loan request successfully submitted!", accountPage.getLoanConfirmationMessage());
//    }
}
