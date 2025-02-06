package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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



}
