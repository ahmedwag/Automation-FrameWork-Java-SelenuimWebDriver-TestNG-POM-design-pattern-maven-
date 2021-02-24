package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.PageHomeObject;
import pages.PageLoginObject;
import pages.PageMyAccountObject;
import pages.PageRegisterationObject;

public class MyAccountTest extends TestBase {
	
	PageHomeObject homeObject;
	PageRegisterationObject registerationobject;
	PageLoginObject loginObject;
	PageMyAccountObject myAccountObject;
	String oldPassword ="123456789";
	String newPassword ="123456";
	String firstName = "Ahmed" ; 
	String lastName = "Wageh" ; 
	String email = "test55555@gmail.com" ; 
	
	@Test (priority = 1)
	public void userCanRegisterSuccesfully() {
		
		homeObject = new PageHomeObject(driver);
		homeObject.openRegistrationPage();
		registerationobject = new PageRegisterationObject(driver);
		registerationobject.userRegistration(firstName,lastName,email,oldPassword);
		Assert.assertTrue(registerationobject.successMessage.getText().contains("Your registration completed"));
			
	}
	
	
	@Test(dependsOnMethods = {"userCanRegisterSuccesfully"})
	public void userCanChangePasswordSuccessfully() {
		
        registerationobject = new PageRegisterationObject(driver);
        registerationobject.openMyAccountPage();
		myAccountObject = new PageMyAccountObject(driver);
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertEquals("Password was changed",myAccountObject.resultLbl.getText());
		
	}
	
	@Test(dependsOnMethods = {"userCanChangePasswordSuccessfully"})
	public void userCanLogOut() {
		
		registerationobject = new PageRegisterationObject(driver);
		registerationobject.UserLogOut();
		
	}
	
	@Test(dependsOnMethods = {"userCanLogOut"})
	public void registerdUserCanLogIn() {
		
		homeObject.openLoginPage();
		loginObject = new PageLoginObject(driver);
		loginObject.userLogin(email,newPassword);
		Assert.assertEquals("Log out",registerationobject.logoutLink.getText());
	}
	
	
}
