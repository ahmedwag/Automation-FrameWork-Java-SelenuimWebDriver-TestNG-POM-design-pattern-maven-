package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageHomeObject extends PageBase {
	
	

	public PageHomeObject(WebDriver driver) {
		super(driver);
		
	}
	
	// this anotation related to page factory 
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement registerLink;

	@FindBy(partialLinkText  = "Log in")
	WebElement loginLink;
	
	@FindBy(linkText="Contact us")
	WebElement contactUsLink ; 
	
	@FindBy(id="customerCurrency")
	WebElement currencydrl; 
	
	@FindBy(linkText="Computers")
	WebElement ComputerMenu; 
	
	@FindBy(linkText="Notebooks")
	WebElement NotbooksMenu; 
	
	
	
	
	public void openLoginPage() {
		clickButton(loginLink);
	}
	
	public void openRegistrationPage() {
		clickButton(registerLink);
	}
	
	
public void openContactUsPage() 
	
	{
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	public void changeCurrency() 
	{
		select = new Select(currencydrl); 
		select.selectByVisibleText("Euro");
	}
	
	public void selectNotebooksMenu() 
	{
		action
		.moveToElement(ComputerMenu)
		.moveToElement(NotbooksMenu)
		.click()
		.build()
		.perform();
	}
	
	
	
	
	
	
	
}
