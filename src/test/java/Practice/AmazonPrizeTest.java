package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPrizeTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@aria-label='Search Amazon.in']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    List<WebElement> eles = driver.findElements(By.xpath("//span[@class='a-price-whole']"));//wrong
	   // ArrayList<Integer> list=new ArrayList<Integer>();
	    for(int i=0;i<eles.size();i++)
	    {
	    	String St1 = eles.get(i).getText();
	    	 String St = St1.replace(",","");
	    	Integer actprize = Integer.valueOf(St);
	    	if(actprize<=70000){
	    		//list.add(actprize);
	    		System.out.println(actprize);
	    		
	    		
	    	} 
	  //  System.out.println(list);

	}
	   // System.out.println(list);


}
}
