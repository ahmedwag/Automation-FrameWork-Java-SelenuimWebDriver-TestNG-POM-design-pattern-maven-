package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.PageHomeObject;
import pages.PageLoginObject;
import pages.PageRegisterationObject;

public class UserRegisterationTest extends TestBase {
	
	PageHomeObject homeObject;
	PageRegisterationObject registerationobject;
	PageLoginObject loginObject;
	
	@Test (priority = 1)
	public void userCanRegisterSuccesfully() {
		
		homeObject = new PageHomeObject(driver);
		homeObject.openRegistrationPage();
		registerationobject = new PageRegisterationObject(driver);
		registerationobject.userRegistration("ahmed","wag","dfe452@gmail.com","123456789");
		registerationobject.UserLogOut();
		
		
		
	}
	
	@Test(enabled = false)
	public void userRegisterInvalidEmail() {
		homeObject = new PageHomeObject(driver);
		homeObject.openRegistrationPage();
		registerationobject = new PageRegisterationObject(driver);
		registerationobject.userRegistration("ahmed","wag","dfe452@gmail.com","123456789");
		Assert.assertEquals("Wrong email",registerationobject.getEmailErrorMassage());
		
	}
	
	
	@Test(dependsOnMethods = {"userCanRegisterSuccesfully"})
	public void userCanLogOut() {
		
		registerationobject = new PageRegisterationObject(driver);
		registerationobject.UserLogOut();
		
	}
	
	@Test(dependsOnMethods = {"userCanLogOut"})
	public void registerdUserCanLogIn() {
		
		homeObject.openLoginPage();
		loginObject = new PageLoginObject(driver);
		loginObject.userLogin("dfe452@gmail.com","123456789");
		Assert.assertEquals("Log out",registerationobject.logoutLink.getText());
	}
	
	
	

	

}
