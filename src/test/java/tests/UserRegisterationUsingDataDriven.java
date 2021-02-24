package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.PageHomeObject;
import pages.PageLoginObject;
import pages.PageRegisterationObject;

public class UserRegisterationUsingDataDriven extends TestBase {
	
	PageHomeObject homeObject;
	PageRegisterationObject registerationobject;
	PageLoginObject loginObject;
	
	
	
	@DataProvider (name = "testData")
	public static  Object[][] userData(){
		
		return new Object[][] {
			{"ahmed","wageh","testxxxx@gmail.com","123456"},
			{"test","test1","test1234@gmail.com","12345678"}};
		
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
	
	@Test(enabled = false)
	public void userRegisterInvalidEmail() {
		homeObject = new PageHomeObject(driver);
		homeObject.openRegistrationPage();
		registerationobject = new PageRegisterationObject(driver);
		registerationobject.userRegistration("ahmed","wag","test@","123456789");
		Assert.assertEquals("Wrong email",registerationobject.getEmailErrorMassage());
		
	}
	
	
	@Test(dependsOnMethods = {"userCanRegisterSuccesfully"})
	public void userCanLogOut() {
		
		registerationobject = new PageRegisterationObject(driver);
		registerationobject.UserLogOut();
		
	}
	
	@Test(dependsOnMethods = {"userCanLogOut"} , enabled = false)
	public void registerdUserCanLogIn() {
		
		homeObject.openLoginPage();
		loginObject = new PageLoginObject(driver);
		loginObject.userLogin("test72@gmail.com","123456789");
		Assert.assertEquals("Log out",registerationobject.logoutLink.getText());
		registerationobject.UserLogOut();
	}
	
	
	

	

}
