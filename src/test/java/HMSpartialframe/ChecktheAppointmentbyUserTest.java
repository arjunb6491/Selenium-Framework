package HMSpartialframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.hms.GenericUtility.ExcelUtility;
import com.hms.GenericUtility.FileUtility;
import com.hms.GenericUtility.JavaUtility;
import com.hms.GenericUtility.WebDriverutility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChecktheAppointmentbyUserTest {

	public static void main(String[] args) throws Throwable {
	//	DatabaseUtility dlib=new DatabaseUtility();
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib =new JavaUtility();
		WebDriverutility wlib = new WebDriverutility();
		int random = jlib.getRandomNo();
		
		
//	     Random ran=new Random();
//		int random = ran.nextInt(500);
//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
//		Properties p= new Properties();
//		p.load(fis);
//		String BROWSER = p.getProperty("Browser");
//		String URL = p.getProperty("Url");
//		String USERNAME = p.getProperty("Username");
//		String PASSWORD = p.getProperty("Password");
		String BROWSER	=flib.readDataFromPropertyFile("Browser");
		String URL	=flib.readDataFromPropertyFile("Url");
	//	String USERNAME	=flib.readDataFromPropertyFile("Username");
	//	String PASSWORD	=flib.readDataFromPropertyFile("Password");
	
//		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook book = WorkbookFactory.create(fi);
//		String Fullname = book.getSheet("Patients1").getRow(0).getCell(1).getStringCellValue();
//		String Address = book.getSheet("Patients1").getRow(1).getCell(1).getStringCellValue()+random;
//		String City = book.getSheet("Patients1").getRow(2).getCell(1).getStringCellValue()+random;
//		String Email = book.getSheet("Patients1").getRow(3).getCell(1).getStringCellValue()+random;
//		String Password = book.getSheet("Patients1").getRow(4).getCell(1).getStringCellValue();
//		String Patients1 = book.getSheet("Patients1").getRow(5).getCell(1).getStringCellValue();
		String Fullname	=elib.readDataFromExcel("Patients1", 0, 1);
		String Address	=elib.readDataFromExcel("Patients1", 1, 1)+random;
		String City	=elib.readDataFromExcel("Patients1", 2, 1)+random;
		String Email	=elib.readDataFromExcel("Patients1", 3, 1)+random;
		String Password	=elib.readDataFromExcel("Patients1", 4, 1);
	//	String Patients1	=elib.readDataFromExcel("Patients1", 5, 1);
		
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		driver.get(URL);
		wlib.maximize(driver);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Click Here")).click();
		driver.findElement(By.xpath("//a[@href='registration.php']")).click();
		driver.findElement(By.name("full_name")).sendKeys(Fullname);
		driver.findElement(By.name("address")).sendKeys(Address);
		driver.findElement(By.name("city")).sendKeys(City);
		driver.findElement(By.xpath("//label[@for='rg-female']")).click();
		driver.findElement(By.name("email")).sendKeys(Email);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("password_again")).sendKeys(Password);
		driver.findElement(By.xpath("//label[@for='agree']")).click();
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		 String ConfirmationMessage=("Successfully Registered. You can login now");
		String Message = driver.switchTo().alert().getText();
		if(Message.contains(ConfirmationMessage))
		{
			System.out.println("Rigistration done Successfully");
		}
		else {
			System.out.println("Rigistrion not done succesfully");
		}
		
		//driver.switchTo().alert().accept();
		wlib.accepAlert(driver);
		driver.findElement(By.linkText("Log-in")).click();
		driver.findElement(By.name("username")).sendKeys(Email);
		System.out.println(Email);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("(//a[@href=\"book-appointment.php\"])[2]")).click();
		WebElement ele = driver.findElement(By.name("Doctorspecialization"));
		
		wlib.select("Cardiologist", ele);
//		Select s=new Select(ele);
//		s.selectByVisibleText("Cardiologist");
		WebElement ele1 = driver.findElement(By.name("doctor"));
		
		wlib.select("Nagesh", ele1);
//		Select s1 = new Select(ele1);
//		s1.selectByVisibleText("Nagesh");
		driver.findElement(By.xpath("//input[@name='appdate']")).click();
		driver.findElement(By.xpath("//th[text()='August 2023']/ancestor::div[@class='datepicker-days']/descendant::td/../following-sibling::tr[4]/td[.='5']")).click();
		driver.findElement(By.name("submit")).click();
		String String1 = driver.switchTo().alert().getText();
		String Cof = ("Your appointment successfully booked");
		if(String1.contains(Cof))
		{
			System.out.println("Appointment Booked Successfully");
		}
		else {
			
			System.out.println("not able to book Appointment");
		}
		//driver.switchTo().alert().accept();
		wlib.accepAlert(driver);
		driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		WebElement ele3 = driver.findElement(By.linkText("Log Out"));
		
		wlib.Mousehover(driver, ele3);
//		Actions act=new Actions(driver);
//		act.moveToElement(ele3).click().perform();
		driver.close();
		
		WebDriver driver1;
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver1= new ChromeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver1= new FirefoxDriver();
		}
		driver1.get(URL);
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.findElement(By.linkText("Click Here")).click();
		driver1.findElement(By.name("username")).sendKeys(Email);
		driver1.findElement(By.name("password")).sendKeys(Password);
		driver1.findElement(By.name("submit")).click();
		driver1.findElement(By.xpath("(//a[@href='appointment-history.php'])[2]")).click();
		String Expected = "Cardiologist";
		WebElement ele4 = driver.findElement(By.xpath("//td[ text()='Cardiologist']"));
		String Actual = ele4.getText();
		
		if(Actual.contains(Expected))
		{
			System.out.println("Appointment is Present");
		}
		System.out.println("Appointment is not Present");
	}
}

