package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products_Page {
	
	WebDriver driver;
//elements in product page
@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
WebElement addtshirtButton;

@FindBy(id="remove-sauce-labs-bolt-t-shirt")
WebElement removetshirtBtn;

@FindBy(id="add-to-cart-sauce-labs-backpack")
WebElement addbackpackButton;

@FindBy(css=".shopping_cart_link")
WebElement cartButton;

@FindBy(css=".shopping_cart_badge")
WebElement cartCount;

public Products_Page(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void openCart()
{
	cartButton.click();
}
//actions in product page
public void addTshirtToCart()
{
	addtshirtButton.click();
}

public void removeTshirtfromCart()
{
	removetshirtBtn.click();
}

public String getCartCount()
{
	return cartCount.getText();
}

}
