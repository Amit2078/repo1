package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	WebElement email;
	public WebElement email() {
		return email;
	}
	
	@FindBy(id="input-password")
	WebElement password;
	public WebElement password() {
		return password;
	}
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbutton;
	public WebElement loginbutton() {
		return loginbutton;
	}
	

}
