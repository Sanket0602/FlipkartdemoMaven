package PomClasses;

import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilityClass;

public class ProfilePage extends UtilityClass{
	
	
WebDriver driver;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageaddress;
	
	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement addnewaddress;
	
	@FindBy(xpath="//textarea[@name='addressLine1']")
	private WebElement addaddress;
	
	@FindBy(xpath="(//div[@class='_1XFPmK'])[1]")
	private WebElement raideobutton;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement savebutton;
	
	
	public ProfilePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		this.driver = driver;
		
		
	}
	
	public  void clickOnManageAddress() {
		
		implicitWait(driver);
		manageaddress.click();
		
	}
	public void clickOnAddAddress() {
		
		implicitWait(driver);
		addnewaddress.click();
		
	}
	
	public void saveAddress(List <String> datalist) throws EncryptedDocumentException, IOException {
		
		//implicitWait(driver);
		//List<String> list =addAddressFromExcel(0,3); //store excel list in new list 
		
		for(int i=1; i<=4; i++) {
			
			WebElement element1  = driver.findElement(By.xpath("((//form)[2]//input)["+ i+"]")); //from list get data and put in webelement 
			
			element1.sendKeys(datalist.get(i-1));
		}
	}
	
	public void addAddressLine() {
		
		implicitWait(driver);
		
		addaddress.sendKeys("Naikwadi wasti akole");
	}
	
	public void selectRadioButton() {
		
		implicitWait(driver);
		
		raideobutton.click();
	}
	
	public void finallySaveAddress() throws InterruptedException {
		
		Thread.sleep(5000);
		savebutton.click();
	}
	

}
