package FrameworkusingBaseclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.hms.GenericUtility.BaseClass;
import com.hms.GenericUtility.ExcelUtility;
import com.hms.GenericUtility.FileUtility;
import com.hms.GenericUtility.JavaUtility;
import com.hms.GenericUtility.WebDriverutility;
import com.hms.Objectrepository.Mainloginpage;
import com.hms.Objectrepository.PatientRegistrationPage;
import com.hms.Objectrepository.UserLoginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserabletoLoginTest extends BaseClass{
	@Test(groups = {"Smoke"})

	public void Userabletologin() throws Throwable {
		
		int random = jlib.getRandomNo();		
		String Fullname	=elib.readDataFromExcel("Patients4", 0, 1);
		String Address	=elib.readDataFromExcel("Patients4", 1, 1)+random;
		 String City	=elib.readDataFromExcel("Patients4", 2, 1)+random;
		String Email	=elib.readDataFromExcel("Patients4", 3, 1)+random;
		String Password	=elib.readDataFromExcel("Patients4", 4, 1);
		String ReEnter	=elib.readDataFromExcel("Patients4", 5, 1);
		wlib.waitforpageLoad(driver);	
		Mainloginpage ml=new Mainloginpage(driver);
		ml.Mainlogin();
		UserLoginpage Lg=new UserLoginpage(driver);
		Lg.CreateAcclink();
		
		PatientRegistrationPage Pg=new PatientRegistrationPage(driver);
		Pg.Registration(Fullname, Address, City, Email, Password, ReEnter, driver);
		Pg.Rigistrstioninfo(driver);
		wlib.accepAlert(driver);
		Lg.Userlogin(Email, Password);
		Lg.UserloginInfo(driver);
		Pg.UserLogout(driver);
	
	}
}

