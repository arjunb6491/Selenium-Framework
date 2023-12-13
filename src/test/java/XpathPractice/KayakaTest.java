package XpathPractice;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakaTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.kayak.co.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//input[@placeholder='To?']")).sendKeys("Chennai");
//		driver.findElement(By.xpath("//span[.='Chennai, Tamil Nadu, India']")).click();
//		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@aria-label='Saturday 26 August, 2023']")).click();
//		driver.findElement(By.xpath("//span[@aria-label='End date calendar input']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@aria-label='Friday 22 September, 2023']")).click();
		
//		//driver.findElement(By.xpath("//div[.='September 2023']/../following-sibling::div/div[@aria-label='Saturday 30 September, 2023']")).click();
//		driver.findElement(By.xpath("//*[name()='svg' and @class='c8LPF-icon']")).click();
//		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='Oihj']/descendant::div[@class='f8F1-price-text']"));
//		
//		for(int i=0;i<=ele.size()-1;i++)
//		{
//			//String list = ele.get(i).getText();
//	        System.out.println(ele.get(i).getText());
////			String list1 = list.replace(",","");
////			String list2 = list1.replace("₹","");
////			Integer ActualPrice = Integer.valueOf(list2);
////		  if(ActualPrice<=5000)
////		{
////			System.out.println(ele.get(i).getText());
////	}
//		}
//
//	}
//
}
}
