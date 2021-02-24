package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import data.CsvReader;
import pages.PageHomeObject;
import pages.PageLoginObject;
import pages.PageRegisterationObject;

public class UserRegisterationUsingDDTAndCSVTest extends TestBase {
	
	PageHomeObject homeObject;
	PageRegisterationObject registerationobject;
	PageLoginObject loginObject;
	
	
	
	@DataProvider (name = "testData")
	public static  Object[][] userData() throws CsvValidationException, IOException{
		
		return CsvReader.readCsvFile("userData",4);
		
	}
	
	
	// firstName = Object [x][0] -> x is vary depend on the row that taken from
	//LastName = Object [x][1] -> x is vary depend on the row that taken from
	// email = Object [x][2] -> x is vary depend on the row that taken from
	//password = Object [x][3] -> x is vary depend on the row that taken from
	@Test (priority = 1,dataProvider = "testData")
	public void userCanRegisterSuccesfully(String firstName,String LastName,String email, String password) {
		
		homeObject = new PageHomeObject(driver);
		homeObject.openRegistrationPage();
		registerationobject = new PageRegisterationObject(driver);
		registerationobject.userRegistration(firstName,LastName,email,password);
		registerationobject.UserLogOut();
		homeObject.openLoginPage();
		loginObject = new PageLoginObject(driver);
		loginObject.userLogin(email,password);
		Assert.assertEquals("Log out",registerationobject.logoutLink.getText());
		registerationobject.UserLogOut();
		
		
		
	}
	
	
	

	

}
