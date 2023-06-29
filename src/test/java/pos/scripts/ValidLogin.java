package pos.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pos.pages.HomePage;
import pos.pages.LoginPage;

public class ValidLogin extends BaseTest{
	@Test(priority=1 , groups= {"login","smoke"})
	
	public void  testValidLogin() 
	{
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.setUserName("admin");
	    loginPage.setPassword("pointofsale");
	    loginPage.clickGoButton();
	    
	    HomePage homePage = new HomePage(driver);
	    boolean result=homePage.verifyHomePageIsDisplayed(wait);
	    
	    
	    Assert.assertTrue(result);
	    Reporter.log("Home Page Is Displayed ",true);
	    
	    
	    
		
	}
	
	
	

}
