package tests;

import org.testng.annotations.Test;

import pages.PageHomeObject;
import pages.PageLoginObject;

public class UserLoginTest extends TestBase {
	
	
	PageHomeObject homeObject;
	PageLoginObject loginObject;
	
	
	@Test
	public void userLoginSuccesfully() {
		homeObject = new PageHomeObject(driver);
		homeObject.openLoginPage();
		loginObject = new PageLoginObject(driver);
		loginObject.userLogin("test12345@gmail.com","123456789");
		
	}

}
