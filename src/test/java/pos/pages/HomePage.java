package pos.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import generic.WebUtil;
public class HomePage
{

	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	
	@FindBy(xpath="//h3[text()='Welcome to OSPOS, click a module below to get started.']")
	private WebElement welcomeMsgOSPOS;
	
	@FindBy(xpath="//a[@title='Change Password']")
	private WebElement userName;
	
	@FindBy(xpath="//a[@title='Customers']")
	private WebElement customers;
	
	@FindBy(xpath="//a[@title='Items']")
	private WebElement items;
	
	@FindBy(xpath="//a[@title='Item Kits']")
	private WebElement itemKits;
	
	@FindBy(xpath="//a[@title='Suppliers']")
	private WebElement suppliers;
	
	@FindBy(xpath="//a[@title='Reports']")
	private WebElement reports;
	
	@FindBy(xpath="//a[@title='Receivings']")
	private WebElement receivings;
	
	@FindBy(xpath="//a[@title='Sales']")
	private WebElement sales;
	
	@FindBy(xpath="//a[@title='Gift Cards']")
	private WebElement giftCards;
	
	@FindBy(xpath="//a[@title='Messages']")
	private WebElement messages;
	
	
	@FindBy(xpath="//a[@title='Expenses']")
	private WebElement expenses;
	
	@FindBy(xpath="//a[@title='Cashups']")
	private WebElement cashups;
	
	@FindBy(xpath="//a[@title='Office']")
	private WebElement office;
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyMenuElementByPosition(WebDriver driver,int position,String expectedText)
	{
		Reporter.log("Expected Position:"+position,true);
		String xp="//div[@role='navigation']//ul/li["+position+"]/a";
		WebElement element = driver.findElement(By.xpath(xp));
		
		return WebUtil.verifyElementText(element, expectedText, false, false);//dont ignore the case & complete match
		
	}
	
	public void clickLogout()
	{
		logoutLink.click();
	}
	
	public boolean verifyHomePageIsDisplayed(WebDriverWait wait)
	{
		return WebUtil.verifyPageByURL(wait, "home", "HomePage");
	}
	
	public boolean verfyElementsArePresent(WebDriverWait wait)
	{
		boolean finalResult=false;
		
		boolean logoutPresent= WebUtil.verifyElementIsPresent(wait, logoutLink, "Logout");
		boolean welcomeMsgPresent= WebUtil.verifyElementIsPresent(wait, welcomeMsgOSPOS, "welcome Msg OSPOS");
		boolean userNamePresent= WebUtil.verifyElementIsPresent(wait, userName, "User Name");
		
		boolean customersPresent= WebUtil.verifyElementIsPresent(wait, customers, "Customers");
		boolean itemsPresent= WebUtil.verifyElementIsPresent(wait, items, "Items");
		boolean itemKitsPresent= WebUtil.verifyElementIsPresent(wait, itemKits, "Item Kits");
		boolean suppliersPresent= WebUtil.verifyElementIsPresent(wait, suppliers, "Suppliers");
		boolean reportsPresent= WebUtil.verifyElementIsPresent(wait, reports, "Reports");
		boolean receivingsPresent= WebUtil.verifyElementIsPresent(wait, receivings, "Receivingss");
		boolean salesPresent= WebUtil.verifyElementIsPresent(wait, sales, "Sales");
		boolean giftCardsPresent= WebUtil.verifyElementIsPresent(wait, giftCards, "Gift Cards");
		boolean messagesPresent= WebUtil.verifyElementIsPresent(wait, messages, "Messages");
		boolean expensesPresent= WebUtil.verifyElementIsPresent(wait, expenses, "Expenses");
		boolean cashupsPresent= WebUtil.verifyElementIsPresent(wait, cashups, "Cashups");
		boolean officePresent= WebUtil.verifyElementIsPresent(wait, office, "Office");
		
		
		 finalResult=logoutPresent && welcomeMsgPresent && userNamePresent && customersPresent && receivingsPresent && itemKitsPresent && suppliersPresent && reportsPresent && itemsPresent && salesPresent && giftCardsPresent && messagesPresent && expensesPresent && cashupsPresent && officePresent;
		
	
		return finalResult;
		
	}

	
}