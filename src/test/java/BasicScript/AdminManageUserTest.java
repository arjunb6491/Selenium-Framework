package BasicScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminManageUserTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
				p.load(fis);
				String BROWSER = p.getProperty("Browser");
			String URL = p.getProperty("Url");
			String USERNAME = p.getProperty("Username");
			String PASSWORD = p.getProperty("Password");
//			System.out.println(BROWSER);
//			System.out.println(USERNAME);
//			System.out.println(URL);
//			System.out.println(PASSWORD);
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
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.findElement(By.xpath("(//div[@class='button'])[3]")).click();
			driver.findElement(By.xpath("//a[@href='hms/admin']")).click();
			driver.findElement(By.name("username")).sendKeys(USERNAME);
			driver.findElement(By.name("password")).sendKeys(PASSWORD);
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.xpath("//span[.=' Users ']")).click();
			 WebElement Manage = driver.findElement(By.xpath("//span[.=' Manage Users ']"));
			 Manage.click();
		     driver.close();
	
	}
}


