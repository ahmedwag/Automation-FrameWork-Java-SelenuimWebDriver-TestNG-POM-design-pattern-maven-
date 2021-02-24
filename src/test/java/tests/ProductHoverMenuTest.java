package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.PageHomeObject;

public class ProductHoverMenuTest extends TestBase
{
	PageHomeObject homeObject ; 
	
	@Test
	public void UserCanSelectSubCategoryFromMainMenu() 
	{
		homeObject = new PageHomeObject(driver); 
		homeObject.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
}
