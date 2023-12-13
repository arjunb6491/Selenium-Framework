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
import com.hms.Objectrepository.AdminDashboardPage;
import com.hms.Objectrepository.AdminLoginpage;
import com.hms.Objectrepository.DashboardPage;
import com.hms.Objectrepository.Mainloginpage;
import com.hms.Objectrepository.PatientAppointmentHistorypage;
import com.hms.Objectrepository.PatientRegistrationPage;
import com.hms.Objectrepository.UserLoginpage;
import com.hms.Objectrepository.UserbookAppointmentpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateUserCheckinAdminTest extends BaseClass{
	@Test(groups = {"Regression"})

	public void Createuser() throws Throwable {
		
		int random = jlib.getRandomNo();

	      String USERNAME =flib.readDataFromPropertyFile("Username");
	      String PASSWORD =flib.readDataFromPropertyFile("Password");
			String Fullname	=elib.readDataFromExcel("Patients", 0, 1);
		String Address	=elib.readDataFromExcel("Patients", 1, 1)+random;
		 String City	=elib.readDataFromExcel("Patients", 2, 1)+random;
		String Email	=elib.readDataFromExcel("Patients", 3, 1)+random;
		String Password	=elib.readDataFromExcel("Patients", 4, 1);
		String ReEnter	=elib.readDataFromExcel("Patients", 5, 1);	
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
		ml.adminloginlink(driver);
		AdminLoginpage adl=new AdminLoginpage(driver);
		adl.Login(USERNAME, PASSWORD);
		PatientAppointmentHistorypage patientAppointmentHistorypage=new PatientAppointmentHistorypage(driver);
		patientAppointmentHistorypage.PatientAppointmentHistory(driver);
		patientAppointmentHistorypage.SelectPatientName(driver);
		patientAppointmentHistorypage.AppointmentInfo(driver, Fullname);
		AdminDashboardPage adminDashboardPage=new AdminDashboardPage(driver);
		adminDashboardPage.AdminLogout(driver);
	
	}

}


