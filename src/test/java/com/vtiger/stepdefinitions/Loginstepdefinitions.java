package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginstepdefinitions extends BaseTest {
	public LoginPage lp;
	public HomePage hp;
	
	@Given("^user navigate to url \"([^\"]*)\" on chrome$")
	public void user_navigate_to_url_on_chrome(String url) throws Throwable {
		
		/*WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();*/
		
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

	@And("^click on Login button$")
	public void click_on_Login_button() throws Throwable {
	  // driver.findElement(By.name("Login")).click();
		lp.clickLogin();
	   
	}
	
	@Then("^user should be landed on homepage$")
	public void user_should_be_landed_on_homepage() throws Throwable {
       //driver.findElement(By.xpath("//a[@class=\"currentTab\"and text()='Home']")).isDisplayed();
       hp.verifyHomeTab();
	}
	   

	@And("^Logout link should be appear$")
	public void logout_link_should_be_appear() throws Throwable {
		//driver.findElement(By.linkText("Logout")).click();
		hp.verifyLogout();
	   
	}
	
	@Then("^error message should be appear$")
	public void error_message_should_be_appear() throws Throwable {
		
		lp.verifyErrorMsg();
	}
	
	@When("^user enters invalid userid and password$")
	public void user_enters_invalid_userid_and_password() throws Throwable {
		//driver.findElement(By.name("user_name")).sendKeys("admin123");
		//driver.findElement(By.name("user_password")).sendKeys("admin123");
		lp.login("admin123", "admin123");
	}
	@When("^user enters invalid userid as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_invalid_userid_as_and_password_as(String userid, String password) throws Throwable {
	   // driver.findElement(By.name("user_name")).sendKeys(userid);
	    //driver.findElement(By.name("user_password")).sendKeys(password);
		lp.login(userid, password);
	}
	
	@And("^Close the browser$")
	public void Close_the_browser() throws Throwable {
		extent.flush();
	    driver.quit();
		
	}
}
