package Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.hms.GenericUtility.ExcelUtility;
import com.hms.GenericUtility.FileUtility;
import com.hms.GenericUtility.WebDriverutility;
import com.hms.Objectrepository.Mainloginpage;
import com.hms.Objectrepository.MedicalHistoryPage;
import com.hms.Objectrepository.UserLoginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingParticularMedicalHistoryTest {
public static void main(String[] args) throws Throwable {

	FileUtility flib= new FileUtility();
	WebDriverutility wlib = new WebDriverutility();
	ExcelUtility elib= new ExcelUtility();
	String BROWSER = flib.readDataFromPropertyFile("Browser");
	String URL = flib.readDataFromPropertyFile("Url");
	//initialize webdriver
	WebDriver driver = null;
	if (BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}else if(BROWSER.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	//Precondition
	driver.get(URL);
	wlib.maximize(driver);
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

	driver.quit();
}}
