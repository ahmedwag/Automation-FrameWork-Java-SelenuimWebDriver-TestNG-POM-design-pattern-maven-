package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
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

	
	public static String downloadPath = System.getProperty("user.dir") + "\\downloads";

	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			String driverPath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver =new ChromeDriver(chromeOption());
		}else if (browserName.equalsIgnoreCase("firefox")) {
			String driverPath = System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver =new FirefoxDriver(firefoxOption());
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
