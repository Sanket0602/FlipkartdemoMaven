package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass1 {

	public static WebDriver getBrowser(String a) throws InterruptedException {

		if (a.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browser\\geckodriver1.exe");

			WebDriver driver = new FirefoxDriver();

			driver.get("https://www.flipkart.com/");
			Thread.sleep(3000);

			driver.manage().window().maximize();

			return driver;


		}
		else {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browser\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			driver.get("https://www.flipkart.com/");
			Thread.sleep(3000);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			return driver;

		}

	}

}



