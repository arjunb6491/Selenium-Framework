package XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPhnwithPriceTest {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();		
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("iphone" , Keys.ENTER);
		
		WebElement productname = driver.findElement(By.xpath("//span[.='Apple iPhone 14 (128 GB) - Blue']"));
		String pName = productname.getText();
		System.out.println(pName);
		String price=driver.findElement(By.xpath("(//span[.='"+pName+"']/../../../following-sibling::div[2]//ancestor::span[@class='a-price-whole'])[last()]")).getText();

				try {
					System.out.println(pName+"---->"+price);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//List<WebElement> price = driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone')]/../../../..//span[contains(text(),'₹')]"));
		//List<WebElement> price=driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone')]/../../../..//span[@class='a-price']//span[text()='₹69,999']"));
//		List<WebElement> price=driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone')]/../../../..//span[@class='a-price-whole']"));
//		int count = iphonename.size();
//		System.out.println(count);
//		for(int i=0;i<count;i++)
//		{
//		String NameofIphone = iphonename.get(i).getText();
//		String Phoneprice = price.get(i).getText();
//		String Price1 = Phoneprice.replace(",","");
//		Integer ActualPrice = Integer.valueOf(Price1);
//		System.out.println(NameofIphone+"------->"+ActualPrice);
//		
	//	}
		//for(WebElement p:price)
	//	{
	//		System.out.println(p.getText());
	//	}
		
		
		

	}
	}


