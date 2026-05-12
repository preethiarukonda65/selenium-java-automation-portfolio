package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage {
	 WebDriver driver;

	    @FindBy(id = "finish")
	    WebElement finishBtn;

	    public CheckoutStepTwoPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void finishCheckout() {
	        finishBtn.click();
	    }
}
