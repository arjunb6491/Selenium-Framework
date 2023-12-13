package XpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bookmyshow {
	@Test
	public void bookmyshow()
	
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();		
		driver.get("https://in.bookmyshow.com/explore/home/bengaluru");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

}
