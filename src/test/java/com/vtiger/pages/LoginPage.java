package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.genericmethod;

public class LoginPage {
	
	private WebDriver driver ;
	private ExtentTest logger ;
	
	public LoginPage(WebDriver driver , ExtentTest logger)
	
	{
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	WebElement userid ; 
	
	@FindBy(name="user_password")
	WebElement pwd;
	
	@FindBy(name="login_theme")
	WebElement theme ;
	
	@FindBy(name="Login")
	WebElement login;
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
	WebElement logo;
	
	@FindBy(xpath="//font[text()='Key Modules']")
	WebElement txtKeyModule;
	
	@FindBy(xpath="//td[contains(text(),'You must specify a valid username and password.')]")
	WebElement errmsg;
	
	@FindBy(xpath="//strong[text()='vtiger CRM Add-ons']")
	WebElement loginView ;
	
	
	public void login(String userdata , String pwddata )
	{
		genericmethod.entervalue(driver, userid, userdata,logger);
		genericmethod.entervalue(driver, pwd, pwddata,logger);
		//genericmethod.clickelement(driver, login,logger);
	}
	
	public void verifyInvalidlogin(String userdata , String pwddata )
	{
		genericmethod.entervalue(driver, userid, userdata,logger);
		genericmethod.entervalue(driver, pwd, pwddata,logger);
		//genericmethod.clickelement(driver, login,logger);
		//genericmethod.CheckDisplay(driver, errmsg,logger);
	}
	
	public void loginwiththeme(String userdata , String pwddata,String themetext)
	{
		genericmethod.entervalue(driver, userid, userdata,logger);
		genericmethod.entervalue(driver, pwd, pwddata,logger);
		genericmethod.selectbytext(driver, theme, themetext,logger);
		//genericmethod.clickelement(driver, login,logger);
	}
	
	public void verifylogo()
	{
		genericmethod.CheckDisplay(driver, logo,logger);
	}
	
	public void clickLogin()
	{
		genericmethod.clickelement(driver, login,logger);
	}
	
	public void verifyKeyModule()
	{
		genericmethod.CheckDisplay(driver, txtKeyModule,logger);
	}

	public void VerifyLoginPage()
	{
		genericmethod.CheckDisplay(driver, loginView, logger);
	}
	
	public void verifyErrorMsg() 
	{
		genericmethod.CheckDisplay(driver, errmsg, logger);
	}
}
