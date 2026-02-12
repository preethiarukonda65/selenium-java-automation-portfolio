package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Test {

	/*initializing the Webdriver out of methods so that driver 
	can be accessed from all the methods and keep it protected*/
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
	}
	@AfterMethod
	public void teardown() {
		if(driver!= null) {
			driver.quit();
		}
		
	}
}
