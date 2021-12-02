package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.genericmethod;

public class LeadPage extends HeaderPage {
	
	private WebDriver driver ;
	private ExtentTest logger;
	

	public LeadPage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="salutationtype")
	WebElement salutationtype ;
	
	@FindBy(name="firstname")
	WebElement fname ;
	
	@FindBy(name="lastname")
	WebElement lname ;
	
	@FindBy(name="company")
	WebElement company ;
	
	@FindBy(name="button")
	WebElement savebtn ;
	
	@FindBy(xpath="//td[contains(text(),'Last Name')]")
	WebElement lastnametext;
	
	@FindBy(name="Edit")
	WebElement editbtn;
	
	
	
	public void CreateLeadWithMandatoryField(String lastname , String cmpn)
	{
		genericmethod.entervalue(driver, lname, lastname,logger);
		genericmethod.entervalue(driver, company, cmpn,logger);
		genericmethod.clickelement(driver, savebtn,logger);
	}
	
	public void VerifyLastNametext()
	{
		genericmethod.CheckDisplay(driver, lastnametext, logger);
	}
	
	public void verifyEditButton()
	{
		genericmethod.CheckDisplay(driver, editbtn, logger);
	}
	
}
