package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.genericmethod;

public class HomePage extends HeaderPage  {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public HomePage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//td[contains(text(),'My Tickets')]")
	WebElement MyTicket;
	
	@FindBy(xpath="//a[@class=\"currentTab\"and text()='Home']")
	WebElement HomeTab;
	
	
	public void verifyMyTicketDashboard()
	{
		genericmethod.CheckDisplay(driver, MyTicket,logger);
	}
	
	public void verifyHomeTab()
	{
		genericmethod.CheckDisplay(driver, HomeTab, logger);
	}
	
	
}
