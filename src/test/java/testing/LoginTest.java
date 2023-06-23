package testing;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.SuccessPage;
import resources.Base;

@Listeners(testing.TestNGListener.class)

public class LoginTest extends Base{
	WebDriver driver;
	
	@Test(dataProvider="logindata")
	public void login(String username,String password,String expResult) 
			throws InterruptedException {
		
		// called from landingpage class
		LandingPage landpage = new LandingPage(driver);
		landpage.myaccount().click();
		
		landpage.login().click();
		// called from loginpage class
		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(1000);
		loginpage.email().sendKeys(username);
		//Thread.sleep(1000);
		loginpage.password().sendKeys(password);
		//Thread.sleep(1000);
		loginpage.loginbutton().click();
		
		SuccessPage successpage = new SuccessPage(driver);
		String actualResult = null;
		
		try {
		if(successpage.success().isDisplayed())
			actualResult = "Passed";
			
		}catch(Exception e)
		{
			actualResult = "Failed";
		}
	  Assert.assertEquals(actualResult, expResult);	
		
	}
	
	@DataProvider
	public Object[][] logindata() {
		
		Object[][] data =  {
				         {"abc1@xxx.com","Second@123","Passed"},
				         {"test@abc.com","abc@214222","Failed"},
				         {"anu@hdjc.com","xyz@000000","Failed"}
		                   };
			return data;
			                       }	              
	@BeforeMethod
	public void open() throws FileNotFoundException {
		// called from base class for webdriver starting
				driver = initializeDriver();
				driver.get(prop.getProperty("url"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
