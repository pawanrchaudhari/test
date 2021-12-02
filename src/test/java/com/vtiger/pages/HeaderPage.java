package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.genericmethod;

public class HeaderPage {

	private WebDriver driver ;
	private ExtentTest logger;
	
	public HeaderPage (WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Leads")
	WebElement lead;
	
	@FindBy(linkText="New Lead")
	WebElement NewLead;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	@FindBy(linkText="My Account")
	WebElement MyAccount;
	
	
	
	
	
	public void verifyLogout()
	{
		genericmethod.CheckDisplay(driver, logout, logger);
	}
	public void clicklogout()
	{
		genericmethod.clickelement(driver, logout,logger);
	}
	
	public void clicklead ()
	{
		genericmethod.clickelement(driver, lead,logger);
	}
	
	public void clickNewLead()
	{
		genericmethod.clickelement(driver, NewLead,logger);
	}
	
	public void clickMyAccount()
	
	{
		genericmethod.clickelement(driver, MyAccount,logger);
	}
	
	
}
