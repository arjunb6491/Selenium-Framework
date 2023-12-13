package HMSpartialframe;

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

public class CreateUserCheckinAdminTest {

	public static void main(String[] args) throws Throwable {
		//DatabaseUtility dLIB=new DatabaseUtility();
		ExcelUtility eLIB=new ExcelUtility();
		FileUtility fLIB =new FileUtility();
		JavaUtility jLIB=new JavaUtility();
		WebDriverutility wLIB=new WebDriverutility();
		
		int random = jLIB.getRandomNo();
//		Random ran=new Random();
//		int random = ran.nextInt(500);
//		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
//		Properties p= new Properties();
//		p.load(fis);
//		String BROWSER = p.getProperty("Browser");
//		String URL = p.getProperty("Url");
//		String USERNAME = p.getProperty("Username");
//		String PASSWORD = p.getProperty("Password");
	      String BROWSER =fLIB.readDataFromPropertyFile("Browser");
	      String URL =fLIB.readDataFromPropertyFile("Url");
	      String USERNAME =fLIB.readDataFromPropertyFile("Username");
	      String PASSWORD =fLIB.readDataFromPropertyFile("Password");
		
	
//		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook book = WorkbookFactory.create(fi);
//		String Fullname = book.getSheet("Patients").getRow(0).getCell(1).getStringCellValue();
//		String Address = book.getSheet("Patients").getRow(1).getCell(1).getStringCellValue()+random;
//		String City = book.getSheet("Patients").getRow(2).getCell(1).getStringCellValue()+random;
//		String Email = book.getSheet("Patients").getRow(3).getCell(1).getStringCellValue()+random;
//		String Password = book.getSheet("Patients").getRow(4).getCell(1).getStringCellValue();
//		String ReEnter = book.getSheet("Patients").getRow(5).getCell(1).getStringCellValue();
		String Fullname	=eLIB.readDataFromExcel("Patients", 0, 1);
		String Address	=eLIB.readDataFromExcel("Patients", 1, 1)+random;
		 String City	=eLIB.readDataFromExcel("Patients", 2, 1)+random;
		String Email	=eLIB.readDataFromExcel("Patients", 3, 1)+random;
		String Password	=eLIB.readDataFromExcel("Patients", 4, 1);
		String ReEnter	=eLIB.readDataFromExcel("Patients", 5, 1);	
		
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
		wLIB.maximize(driver);
		//driver.manage().window().maximize();
		wLIB.waitforpageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Click Here")).click();
		driver.findElement(By.xpath("//a[@href='registration.php']")).click();
		driver.findElement(By.name("full_name")).sendKeys(Fullname);
		driver.findElement(By.name("address")).sendKeys(Address);
		driver.findElement(By.name("city")).sendKeys(City);
		driver.findElement(By.xpath("//label[@for='rg-female']")).click();
		driver.findElement(By.name("email")).sendKeys(Email);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("password_again")).sendKeys(ReEnter);
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
		
	//	driver.switchTo().alert().accept();
		wLIB.accepAlert(driver);
		driver.findElement(By.linkText("Log-in")).click();
		driver.findElement(By.name("username")).sendKeys(Email);
		System.out.println(Email);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("(//a[@href=\"book-appointment.php\"])[2]")).click();
		WebElement ele = driver.findElement(By.name("Doctorspecialization"));
		
		
//		Select s=new Select(ele);
//		s.selectByVisibleText("Cardiologist");
		wLIB.select("Cardiologist", ele);
	
		WebElement ele1 = driver.findElement(By.name("doctor"));
	
//		Select s1 = new Select(ele1);
//		s1.selectByVisibleText("Nagesh");
//		
		wLIB.select("Nagesh", ele1);
		driver.findElement(By.xpath("//input[@name='appdate']")).click();
		driver.findElement(By.xpath("//th[text()='July 2023']/ancestor::div[@class='datepicker-days']/descendant::td/../following-sibling::tr[4]/td[.='31']")).click();
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
	//	driver.switchTo().alert().accept();
		wLIB.accepAlert(driver);
		driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		WebElement ele3 = driver.findElement(By.linkText("Log Out"));
		
		
//		Actions act=new Actions(driver);
//		act.moveToElement(ele3).click().perform();
//		
		wLIB.Mousehover(driver, ele3);
		driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click();
		//driver.findElement(By.xpath("(//td[text()='Shivamma'])[6]"));
		
	//	JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement ele4 = driver.findElement(By.xpath("(//td[text()='Shivamma'])[6]"));
//		Point loc = ele4.getLocation();
//		int x = loc.getX();
//		int y = loc.getY();
//		System.out.println(loc);
//		js.executeScript("window.scrollBy("+x+","+y+")");
//		
		wLIB.scrollAction(driver, ele4);
		String Paname = driver.findElement(By.xpath("(//td[text()='Shivamma'])[6]")).getText();
		
		if(Paname.contains(Fullname))
		{
			System.out.println("Shivamma is Presemt");
		}
		else {
			System.out.println("Shivamma is not Present");
		}
		driver.findElement(By.xpath("//i[@class='ti-angle-down']")).click();
		WebElement ele5 = driver.findElement(By.linkText("Log Out"));
		
		wLIB.Mousehover(driver, ele5);
//		Actions act1=new Actions(driver);
//		act1.moveToElement(ele5).click().perform();
		driver.close();
	
	}

}


