package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utility.HelperClass;

public class TestBase extends AbstractTestNGCucumberTests{
	
	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			String driverPath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver =new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			String driverPath = System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver =new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("http://demo.nopcommerce.com/");
	}

//
	@AfterSuite
	public void stopDriver() {

		driver.quit();
	}
	
	
	@AfterMethod
	public void screenSootOnfaluire(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			System.out.println("faluire");
			System.out.println("Taking screenShoot......");
			HelperClass.takeScreenShoot(driver,result.getName());
			
		}else {
			
		}
		
		
	}
	
	@AfterTest
	public void returnToHomePage() {
		
		driver.navigate().to("http://demo.nopcommerce.com/");
		
	}

}
