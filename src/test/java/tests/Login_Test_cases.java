package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base_Test;
import pages.Login_Page;

public class Login_Test_cases extends Base_Test{
	
		
@Test
	public void testValidLogin() {
	//creating an object of the constructor created in login page
	    Login_Page Login= new Login_Page(driver);
	    Login.Loginprocess("standard_user","secret_sauce");
	    Assert.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
	    
}

@Test
 public void testInvalidPassword() {
	 Login_Page Login= new Login_Page(driver);
	    Login.Loginprocess("standard_user","wrong_pass");
	    Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",Login.readErrorMsg());

}

@Test
public void testBlankLogin() {
	Login_Page Login= new Login_Page(driver);
    Login.Loginprocess("", "");
	Assert.assertEquals("Epic sadface: Username is required",Login.readErrorMsg());
	
}
@Test
public void testLockedUserLogin() {
	Login_Page Login= new Login_Page(driver);
    Login.Loginprocess("locked_out_user", "secret_sauce");
	Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.",Login.readErrorMsg());
	
}

}
