package com.vtiger.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class genericmethod {
	
	public static void entervalue (WebDriver driver , WebElement elm , String data,ExtentTest logger)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();
			elm.sendKeys(data);
			if(elm.getAttribute("value").equals(data))
			{
				logger.pass(data+"entered successfully within textbox.");
			}
			else 
			{
				logger.pass(data+"did not entered within textbox.");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Error captured="+e.getMessage());
		}
	}
	
	public static void clickelement (WebDriver driver , WebElement elm,ExtentTest logger)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			elm.click();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void CheckDisplay(WebDriver driver , WebElement elm,ExtentTest logger)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.isDisplayed();
			logger.pass("Element displayed successfully.");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Element not found"+e.getMessage());
		}
	}
	
	public static void selectbytext (WebDriver driver , WebElement elm , String data,ExtentTest logger)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeSelected(elm));
			Select s= new Select(elm);
			s.selectByVisibleText(data);
			if(s.getFirstSelectedOption().getText().equals(data))
			{
				logger.pass(data+"selected with in dropdown.");
			}
			else
			{
				logger.fail(data+"did not select within dropdown.");
			}
				
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			logger.fail("Error captured :"+e.getMessage());
		}
	}

}
