package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	//list of all the webelements used to automate testcases
	WebDriver driver;
@FindBy(id="user-name")
WebElement username_input;

@FindBy(id="password")
WebElement password_input;

@FindBy(xpath="//input[@name='login-button']")
WebElement login_button;

@FindBy(xpath="//h3[@data-test='error']")
WebElement errorMsg;

//List of all the reusable methods in Login Page
public void Loginprocess(String uName,String pwd) {
	username_input.sendKeys(uName);
	password_input.sendKeys(pwd);
	login_button.click();
}

public Login_Page(WebDriver driver)
{
	this.driver=driver;
	//initializing all the @FindBy Annotations in the calss
	PageFactory.initElements(driver, this);
}

public String readErrorMsg() {
	return errorMsg.getText();
}


}
