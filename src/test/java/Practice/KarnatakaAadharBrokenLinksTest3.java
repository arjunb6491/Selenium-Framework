package Practice;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KarnatakaAadharBrokenLinksTest3 {

	public static void main(String[] args) throws InterruptedException, Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ceg.karnataka.gov.in/aadhaar/public/english");
		List<WebElement> listlinks = driver.findElements(By.xpath("//a"));
		System.out.println(listlinks.size());
		ArrayList<String> links=new ArrayList<String>();
		for(int i=0; i<listlinks.size(); i++) {
			String eachlink = listlinks.get(i).getAttribute("href");
			
//			URL url=null;
//			int statuscode=0;
		//	try {
				URL url=new URL(eachlink);
				HttpURLConnection HttpURLConnection =(HttpURLConnection) url.openConnection();
				int statuscode=HttpURLConnection.getResponseCode();
				if(statuscode>=200)
				{
					links.add(eachlink+"------>"+statuscode);
				}
				
			
//			catch (Exception e) {
//				
//				links.add(eachlink+"------>"+statuscode);
//			}
			
		}
		
	System.out.println(links);

	}	
	}


