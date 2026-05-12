package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test(groups={"Regression","Smoke"})
    public void testValidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(groups= {"Regression"})
    public void testInvalidPassword() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "wrong_pass");
        Assert.assertTrue(login.getErrorMessage().contains("do not match"));
    }
    
    @Test(groups= {"Regression"})
    public void testBlankLogin() {
    	LoginPage login = new LoginPage(driver);
    	login.clickLoginButton();
    	Assert.assertTrue(login.getErrorMessage().contains("Epic sadface: Username is required"));
    }
    
    @Test(groups= {"Regression"})
    public void testLockedUser() {
    	LoginPage login = new LoginPage(driver);
    	login.login("locked_out_user", "secret_sauce");
    	Assert.assertTrue(login.getErrorMessage().contains("Epic sadface: Sorry, this user has been locked out."));
    }
    
}