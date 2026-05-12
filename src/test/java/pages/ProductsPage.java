package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	WebDriver driver;
	

	//@FindBy(className="inventory_item")
	//WebElement pageTitle;
	
    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;
    
    @FindBy(className="shopping_cart_link")
    WebElement cartLink;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpackAddBtn;
    
    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    WebElement bikelightAddBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement backpackRemoveBtn;
    
    //@FindBy()

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addBackpackToCart() {
        backpackAddBtn.click();
    }
    public void addBikeLightToCart() {
        bikelightAddBtn.click();
    }
    

    public void removeBackpackFromCart() {
        backpackRemoveBtn.click();
    }

    public int getCartCount() {
        return Integer.parseInt(cartBadge.getText());
    }

    public boolean isRemoveButtonDisplayed() {
        return backpackRemoveBtn.isDisplayed();
    }

	public void clickCartBadge() {
		// TODO Auto-generated method stub
		cartBadge.click();
	}
	public void clickCartLink() {
		cartLink.click();
	}
}

