package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.PageHomeObject;
import pages.PageLoginObject;
import pages.PageRegisterationObject;

public class UserRegisterationUsingDDTandCSVFile extends TestBase {
	
	PageHomeObject homeObject;
	PageRegisterationObject registerationobject;
	PageLoginObject loginObject;
	String firstName;
	String lastName;
	String email;
	String password;
	
	CSVReader reader;
	
	@Test 
	public void userCanRegisterSuccesfully() throws CsvValidationException, IOException {
		
		String CsvPath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.csv";
		String CsvCell[];
		
			reader =new CSVReader(new FileReader(CsvPath));
			CsvCell = reader.readNext();
		while(CsvCell != null) {
			
			firstName = CsvCell[0];
			lastName = CsvCell[1];
			email = CsvCell[2];
			password = CsvCell[3];
			CsvCell = reader.readNext();
			
			homeObject = new PageHomeObject(driver);
			homeObject.openRegistrationPage();
			registerationobject = new PageRegisterationObject(driver);
			registerationobject.userRegistration(firstName,lastName,email,password);
			registerationobject.UserLogOut();
			homeObject.openLoginPage();
			loginObject = new PageLoginObject(driver);
			loginObject.userLogin(email,password);
			Assert.assertEquals("Log out",registerationobject.logoutLink.getText());
			registerationobject.UserLogOut();
		}
		
		
		
		
	}
	
	
	
	

	

}
