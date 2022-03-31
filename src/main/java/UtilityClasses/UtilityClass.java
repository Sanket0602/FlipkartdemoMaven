package UtilityClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {

	public static void implicitWait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public static void explicitwait(WebDriver driver,WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));

		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void moveToElement(WebDriver driver,WebElement element1,WebElement element2) throws InterruptedException {

		Actions act = new Actions(driver);

		Thread.sleep(5000);
		act.moveToElement(element1).perform();

		act.moveToElement(element2).click().build().perform();

	}

	public static List<String> addAddressFromExcel(int firstrow1 ,int lastrow1) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream("src\\main\\resources\\ExcelSheet\\parameterization.xlsx");

		Sheet Workbook1 = WorkbookFactory.create(file).getSheet("Sheet2");

		List<String> datalist = new ArrayList<String>();  //

		for(int i=firstrow1; i<=lastrow1; i++) {  //get data from excel

			String data;

			try {

				data =	Workbook1.getRow(i).getCell(1).getStringCellValue();

				datalist.add(data);

			}catch(Exception e) {

				double data1 =	(double) Workbook1.getRow(i).getCell(1).getNumericCellValue(); 

				data = String.valueOf(data1);

				datalist.add(data);    
			}
		}

		return datalist;
	}
	
	public  String getConfigData(String key) throws IOException {
		
		FileInputStream configfile = new FileInputStream("Configuration\\config.properties");
		
		Properties prop = new Properties();
	
		prop.load(configfile);
		
	return prop.getProperty(key);
	
	}

}
