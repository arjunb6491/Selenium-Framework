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
import com.hms.Objectrepository.DashboardPage;
import com.hms.Objectrepository.Mainloginpage;
import com.hms.Objectrepository.PatientAppointmentHistorypage;
import com.hms.Objectrepository.PatientRegistrationPage;
import com.hms.Objectrepository.UserLoginFromMainPage;
import com.hms.Objectrepository.UserLoginpage;
import com.hms.Objectrepository.UserbookAppointmentpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChecktheAppointmentbyUserTest extends BaseClass {
	@Test(groups = {"Regression"})

	public void checktheAppointment() throws Throwable {
	
		int random = jlib.getRandomNo();	
		String Fullname	=elib.readDataFromExcel("Patients1", 0, 1);
		String Address	=elib.readDataFromExcel("Patients1", 1, 1)+random;
		String City	=elib.readDataFromExcel("Patients1", 2, 1)+random;
		String Email	=elib.readDataFromExcel("Patients1", 3, 1)+random;
		String Password	=elib.readDataFromExcel("Patients1", 4, 1);
		String ReEnter	=elib.readDataFromExcel("Patients1", 5, 1);
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
		DashboardPage Dg=new DashboardPage(driver);
		Dg.BookAppointment(driver);
		UserbookAppointmentpage Ubk=new UserbookAppointmentpage(driver);
		Ubk.UserbookAppointment("Cardiologist", "Nagesh", driver);
		Ubk.UserbookAppointmentinfo(driver);
		wlib.accepAlert(driver);
		
		Pg.UserLogout(driver);
		Thread.sleep(2000);
		UserLoginFromMainPage ulm=new UserLoginFromMainPage(driver);
		ulm.UserloginfromMainn(driver);
		Lg.Patientloginfrommain(Email, Password);
		PatientAppointmentHistorypage pah=new PatientAppointmentHistorypage(driver);
		pah.PatientAppointmentHistory(driver);
		pah.AppointmentHistoryInfo(driver);
		Pg.UserLogout(driver);
	
	}
}

