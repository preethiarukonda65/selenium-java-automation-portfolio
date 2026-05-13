package selenium_java_automation.SwagLabs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_Test_cases {
	
		
@Test
	public void testValidLogin() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Assert.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
	    driver.quit();
}

@Test
 public void testInvalidPassword() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("wrong_pass");
	driver.findElement(By.id("login-button")).click();
	String errorMsg= driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
	//System.out.println(errorMsg);
	Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",errorMsg);
	driver.quit();
}

@Test
public void testBlankLogin() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("login-button")).click();
	String errorMsg= driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
    //System.out.println(errorMsg);
	Assert.assertEquals("Epic sadface: Username is required",errorMsg);
	driver.quit();
}

}
