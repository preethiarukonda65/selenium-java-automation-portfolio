package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class productsTests extends BaseTest{
	
	//WebDriver driver;
	//products page object is declared globally
	ProductsPage products;
	
	@BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
     products = new ProductsPage(driver);
	}
	
	@Test(groups= {"Smoke"})
	public void testProductListDisplayed() {
		
		 List<WebElement> items =
	                driver.findElements(By.className("inventory_item"));

	        Assert.assertTrue(items.size() > 0, "Product list is empty");
	}
	
	 @Test(groups= {"Smoke"})
	    public void testAddSingleProductToCart() {
		//ProductsPage products = new ProductsPage(driver);
		 
	        products.addBackpackToCart();
	        Assert.assertEquals(products.getCartCount(), 1);
	        

}
	 @Test(groups = {"Regression"})
	    public void testAddMultipleProductsToCart() {
		 ProductsPage products = new ProductsPage(driver);
	        products.addBackpackToCart();
	        products.addBikeLightToCart();

	        Assert.assertEquals(products.getCartCount(), 2);
	      
}
	 @Test(groups = {"Regression"})
	    public void testRemoveProductFromCart() {
	        
	        products.addBackpackToCart();
	        products.removeBackpackFromCart();

	        // Cart badge disappears after removing last item
	        List<WebElement> badge =
	                driver.findElements(By.className("shopping_cart_badge"));

	        Assert.assertTrue(badge.isEmpty());
	    }
	 @Test(groups = {"Regression"})
	    public void testCartBadgeUpdates() {
	        products.addBackpackToCart();
	        products.addBikeLightToCart();

	        Assert.assertEquals(products.getCartCount(), 2);

	        products.removeBackpackFromCart();

	        Assert.assertEquals(products.getCartCount(), 1);
	 }
	 
}
