package XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartingCountry {

	public static void main(String[] args) {
		String name=null;
		int ma = 0;
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> eles = driver.findElements(By.xpath("(//table//tr[*]/td[2]//span[2])[position()>10]"));
		for(WebElement ele:eles)
		{
			System.out.println(ele.getText());
		}
	}
}

