package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	  WebDriver driver;

	    @FindBy(id = "checkout")
	    WebElement checkoutBtn;
	    
	    @FindBy(id="remove-sauce-labs-backpack")
	    WebElement cartRemoveBtn;

	    @FindBy(className = "inventory_item_name")
	    WebElement productName;
	    
	    @FindBy(className="cart_quantity")
	    WebElement cartQuantity;
	    
	    @FindBy(className = "inventory_item_price")
	    WebElement productPrice; 
	    
	    @FindBy(id="continue-shopping")
	    WebElement continueShopping;
	    
	    @FindBy(id="checkout")
	    WebElement checkOutBtn;

	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public boolean isProductDisplayed() {
	        return productName.isDisplayed();
	    }

	    public void clickCheckout() {
	        checkoutBtn.click();
	    }

		public String getProductQuantity() {
			// TODO Auto-generated method stub
			return cartQuantity.getText();
		}

		public String getProductName() {
			// TODO Auto-generated method stub
			return productName.getText();
		}

		public String getProductPrice() {
			// TODO Auto-generated method stub
			return productPrice.getText();
		}
		public void clickRemoveBtn() {
			// TODO Auto-generated method stub
			 cartRemoveBtn.click();
		}
		
		public void clickContinueShopping() {
			continueShopping.click();
		}
		public void clickCheckoutBtn() {
			checkOutBtn.click();
		}
}
