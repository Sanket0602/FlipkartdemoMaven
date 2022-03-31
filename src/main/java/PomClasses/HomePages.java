package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityClasses.UtilityClass;

public class HomePages extends UtilityClass {

	WebDriver driver;

	@FindBy(xpath="(//div[@class='_1psGvi _3BvnxG'])[1]")
	private WebElement profile;

	@FindBy(xpath="(//div[@class='_3vhnxf'])[1]")
	private WebElement myprofile;


	public HomePages (WebDriver driver) {

		PageFactory.initElements(driver, this);

		this.driver= driver;

	}

	public void moveToProfilepage() throws InterruptedException {

		implicitWait( driver);
		moveToElement(driver,profile,myprofile);
	}


}
