package com.hms.GenericUtility;

import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.hms.Objectrepository.AdminDashboardPage;
import com.hms.Objectrepository.AdminLoginpage;
import com.hms.Objectrepository.Mainloginpage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public DatabaseUtility dlib = new DatabaseUtility();
	public ExcelUtility elib = new ExcelUtility();
	public FileUtility flib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverutility wlib = new WebDriverutility();
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws Throwable 
	{
		dlib.connectionToDB();
		System.out.println("----Connect to Database----");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)

		public void  config_BC() throws Throwable
		{
	String BROWSER = flib.readDataFromPropertyFile("Browser");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("Firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
	WebDriverManager.edgedriver().setup();
	driver= new EdgeDriver();
	}
	sdriver=driver;
	wlib.maximize(driver);
	System.out.println("----launch the browser---");
	String URL = flib.readDataFromPropertyFile("Url");
	driver.get(URL);
	}
	
//	@BeforeMethod(alwaysRun = true)
//	public void config_BM() throws Throwable
//	{
//		String USERNAME = flib.readDataFromPropertyFile("Username");
//		String PASSWORD = flib.readDataFromPropertyFile("Password");
//		Mainloginpage Mainloginpage=new Mainloginpage(driver);
//		Mainloginpage.adminloginlink(driver);
//		AdminLoginpage LP= new  AdminLoginpage(driver);
//		LP.Login(USERNAME, PASSWORD);
//		System.out.println("----Login to Appl---");
//				
	//}
    //  @AfterMethod(alwaysRun = true)
//	public void config_AM()
//	{
//		AdminDashboardPage Admin = new AdminDashboardPage(driver);
//		Admin.AdminLogout(driver);
//		System.out.println("----logout from Appln---");
//	}
	@AfterClass(alwaysRun = true)
	public void config_AC()
	{
		driver.quit();
		System.out.println("----closed the Browser---");
	}
	@AfterSuite(alwaysRun = true)
	public void config_AS() throws Throwable
	{
		dlib.closeDB();
		System.out.println("----disconnected from Database---");
	}
	


	

	
	

}
