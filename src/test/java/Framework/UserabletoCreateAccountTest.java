package Framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.hms.GenericUtility.ExcelUtility;
import com.hms.GenericUtility.FileUtility;
import com.hms.GenericUtility.JavaUtility;
import com.hms.GenericUtility.WebDriverutility;
import com.hms.Objectrepository.Mainloginpage;
import com.hms.Objectrepository.PatientRegistrationPage;
import com.hms.Objectrepository.UserLoginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserabletoCreateAccountTest {

	public static void main(String[] args) throws Throwable {
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverutility wlib=new WebDriverutility();
		int random = jlib.getRandomNo();
	
//		Random ran=new Random();
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
//		String Fullname = book.getSheet("Patients3").getRow(0).getCell(1).getStringCellValue();
//		String Address = book.getSheet("Patients3").getRow(1).getCell(1).getStringCellValue()+random;
//		String City = book.getSheet("Patients3").getRow(2).getCell(1).getStringCellValue()+random;
//		String Email = book.getSheet("Patients3").getRow(3).getCell(1).getStringCellValue()+random;
//		String Password = book.getSheet("Patients3").getRow(4).getCell(1).getStringCellValue();
//		String ReEnter = book.getSheet("Patients3").getRow(5).getCell(1).getStringCellValue();
//		
		String Fullname	=elib.readDataFromExcel("Patients3", 0, 1);
		String Address	=elib.readDataFromExcel("Patients3", 1, 1)+random;
		 String City	=elib.readDataFromExcel("Patients3", 2, 1)+random;
		String Email	=elib.readDataFromExcel("Patients3", 3, 1)+random;
		String Password	=elib.readDataFromExcel("Patients3", 4, 1);
		String ReEnter	=elib.readDataFromExcel("Patients3", 5, 1);
		
		
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
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wlib.waitforpageLoad(driver);
		Mainloginpage ml=new Mainloginpage(driver);
		ml.Mainlogin();
		UserLoginpage Lg=new UserLoginpage(driver);
		Lg.CreateAcclink();
		
		PatientRegistrationPage Pg=new PatientRegistrationPage(driver);
		Pg.Registration(Fullname, Address, City, Email, Password, ReEnter, driver);
		Pg.Accountcreationinfo(driver);
		wlib.accepAlert(driver);
		Lg.Userlogin(Email, Password);
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		driver.findElement(By.linkText("Click Here")).click();
//		driver.findElement(By.xpath("//a[@href='registration.php']")).click();
//		driver.findElement(By.name("full_name")).sendKeys(Fullname);
//		driver.findElement(By.name("address")).sendKeys(Address);
//		driver.findElement(By.name("city")).sendKeys(City);
//		driver.findElement(By.xpath("//label[@for='rg-female']")).click();
//		driver.findElement(By.name("email")).sendKeys(Email);
//		driver.findElement(By.name("password")).sendKeys(Password);
//		driver.findElement(By.name("password_again")).sendKeys(ReEnter);
//		driver.findElement(By.xpath("//label[@for='agree']")).click();
//		driver.findElement(By.name("submit")).click();
//		Thread.sleep(2000);
//		 String ConfirmationMessage=("Successfully Registered. You can login now");
//		String Message = driver.switchTo().alert().getText();
//		if(Message.contains(ConfirmationMessage))
//		{
//			System.out.println("Account is Created Successfully");
//		}
//		else {
//			System.out.println("Account is not Created succesfully");
//		}
//		
//		//driver.switchTo().alert().accept();
//		wlib.accepAlert(driver);
//		driver.findElement(By.linkText("Log-in")).click();
//		driver.findElement(By.name("username")).sendKeys(Email);
//		System.out.println(Email);
//		driver.findElement(By.name("password")).sendKeys(Password);
//		driver.findElement(By.name("submit")).click();
//		driver.close();
	}
}
