package Practice;

import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.functors.WhileClosure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCalenderinMakemyTrip {
	//String MonthAndYear= "Sepmtember 2023";
	//int date=25;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		//String actualDate="//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"'"];
//		driver.findElement(By.xpath("//div[text()='July 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='25']")).click();
//		driver.findElement(By.xpath("//span[text()='Done']")).click();
		
		while(true)
		try
		{
			//driver.findElement(By.xpath("//div[.='October 2023']/following-sibling::div[2]/div/div[@aria-label='Sun Oct 01 2023']")).click();
			//driver.findElement(By.xpath("//div[text()='October 2023']/../following-sibling::div[2]/div/div[@aria-label='Mon Oct 02 2023']")).click();
			//driver.findElement(By.xpath	("//div[text()='November 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='1']")).click();
			driver.findElement(By.xpath("//div[@aria-label='Thu Nov 09 2023']")).click();
			break;
		}
		catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			//div[text()='October 2023']/../following-sibling::div[2]/div/div[@aria-label='Wed Oct 04 2023']
		}
	
		while(true)
			try {
				driver.findElement(By.xpath("//div[@aria-label='Thu Nov 09 2023']")).click();
				break;
				
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
			}
	
	while(true)
		try
	{
			driver.findElement(By.xpath("  ")).click();
			break;
	}
	catch (Exception e) {
		driver.findElement(By.xpath(" ")).click();
	}

	}

}
