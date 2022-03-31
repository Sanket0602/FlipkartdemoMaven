package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilityClass;

public class LoginPage extends UtilityClass {
	
WebDriver driver;
	
	@FindBy(xpath="(//input[@type='text'])[2]")  
	private WebElement username;
	
	@FindBy(xpath="(//input[@type='password'])")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement submitbutton;
	
	@FindBy(xpath="//a[text()='Payments']")
	private WebElement payment;
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		this.driver= driver;
	}
	
	public void enterEmail() throws IOException {
		
		//username.sendKeys("salavesanket90@gmail.com");
		
		username.sendKeys(getConfigData("email")); // getting data from configuration file 
	}
	
	public void enterPassword() throws IOException {
		
		//password.sendKeys("Sanket@06");
		
		password.sendKeys(getConfigData("password")); // getting data from configuration file 
	}
	
	public void clickSubmit() {
		
		submitbutton.click();
	}

}
