package FrameworkusingBaseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.hms.GenericUtility.BaseClass;
import com.hms.GenericUtility.FileUtility;
import com.hms.GenericUtility.WebDriverutility;
import com.hms.Objectrepository.AdminDashboardPage;
import com.hms.Objectrepository.AdminLoginpage;
import com.hms.Objectrepository.Mainloginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminManageUserTest extends BaseClass{
	@Test(groups = {"Smoke"})

	public void AdminUserTest() throws Throwable {
			String USERNAME	=flib.readDataFromPropertyFile("Username");
			String PASSWORD	=flib.readDataFromPropertyFile("Password");
			wlib.waitforpageLoad(driver);
			Mainloginpage Mainloginpage=new Mainloginpage(driver);
			Mainloginpage.adminloginlink(driver);
			AdminLoginpage adminLoginpage= new AdminLoginpage(driver);
			adminLoginpage.Login(USERNAME, PASSWORD);
			AdminDashboardPage adminDashboardPage=new AdminDashboardPage(driver);
			adminDashboardPage.AdminDashboard();
	}
}


