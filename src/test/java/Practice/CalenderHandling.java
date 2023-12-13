package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.navigate().refresh();
		//.manage().window().maximize();
		driver.findElement(By.id("departure")).click();
		//driver.findElement(By.xpath("//div[text()='July 2023']/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()='26']")).click();
		
		

	}

}
