package FrameworkusingBaseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.hms.GenericUtility.BaseClass;
import com.hms.GenericUtility.ExcelUtility;
import com.hms.GenericUtility.FileUtility;
import com.hms.GenericUtility.WebDriverutility;
import com.hms.Objectrepository.Mainloginpage;
import com.hms.Objectrepository.MedicalHistoryPage;
import com.hms.Objectrepository.UserLoginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingParticularMedicalHistoryTest extends BaseClass {
	@Test(groups = {"Regression"})
public void Checkmedicalhistory() throws Throwable {

	
	
	wlib.waitforpageLoad(driver);

	Mainloginpage mainloginpage=new Mainloginpage(driver);
	mainloginpage.userloginlink();
	String Un = elib.readDataFromExcel("Medical", 0, 1);
	String Pwd = elib.readDataFromExcel("Medical", 1, 1);
	UserLoginpage userLoginpage=new UserLoginpage(driver);
	userLoginpage.Patientloginfrommainformedical(Un, Pwd);
	

	driver.findElement(By.xpath("//span[contains(text(),'Medical History')]")).click();
	MedicalHistoryPage medicalHistoryPage = new MedicalHistoryPage(driver);
	medicalHistoryPage.Medical();
	medicalHistoryPage.Medicalinfo(driver);

	//driver.quit();
}}
