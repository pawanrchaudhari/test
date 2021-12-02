package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.common.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver ;
	public static Properties prop ;
	public static List<List<String>> data;
	public static ExtentHtmlReporter htmlReporter ;
	public static ExtentReports extent;
	public static ExtentTest logger ;
	
	
	public void launchApp () throws Exception
	
	{
		ReadProperties();
		data=ReadExcelData();
		createreport();
		if(prop.getProperty("Browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (prop.getProperty("Browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(prop.getProperty("Browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
		String s = "10" ;
		int n = Integer.parseInt(s);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(n));
	}
	
	public void closeApp ()
	
	{
	    driver.quit();	
	}
	
	public void ReadProperties() throws Exception
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/vtiger/common/config.properties");
		prop.load(fis);
	}
	
	public List<List<String>> ReadExcelData()
	{
		Xls_Reader xr = new Xls_Reader(System.getProperty("user.dir")+prop.getProperty("TestDataPath"));
		int rows = xr.getRowCount("Sheet1");
		int colums = xr.getColumnCount("Sheet1");
		List<List<String>> rowlist=new ArrayList<List<String>>();
		for (int i=2;i<=rows;i++)
		{
			List<String>collist= new ArrayList<String>();
			for(int j=0;j<colums;j++)
			{
				String data = xr.getCellData("Sheet1", j, i).trim();
				collist.add(data);
			}
			rowlist.add(collist);
		}
		return rowlist;
	}
	
	public void createreport()
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/ExtentReport"+str+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Admin");
		htmlReporter.config().setDocumentTitle("Title Of The Report Comes Here");
		htmlReporter.config().setReportName("Name Of The Report Comes Here");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	
}
