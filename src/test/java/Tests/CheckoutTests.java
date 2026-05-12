package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutStep1Page;
import pages.CheckoutStepTwoPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTests extends BaseTest {
	ProductsPage products;
	CartPage cart;
	CheckoutStep1Page checkOut1;
	CheckoutStepTwoPage checkOut2;
	CheckoutCompletePage complete;
    @BeforeMethod
    public void loginAndAddProduct() {
        LoginPage login = new LoginPage(driver);
        products = new ProductsPage(driver);
        cart = new CartPage(driver);
        checkOut1= new CheckoutStep1Page(driver);
        checkOut2 = new CheckoutStepTwoPage(driver);
        complete = new CheckoutCompletePage(driver);
        login.login("standard_user", "secret_sauce");   
        products.addBackpackToCart();
        products.clickCartLink();
        
    }
    @Test
    public void testNavigateToCheckout() {
    	
        cart.clickCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"),"Driver did not navigate to checkout Page");
    }
    
    @Test
    public void testMandatoryCheckoutInfo() {
    
        cart.clickCheckout();
        checkOut1.clickContinueBtn();
        //Error msg with blank info
        Assert.assertEquals(checkOut1.readErrorBtn(), "Error: First Name is required");
        checkOut1.enterFN("Preethi");
        checkOut1.clickContinueBtn();
        //Error msg with only first name
        Assert.assertEquals(checkOut1.readErrorBtn(), "Error: Last Name is required");
     //checkOut1.enterFN("Preethi");
        checkOut1.enterLN("SurName");
        checkOut1.clickContinueBtn();
      //Error msg with only first name and last name
        Assert.assertEquals(checkOut1.readErrorBtn(), "Error: Postal Code is required");
        
    }
    
    @Test
    public void testNavigateToOverview() {
    	cart.clickCheckout();
    	checkOut1.enterUserDetails("FirstName", "Surname", "500020");
    	Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"),"Driver did not navigate to checkout Overview Page");
    }
    @Test
    public void testOrderSummary() {
    	cart.clickCheckout();
    	checkOut1.enterUserDetails("FirstName", "Surname", "500020");
    	Assert.assertTrue(
                driver.findElement(By.className("inventory_item_name")).isDisplayed(),
                "Product not displayed in summary");
    }

    @Test
    public void testCompleteCheckoutFlow() {

        //check product is displayed in cart page
        Assert.assertTrue(cart.isProductDisplayed());
         // navigate to checkout step one
        cart.clickCheckout();
// enter user information 
        checkOut1.enterUserDetails("Preethi", "QA", "500001");
     // navigate to checkout step two
              checkOut2.finishCheckout();
//verify Success message after clicking finish
        Assert.assertEquals(
                complete.getSuccessMessage(),
                "Thank you for your order!");
    }
    
    @Test
    public void testCancelCheckOut() {
    	cart.clickCheckout();
       	checkOut1.clickCancelBtn();
    	Assert.assertTrue(driver.getCurrentUrl().contains("cart"),"Driver did not navigate to Cart Page");
    }
}