package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart_Page {

	WebDriver driver;
	
	@FindBy(css=".inventory_item_name")
	WebElement inventoryitem;
	
	@FindBy()
}
