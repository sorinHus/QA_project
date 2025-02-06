package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[1]/a")
    WebElement newAccountLink;

    @FindBy(xpath = "//*[@id=\"openAccountForm\"]/form/div/input")
    WebElement newAccountButton;

    @FindBy(xpath = "//*[@id=\"openAccountResult\"]/h1")
    WebElement newAccountOpened;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[7]/a")
    WebElement newLoanRequestlink;

    @FindBy(id = "amount")
    WebElement loanAmount;

    @FindBy(id = "downPayment")
    WebElement downPayment;

    @FindBy(id = "fromAccountId")
    WebElement fromAccountDropdown;

    @FindBy(css = "input[value='Apply Now']")
    WebElement applyNowButton;

    @FindBy(xpath = "//*[@id=\"loanRequestApproved\"]/p[1]")
    WebElement loanStatusMessage;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a")
    WebElement logOutLink;

    public void clickNewAccountLink(){
        newAccountLink.click();
    }

    public void clickNewAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Așteaptă ca butonul să fie vizibil și activ
        wait.until(ExpectedConditions.visibilityOf(newAccountButton));  // Așteaptă să fie vizibil
        wait.until(ExpectedConditions.elementToBeClickable(newAccountButton));  // Așteaptă să fie clicabil

        if (newAccountButton.isDisplayed() && newAccountButton.isEnabled()) {
            newAccountButton.click();  // Click pe buton doar dacă este vizibil și activ
        } else {
            System.out.println("Butonul New Account nu este vizibil sau activ!");
        }
    }


    public String NewAccountOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Așteaptă ca elementul să fie vizibil
        wait.until(ExpectedConditions.visibilityOf(newAccountOpened));

        // Verifică dacă textul este corect
        return newAccountOpened.getText();
    }

    public void clickNewLoanRequestLink(){
        newLoanRequestlink.click();
    }

    public void inputLoanAmount(String amount) {
        loanAmount.sendKeys("1000");
    }

    public void inputDownPayment(String payment) {
        downPayment.sendKeys("100");
    }

    public void selectFirstDropdownOption() {
        Select select = new Select(fromAccountDropdown);
        List<WebElement> options = select.getOptions();

        if (!options.isEmpty()) {
            select.selectByIndex(0);  // Selectează prima opțiune
            System.out.println("Prima opțiune selectată: " + options.get(0).getText());
        } else {
            System.out.println("Drop-down-ul nu are opțiuni disponibile!");
        }
    }

    public void clickApplyButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(applyNowButton));
        applyNowButton.click();
    }

    public String getLoanRequestConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loanStatusMessage));
        return loanStatusMessage.getText();
    }

    public void clickLogOutLink(){
        logOutLink.click();
    }
}
