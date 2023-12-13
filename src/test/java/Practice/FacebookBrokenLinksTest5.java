package Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookBrokenLinksTest5 {

	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		List<WebElement> listlinks = driver.findElements(By.xpath("//a"));
		System.out.println(listlinks.size());
		ArrayList<String> links=new ArrayList<String>();
		for(int i=0;i<listlinks.size();i++)
		{
		    String eachlink = listlinks.get(i).getAttribute("href");
			URL url=null;
			int statuscode=0;
			try {
				url=new URL(eachlink);
				HttpsURLConnection huc=(HttpsURLConnection) url.openConnection();
				statuscode=	huc.getResponseCode();
				if(statuscode<=200)	
				{
					links.add(eachlink+"----->"+statuscode); 	
				}
			}
	     catch (Exception e) 
	     {
		     links.add(eachlink+"----->"+statuscode);
		  }
			//System.out.println(links);
		}
		System.out.println(links);

	}
	

}

