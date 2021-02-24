package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.PageHomeObject;
import pages.PageLoginObject;
import pages.PageRegisterationObject;

public class UserRegisterationTestDDTWithJavaFaker extends TestBase {
	
	PageHomeObject homeObject;
	PageRegisterationObject registerationobject;
	PageLoginObject loginObject;
	
	Faker fakeDate = new Faker();
	String firstName = fakeDate.name().firstName();
	String lastName = fakeDate.name().lastName();
	String email = fakeDate.internet().emailAddress();
	String password = fakeDate.number().digits(8).toString();
	
	@Test (priority = 1)
	public void userCanRegisterSuccesfully() {
		
		homeObject = new PageHomeObject(driver);
		homeObject.openRegistrationPage();
		registerationobject = new PageRegisterationObject(driver);
		registerationobject.userRegistration(firstName,lastName,email,password);
		registerationobject.UserLogOut();
		
		
		
	}
	
	
	
	
	@Test(dependsOnMethods = {"userCanRegisterSuccesfully"})
	public void registerdUserCanLogIn() {
		homeObject = new PageHomeObject(driver);
		homeObject.openLoginPage();
		loginObject = new PageLoginObject(driver);
		loginObject.userLogin(email,password);
		Assert.assertEquals("Log out",registerationobject.logoutLink.getText());
	}
	
	
	

	

}
