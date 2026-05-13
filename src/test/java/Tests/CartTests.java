package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.WaitUtils;

public class CartTests extends BaseTest {
	
	
	CartPage cart;
	ProductsPage products;
    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        products = new ProductsPage(driver);
        cart= new CartPage(driver);
                
        
    }

    @Test
    public void testProductVisibleInCart() {
    	products.addBackpackToCart();
        products.clickCartLink();
    	WaitUtils wait= new WaitUtils(driver);
    	wait.ElementTobeVisible(By.className("title"));
    	 List<WebElement> items =
                 driver.findElements(By.className("cart_item"));
  
    	// System.out.print(items.size());
         Assert.assertTrue(items.size() > 0, "Product list is empty");
      // Assert.assertTrue(cart.isProductDisplayed(), "Product is Not Displayed in Cart");
        
    }
    @Test
    public void testProductDetails() {
    	products.addBackpackToCart();
        products.clickCartLink();
    	Assert.assertEquals(cart.getProductQuantity(), "1");
    	Assert.assertEquals(cart.getProductName(), "Sauce Labs Backpack");
    	Assert.assertEquals(cart.getProductPrice(), "$29.99");
    }

    @Test
    public void testRemoveProductFromCart() {
    	products.addBackpackToCart();
        products.clickCartLink();
        cart.clickRemoveBtn();
        List<WebElement> items =
                driver.findElements(By.className("inventory_item_name"));
        Assert.assertTrue(items.isEmpty(), "Product list is not empty");
        // Cart badge disappears after removing last item
        
    }
    @Test
    public void testEmptyCart() {
    	products.clickCartLink();
    	List<WebElement> items =
                driver.findElements(By.className("inventory_item_name"));
        Assert.assertTrue(items.isEmpty(), "Cart is not empty");
    }
    
    @Test
    public void testContinueShoppingNav() {
    	products.addBackpackToCart();
        products.clickCartLink();
        cart.clickContinueShopping();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),"Driver did not navigate to Products Page");
    }
    @Test
        public void testCheckOutBtn() {
    	products.addBackpackToCart();
        products.clickCartLink();
        cart.clickCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"),"Driver did not navigate to checkout Page");
    }
    @Test
    public void testMultipleProductsinCart() {
    	products.addBackpackToCart();
    	products.addBikeLightToCart();
        products.clickCartLink();
    	WaitUtils wait= new WaitUtils(driver);
    	wait.ElementTobeVisible(By.className("title"));
    	 List<WebElement> items =
                 driver.findElements(By.className("cart_item"));
  
    	// System.out.print(items.size());
         Assert.assertTrue(items.size() ==2, "Cart list is Incorrect");
    }
    @Test
    public void testCartPersistance() {
    	products.addBackpackToCart();
    	        products.clickCartLink();
    	WaitUtils wait= new WaitUtils(driver);
    	wait.ElementTobeVisible(By.className("title"));
    	 List<WebElement> items =
                 driver.findElements(By.className("cart_item"));
  
    	// System.out.print(items.size());
         Assert.assertTrue(items.size() ==1, "Cart items are not updated to 1");
         // Refresh the page and check cart 
         driver.navigate().refresh();
         wait.ElementTobeVisible(By.className("title"));
    	 List<WebElement> items1 =
                 driver.findElements(By.className("cart_item"));
         Assert.assertTrue(items1.size() ==1, "Cart items changed after refreshing the cart");
    }
    
    @Test
    public void testCartBadgeSync() {
    	products.addBackpackToCart();
    	Assert.assertTrue(products.getCartCount()==1,"Cart Count is not in sync");
    	products.addBikeLightToCart();
    	Assert.assertTrue(products.getCartCount()==2,"Cart Count is not in sync when 2nd product is added");
    }
    
    
}