package TestClasess;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import BaseClass.BaseClass1;
import PomClasses.HomePages;
import PomClasses.LoginPage;
import PomClasses.ProfilePage;

public class Test1class {


	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@Parameters("Browser")
	@BeforeClass
	public void beforeClass(String a) throws InterruptedException {
		
		report = new ExtentReports("Extentrepotrs.html",true);
		
		 test = report.startTest("VerifyLogin");
				
		driver = BaseClass1.getBrowser(a);
	}


	@Test(priority=1)
	public void VerifyLogin() throws InterruptedException, IOException {


		LoginPage loginpage = new LoginPage(driver);
		//loginpage.explicitwait();
		loginpage.enterEmail();
		loginpage.enterPassword();
		loginpage.clickSubmit();
		Thread.sleep(3000);

		//Reporter.log("Login in FlipKart");
		
		test.log(LogStatus.PASS, "User can login");
	}
	
	@DataProvider(name= "dataSet")
	public String[][]  dataToTest() 
	{
		String[][] data = {{"Ganesh","9845124785","411041","Nanded City"},{"Atul","8745235685","413512","Karve nagar"}};
		
		return data;
	}
	
	@Test(priority=2,dataProvider="dataSet")
	public void verifyUserCanAddAddress(String name,String mobileno,String pincode,String locality) throws EncryptedDocumentException, IOException, InterruptedException {

		HomePages hm = new HomePages(driver);

		hm.moveToProfilepage();

		ProfilePage pp =  new ProfilePage(driver);
		Thread.sleep(2000);
		pp.clickOnManageAddress();
		pp.clickOnAddAddress();
		Thread.sleep(2000);
		
		List <String> datalist = new ArrayList();
		
		datalist.add(name);
		datalist.add(mobileno);
		datalist.add(pincode);
		datalist.add(locality);
		
		pp.saveAddress(datalist);
		pp.addAddressLine();
		pp.selectRadioButton();
		pp.finallySaveAddress();
		
		test.log(LogStatus.FAIL, "User add address");

	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
	@AfterClass
	public void afterClass() {
		
		report.endTest(test);
		report.flush();
	}


}
