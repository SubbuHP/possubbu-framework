package pos.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.WebUtil;

public class LoginPage {

	@FindBy(xpath="//*[starts-with(@class,'logo')]")
	private WebElement logo;
	
	@FindBy(xpath="//h3[text()='Welcome to OSPOS!']")
	private WebElement welcomeMsg;
	
	@FindBy(id="input-username")
	private WebElement unTB;
	
	@FindBy(id="input-password")
	private WebElement pwTB;
	
	@FindBy(name="login-button")
	private WebElement goBTN;
	
	@FindBy(xpath="//span[text()='Open Source Point of Sale']")
	private WebElement footer;

	@FindBy(xpath="//div[text()='Invalid username and/or password.']")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void clickGoButton()
	{
		goBTN.click();
	}
	
	public boolean verfyEleemntsArePresent(WebDriverWait wait)
	{
		boolean logoPresent= WebUtil.verifyElementIsPresent(wait, logo,"logo");
	
		boolean welcomePresent= WebUtil.verifyElementIsPresent(wait, welcomeMsg,"Welcome Message");
		
		boolean unPresent= WebUtil.verifyElementIsPresent(wait, unTB,"UserName textbox");
		
		boolean pwPresent= WebUtil.verifyElementIsPresent(wait, pwTB,"Password textbox");
		
		boolean goPresent= WebUtil.verifyElementIsPresent(wait, goBTN,"Go button");
	
		boolean footerPresent= WebUtil.verifyElementIsPresent(wait, footer,"Footer Message");
		
		boolean finalResult=logoPresent && unPresent && pwPresent && goPresent && welcomePresent && footerPresent;
		
		return finalResult;
		
	}
	
	public boolean verifyLoginPageIsDisplayed(WebDriverWait wait)
	{
		return WebUtil.verifyPageByElement(wait, goBTN, "Login Page");
	}
	
	public boolean verfyErrMsIsPresent(WebDriverWait wait)
	{
		return WebUtil.verifyElementIsPresent(wait, errMsg,"Err Msg");
		
	}
	
}
