package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/p[2]/a")
    public WebElement registerButton;

    @FindBy(name = "username")
    public WebElement usernameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id='loginPanel']/form/div[3]/input")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"showOverview\"]/h1")
    public WebElement accountOverviewTitle;

    public void registerButton() {
        registerButton.click();
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getAccountOverviewTitle() {
        return accountOverviewTitle.getText();
    }
}
