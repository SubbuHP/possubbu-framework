package generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class WebUtil {

	public static boolean verifyElementText(WebElement element, String expectedText,boolean ignoreCase,boolean partialMatch)
	{
		String actualText=element.getText();
		Reporter.log("Expected Text:"+expectedText,true);
		Reporter.log("Actual Text:"+actualText,true);
		
		if(ignoreCase)
		{
			actualText=actualText.toLowerCase();
			expectedText=expectedText.toLowerCase();
			Reporter.log("Ignore the Case",true);
		}
		else
		{
			Reporter.log("Do not Ignore the Case",true);
		}
		
		if(partialMatch)
		{
			Reporter.log("partial match",true);
			return actualText.contains(expectedText);
		}
		else
		{
			Reporter.log("Complete match",true);
			return actualText.equals(expectedText);
		}
	}
	
	public static void selectCheckBox(WebDriver driver,String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void verifyCheckBoxIsSelected(WebDriver driver,String xpath)
	{
		boolean selected = driver.findElement(By.xpath(xpath)).isSelected();
		if(selected)
		{
			System.out.println("Pass:Check Box is Selected");
		}
		else
		{
			System.err.println("FAIL: Check Box is Not Selected");
		}
	}
	
	public static boolean verifyPageByTitle(WebDriverWait wait,String expectedTitle,String page)
	{
		try 
		{
			wait.until(ExpectedConditions.titleContains(expectedTitle));
			System.out.println("Pass:"+page+ " is displayed");
			return true;
		}
		catch (Exception e) 
		{
			System.err.println("FAIL:"+page+ " is NOT displayed");
			return false;
		}
		
	}
	
	public static boolean verifyPageByURL(WebDriverWait wait,String expectedURL,String page)
	{

		try 
		{
			wait.until(ExpectedConditions.urlContains(expectedURL));
			System.out.println("Pass:"+page+ " is displayed");
			return true;
		}
		catch (Exception e) 
		{
			System.err.println("FAIL:"+page+ " is NOT displayed");
			return false;
		}
	}
	
	public static boolean verifyPageByElement(WebDriverWait wait,String xpath,String page)
	{

		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			System.out.println("Pass:"+page+ " is displayed");
			return true;
		}
		catch (Exception e) 
		{
			System.err.println("FAIL:"+page+ " is NOT displayed");
			return false;
		}
	}
	
	public static boolean verifyPageByElement(WebDriverWait wait,WebElement element,String page)
	{

		try 
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Pass:"+page+ " is displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("FAIL:"+page+ " is NOT displayed",true);
			return false;
		}
	}
	
	
	public static boolean verifyElementIsPresent(WebDriverWait wait,WebElement element,String... elementName)
	{
		
		String name=elementName.length>0? elementName[0]:"Element";
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Pass: "+name+" is displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("FAIL: "+name+" is NOT displayed",true);
			return false;
		}
	}
}
