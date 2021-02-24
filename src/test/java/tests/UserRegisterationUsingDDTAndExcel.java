package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.PageHomeObject;
import pages.PageLoginObject;
import pages.PageRegisterationObject;

public class UserRegisterationUsingDDTAndExcel extends TestBase {
	
	PageHomeObject homeObject;
	PageRegisterationObject registerationobject;
	PageLoginObject loginObject;
	
	
	
	@DataProvider (name = "excelData")
	public static  Object[][] userData() throws IOException{
		
		ExcelReader excelFile = new ExcelReader();
		
			return excelFile.getExcelData();
		
		
	}
	
	
	// firstName = Object [x][0] -> x is vary depend on the row that taken from
	//LastName = Object [x][1] -> x is vary depend on the row that taken from
	// email = Object [x][2] -> x is vary depend on the row that taken from
	//password = Object [x][3] -> x is vary depend on the row that taken from
	@Test (priority = 1,dataProvider = "excelData")
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
	
	
	@Test(dependsOnMethods = {"userCanRegisterSuccesfully"} , enabled = false)
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
