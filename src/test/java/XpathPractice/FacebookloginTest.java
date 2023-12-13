package XpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookloginTest {
	@Test
	public void facebook()
	{
		//String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
	   String USERNAME = System.getProperty("username");
	  String PASSWORD = System.getProperty("password");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys(USERNAME);
		driver.findElement(By.name("pass")).sendKeys(PASSWORD);
		System.out.println(USERNAME+"  "+PASSWORD);
	}
	
	
	
}

