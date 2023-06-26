package generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebUtil {

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
	
	public static void verifyPageByTitle(WebDriver driver,String expectedTitle,String page)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		try 
		{
			wait.until(ExpectedConditions.titleContains(expectedTitle));
			System.out.println("Pass:"+page+ " is displayed");
		}
		catch (Exception e) 
		{
			System.err.println("FAIL:"+page+ " is NOT displayed");
		}
		
	}
	
	public static void verifyPageByURL(WebDriver driver,String expectedURL,String page)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		try 
		{
			wait.until(ExpectedConditions.urlContains(expectedURL));
			System.out.println("Pass:"+page+ " is displayed");
		}
		catch (Exception e) 
		{
			System.err.println("FAIL:"+page+ " is NOT displayed");
		}
	}
	
	public static void verifyPageByElement(WebDriver driver,String xpath,String page)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			System.out.println("Pass:"+page+ " is displayed");
		}
		catch (Exception e) 
		{
			System.err.println("FAIL:"+page+ " is NOT displayed");
		}
	}
	
}
