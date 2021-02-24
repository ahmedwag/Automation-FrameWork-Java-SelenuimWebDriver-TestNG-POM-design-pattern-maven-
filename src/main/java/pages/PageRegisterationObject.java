package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageRegisterationObject extends PageBase {
	
	
	
	

	public PageRegisterationObject(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "gender-male")
	WebElement maleRadioButton;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTextArea;
	
	@FindBy(id = "LastName")
	WebElement LastNameTextArea;
	/*
	@FindBy(name = "DateOfBirthDay")
	WebElement dateOfBirthDay;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement dateOfBirthMonth;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement dateOfBirthYear;
	*/
	@FindBy(id = "Email")
	WebElement emailTextArea;
	
	@FindBy(id = "Password")
	WebElement passwordTextArea;
	
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPasswordTextArea; 
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	@FindBy(id = "Email-error")
	WebElement emailErrorMassage;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public WebElement logoutLink; 
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement myAccountLink;
	
	@FindBy(css="div.result")
	public WebElement successMessage ; 
	
	
	public void userRegistration(String firstName , String LastName,String email , String password) {
		
		
		
		// as we did in the registration page we will implement it
		// first select the gender
		clickButton(maleRadioButton);
		// write first name
		sendText(firstNameTextArea,firstName);
		// write last name
		sendText(LastNameTextArea,LastName);
		// write the email
		sendText(emailTextArea,email);
		// write the password
		sendText(passwordTextArea,password);
		// write the confirm password
		sendText(ConfirmPasswordTextArea,password);
		// click the registration button
		clickButton(registerButton);
		 
		
	}
	
	public String getEmailErrorMassage() {
		
		return emailErrorMassage.getText();
		
	} 
	
	
	public void UserLogOut() {

		logoutLink.click();
	}
	
	public void openMyAccountPage() {
		clickButton( myAccountLink);
	}
	
	

}
