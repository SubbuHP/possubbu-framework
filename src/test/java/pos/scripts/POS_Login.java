package pos.scripts;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Excel;
import pos.pages.HomePage;
import pos.pages.LoginPage;

public class POS_Login extends BaseTest
{
 @Test(priority = 1,groups= {"login","smoke"})
 public void testPOS_Login_Step1()
 {
	LoginPage loginPage=new LoginPage(driver);
	boolean finalResult = loginPage.verfyEleemntsArePresent(wait);
	Assert.assertTrue(finalResult);
 }
 
 @Test(priority = 2,groups= {"login","smoke"})
 public void testPOS_Login_Step2()
 {
	LoginPage loginPage=new LoginPage(driver);
	loginPage.setUserName("admin");
	loginPage.setPassword("pointofsale");
	loginPage.clickGoButton();
	HomePage homePage=new  HomePage(driver);
	boolean homePageDisplayed = homePage.verifyHomePageIsDisplayed(wait);
	boolean elementsDisplayed = homePage.verfyElementsArePresent(wait);
	Assert.assertTrue(homePageDisplayed && elementsDisplayed);
 }
 
 @Test(priority = 3,dependsOnMethods = {"testPOS_Login_Step2"}, groups= {"login","smoke"})
 public void testPOS_Login_Step3()
 {
	HomePage homePage=new  HomePage(driver);
	homePage.clickLogout();
	LoginPage loginPage=new LoginPage(driver);
	boolean loginPageDisplayed = loginPage.verifyLoginPageIsDisplayed(wait);
	Assert.assertTrue(loginPageDisplayed);
 }
 
 @DataProvider
 public Iterator<String[]> getData()
 {
	ArrayList<String[]> data = Excel.getSheetDataToList(XL_PATH,"POS_Login");
	return data.iterator();
 }
 
 @Test(dataProvider = "getData", priority = 4, groups= {"login"})
 public void testPOS_Login_Step4(String un,String pw)
 {
	 	LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		loginPage.setPassword(pw);
		loginPage.clickGoButton();
		Assert.assertTrue(loginPage.verfyErrMsIsPresent(wait));
 }
 
}
