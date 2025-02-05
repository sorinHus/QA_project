package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "customer.firstName")
    WebElement customerFirstName;

    @FindBy(id = "customer.lastName")
    WebElement customerLastName;

    @FindBy(id = "customer.address.street")
    WebElement customerStreetAddress;

    @FindBy (id = "customer.address.city")
    WebElement customerCity;

    @FindBy (id = "customer.address.state")
    WebElement customerState;

    @FindBy(id = "customer.address.zipCode")
    WebElement customerZipCode;

    @FindBy(id = "customer.phoneNumber")
    WebElement customerPhoneNumber;

    @FindBy(id = "customer.ssn")
    WebElement customerSSN;

    @FindBy(id = "customer.username")
    WebElement customerUsername;

    @FindBy(id = "customer.password")
    WebElement customerPassword;

    @FindBy(id = "repeatedPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")
    WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    WebElement confirmationMessage;

    public void inputFirstName(String firstName){
        customerFirstName.sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        customerLastName.sendKeys(lastName);
    }
    public void inputStreetAddress(String streetAddress){
        customerStreetAddress.sendKeys(streetAddress);
    }
    public void inputCity(String city){
        customerCity.sendKeys(city);
    }
    public void inputState(String state){
        customerState.sendKeys(state);
    }
    public void inputZipCode(String zipCode){
        customerZipCode.sendKeys(zipCode);
    }
    public void inputPhoneNumber(String phoneNumber){
        customerPhoneNumber.sendKeys(phoneNumber);
    }
    public void inputSSN(String ssn){
        customerSSN.sendKeys(ssn);
    }
    public void inputUsername(String username){
        customerUsername.sendKeys(username);
    }
    public void inputPassword(String password){
        customerPassword.sendKeys(password);
    }
    public void inputConfirmPassword(String confirmPassword){
        this.confirmPassword.sendKeys(confirmPassword);
    }
    public void clickRegisterButton(){
        registerButton.click();
    }
    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

}
