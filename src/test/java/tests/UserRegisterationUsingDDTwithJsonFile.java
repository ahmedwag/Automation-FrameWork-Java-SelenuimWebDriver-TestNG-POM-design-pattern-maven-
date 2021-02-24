package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.PageHomeObject;
import pages.PageLoginObject;
import pages.PageRegisterationObject;

public class UserRegisterationUsingDDTwithJsonFile extends TestBase {
	
	PageHomeObject homeObject;
	PageRegisterationObject registerationobject;
	PageLoginObject loginObject;
	
	
	

	
	
	@Test (priority = 1)
	public void userCanRegisterSuccesfully() throws IOException, ParseException {
		JsonDataReader reader = new JsonDataReader();
		reader.jsonReader();
		homeObject = new PageHomeObject(driver);
		homeObject.openRegistrationPage();
		registerationobject = new PageRegisterationObject(driver);
		registerationobject.userRegistration(reader.firstName,reader.lastName,reader.email,reader.password);
		registerationobject.UserLogOut();
		homeObject.openLoginPage();
		loginObject = new PageLoginObject(driver);
		loginObject.userLogin(reader.email,reader.password);
		Assert.assertEquals("Log out",registerationobject.logoutLink.getText());
		registerationobject.UserLogOut();
		
		
		
	}
	
	
	
	

	

}
