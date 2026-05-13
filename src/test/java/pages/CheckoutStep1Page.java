package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStep1Page {
	WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;
    
    @FindBy(xpath = "//h3[(contains(text(),'Error'))]")
    WebElement errorMsg;
    
    @FindBy(id="cancel")
    WebElement cancelBtn;

    public CheckoutStep1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickContinueBtn() {
    	continueBtn.click();
    }
    public void clickCancelBtn() {
    	cancelBtn.click();
    }
    public String readErrorBtn() {
    	return errorMsg.getText();
    }

    public void enterFN(String fName) {
    	firstName.sendKeys(fName);
    }
    public void enterLN(String lName) {
    	lastName.sendKeys(lName);
    }
    public void enterUserDetails(String fName, String lName, String zip) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        postalCode.sendKeys(zip);
        continueBtn.click();
    }
}
