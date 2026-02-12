package tests;

import org.testng.annotations.Test;

import base.Base_Test;
import pages.Products_Page;

public class AddToCart_Tests extends Base_Test{

	@Test
		public void testAddSingleProductToCart() {
		Products_Page Products=new Products_Page(driver);
		Products.addTshirtToCart();
		Products.openCart();
	}
}
