package stepsDefention;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PageHomeObject;
import pages.PageRegisterationObject;
import tests.TestBase;

public class UserRegisteration extends TestBase {
	
	 PageHomeObject homeObject;
	 PageRegisterationObject registerationObject;
	
	@Given("user in home page")
	public void user_in_home_page() {
	    
		homeObject =new PageHomeObject(driver);
		homeObject.openRegistrationPage();
	}
	@When("user click on register link")
	public void user_click_on_register_link() {
		
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	    
	}
	
	@When("user entered {string},{string},{string},{string}")
	public void user_entered(String string, String string2, String string3, String string4) {
	    
		registerationObject =new PageRegisterationObject(driver);
		registerationObject.userRegistration(string,string2,string3,string4);
	    
	}
	
	@Then("registration page appear massage says Your registration completed")
	public void registration_page_appear_massage_says_your_registration_completed() {
		
		registerationObject =new PageRegisterationObject(driver);
		Assert.assertEquals(registerationObject.successMessage.getText(),"Your registration completed"); 
		registerationObject.UserLogOut();
	    
	}


}
