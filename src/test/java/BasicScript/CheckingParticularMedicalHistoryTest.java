package BasicScript;
import java.io.FileInputStream;

import java.util.Properties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckingParticularMedicalHistoryTest {
public static void main(String[] args) throws Exception {
	Properties property = new Properties();
	property.load(new FileInputStream(".\\src\\test\\resources\\CommonData.properties"));
	String BROWSER = property.getProperty("Browser");
	String URL = property.getProperty("Url");
	//String USERNAME = property.getProperty("Username");
//	String PASSWORD = property.getProperty("Password");
	
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
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//domain
//	driver.findElement(By.xpath("//h3[text()='Domain: Health Care']/../descendant :: button")).click();
//	//Switch Window
//	Set<String> winIds = driver.getWindowHandles();
//	for (Iterator iterator = winIds.iterator(); iterator.hasNext();) {
//		String winId = (String) iterator.next();
//		if(driver.switchTo().window(winId).getTitle().contains("Hospital Management system")) {
//			break;
		
				
	
	//Home page
	driver.findElement(By.xpath("//h3[text()='Patients']/../descendant::a[text()='Click Here']")).click();

	driver.findElement(By.name("username")).sendKeys("vikram@gmail.com");
	driver.findElement(By.name("password")).sendKeys("vikram");
	driver.findElement(By.name("submit")).click();
	//Medical History
	driver.findElement(By.xpath("//span[contains(text(),'Medical History')]")).click();
	//Medical History list
	String serialNo = "1.";
	driver.findElement(By.xpath("//td[text()='"+serialNo+"']/../descendant :: i[@class='fa fa-eye']")).click();
	//Detail view of Medical history and Validate TC
	String expectedResult = "Users | Medical History";
	String actualResult = driver.findElement(By.xpath("//h1[text()='Users | Medical History']")).getText();
	if(actualResult.equalsIgnoreCase(expectedResult)) {
		System.out.println("Pass: Medical History page is displaying");
	}else {
		System.out.println("Fail: Medical History page is not displaying");
	}
	driver.quit();
}}
