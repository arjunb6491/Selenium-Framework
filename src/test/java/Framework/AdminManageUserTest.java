package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hms.GenericUtility.FileUtility;
import com.hms.GenericUtility.WebDriverutility;
import com.hms.Objectrepository.AdminDashboardPage;
import com.hms.Objectrepository.AdminLoginpage;
import com.hms.Objectrepository.Mainloginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminManageUserTest {

	public static void main(String[] args) throws Throwable {
		FileUtility flib= new FileUtility();
		WebDriverutility wlib = new WebDriverutility();

		
			String BROWSER	=flib.readDataFromPropertyFile("Browser");
			String URL	=flib.readDataFromPropertyFile("Url");
			String USERNAME	=flib.readDataFromPropertyFile("Username");
			String PASSWORD	=flib.readDataFromPropertyFile("Password");
		
			WebDriver driver;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			driver.get(URL);
			wlib.maximize(driver);
			wlib.waitforpageLoad(driver);	
			driver.manage().window().maximize();
			Mainloginpage Mainloginpage=new Mainloginpage(driver);
			Mainloginpage.adminloginlink(driver);
			AdminLoginpage adminLoginpage= new AdminLoginpage(driver);
			adminLoginpage.Login(USERNAME, PASSWORD);
			AdminDashboardPage adminDashboardPage=new AdminDashboardPage(driver);
			adminDashboardPage.AdminDashboard();
			driver.close();
	
	}
}


