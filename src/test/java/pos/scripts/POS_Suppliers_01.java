package pos.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import pos.pages.HomePage;
import pos.pages.LoginPage;

public class POS_Suppliers_01 extends BaseTest
{

	@Test(priority = 5,groups={"Suppliers"})
	public void testPOS_Suppliers_01_Step1()
	{
		//Suppliers icon should be present as 4th icon
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName("admin");
		loginPage.setPassword("pointofsale");
		loginPage.clickGoButton();
		HomePage homePage=new HomePage(driver);
		boolean result = homePage.verifyMenuElementByPosition(driver, 4, "Suppliers");
		Assert.assertTrue(result);
	}
	
}
