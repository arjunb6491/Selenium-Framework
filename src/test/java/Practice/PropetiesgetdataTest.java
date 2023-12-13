package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropetiesgetdataTest {

	public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("src\\test\\resources\\CommonData.properties");
	Properties p = new Properties();
	p.load(fis);
	String URL = p.getProperty("url");
	String BROWSER = p.getProperty("Browser");
	String Un = p.getProperty("UN");
	String PW = p.getProperty("pwd");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("username")).sendKeys(Un);
	driver.findElement(By.name("password")).sendKeys(PW);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	

	}

}
