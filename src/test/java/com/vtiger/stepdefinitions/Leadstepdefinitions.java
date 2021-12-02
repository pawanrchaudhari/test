package com.vtiger.stepdefinitions;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Leadstepdefinitions extends BaseTest {
	//public LoginPage lp;
	public HomePage hp;
	public LeadPage ldp;
	
	/*@Given("^user navigate to url \"([^\"]*)\" on chrome$")
	public void user_navigate_to_url_on_chrome(String url) throws Throwable {
		
	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		launchApp();
		logger = extent.createTest("Login Feature");
		lp= new LoginPage(driver,logger);
		hp= new HomePage(driver,logger);
	 
	}

	@Then("^login page should be appear$")
	public void login_page_should_be_appear() throws Throwable {
		//driver.findElement(By.xpath("//strong[text()='vtiger CRM Add-ons']")).isDisplayed();
		
		lp.VerifyLoginPage();
	  
	}
	
	@When("^user enters valid userid and password$")
	public void user_enters_valid_userid_and_password() throws Throwable {
	   //driver.findElement(By.name("user_name")).sendKeys("admin");
	   //driver.findElement(By.name("user_password")).sendKeys("admin");
		
		lp.login("admin", "admin");
	}

	@And("^click Login button$")
	public void click_Login_button() throws Throwable {
	 	
		lp.clickLogin();
	}
	
	@Then("^user should be landed on homepage$")
	public void user_should_be_landed_on_homepage() throws Throwable {
	
		
		hp.verifyHomeTab();
	}
	*/

	@When("^user click on New Lead$")
	public void user_click_on_New_Lead() throws Throwable {
		hp=new HomePage(driver,logger);
		hp.clickNewLead();
	}
	
	@Then("^create lead page will be open$")
	public void create_lead_page_will_be_open() throws Throwable {
		
		ldp = new LeadPage(driver,logger);
		ldp.VerifyLastNametext();
	}
	
	@When("^user enters last name and company name and click on save button$")
	public void user_enters_last_name_and_company_name_and_click_on_save_button() throws Throwable {
	  ldp.CreateLeadWithMandatoryField("Chaudhari", "L&T");
			
	}
	
	@Then("^lead should be created successfully$")
	public void lead_should_be_created_successfully() throws Throwable {
		ldp.verifyEditButton();
		
	}
	

}
