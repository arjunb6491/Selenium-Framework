package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakemyTripTestCalender {
	 static String MonthAndYear="Aug 2023";
	 static int date=12;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		act.moveByOffset(40, 40).click().perform();
		driver.findElement(By.xpath("//input[@data-cy='departure']")).click();
	//String actualDate ="//div[text()='July 2023']/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()='"+date+"']";
		String actualDate = "//div[text()='"+MonthAndYear+"']/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()='"+date+"']";
	String nextArrow = "//span[@aria-label='Next Month']";
	for(;;)
		try {
			driver.findElement(By.xpath(actualDate)).click();
			break;
		}
		catch (Exception e) {
			
		}
	driver.findElement(By.xpath(nextArrow)).click();
	
	
		

	}

}
