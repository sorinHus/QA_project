package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/ul/li[1]/a")
    WebElement newAccountLink;

    public void clickNewAccountLink(){
        newAccountLink.click();
    }
}
