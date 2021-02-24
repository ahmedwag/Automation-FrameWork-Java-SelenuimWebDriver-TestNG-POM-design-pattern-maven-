package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageMyAccountObject extends PageBase {

	public PageMyAccountObject(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
    WebElement oldPasswordTxt;
	
    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;
    
    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordTxt;
    
    @FindBy(css = "input.button-1.change-password-button")
    WebElement ChangePasswordBtn;
    
    @FindBy(css = "div.result")
    public WebElement resultLbl;
	
	
	public void openChangePasswordPage() {
		
		clickHyperLink(changePasswordLink);
	}
	
	public void ChangePassword(String oldpassword, String newpassword) {
        sendText(oldPasswordTxt, oldpassword);
        sendText(newPasswordTxt, newpassword);
        sendText(confirmPasswordTxt, newpassword);
        clickButton(ChangePasswordBtn);
    }

}
