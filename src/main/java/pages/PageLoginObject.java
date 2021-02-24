package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLoginObject extends PageBase {
	
	@FindBy(id = "Email")
	WebElement emailTextArea;
	
	@FindBy(id = "Password")
	WebElement passwordTextArea;
	
	@FindBy(linkText ="Forgot password?")
	WebElement forgotPasswordLink;
	
	@FindBy(id = "RememberMe")
	WebElement rememberMeCheckBox;
	
	@FindBy(css = "input.button-1.login-button")
	WebElement loginButton;

	public PageLoginObject(WebDriver driver) {
		super(driver);
		
	}
	
	public void userLogin(String email ,String password) {
		
		sendText(emailTextArea,email);
		sendText(passwordTextArea,password);
		clickButton(loginButton);
		
	}
	
public void userLoginWithRememberMe(String email ,String password) {
		
		sendText(emailTextArea,email);
		sendText(passwordTextArea,password);
		selectCheckBox(rememberMeCheckBox);
		clickButton(loginButton);
		
	}
	
	
	public void forgetPassword() {
		clickHyperLink(forgotPasswordLink);
	}

}
