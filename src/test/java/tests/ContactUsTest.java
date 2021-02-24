package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.PageHomeObject;

public class ContactUsTest extends TestBase
{
	PageHomeObject home;
	ContactUsPage contactPage;

	String email = "test@test.com";
	String fullName = "Test User";
	String enquiry = "Hello Admin , this is for test";

	@Test
	public void UserCanUseContactUs() {
		home = new PageHomeObject(driver);
		home.openContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.ContactUs(fullName, email, enquiry);
		 Assert.assertTrue(contactPage.successMessage.getText()
				 .contains("Your enquiry has been successfully sent to the store owner."));
	}

}
