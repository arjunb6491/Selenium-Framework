package XpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccCountrynamewithMatchesTest {

	public static void main(String[] args) {
		String name=null;
		int ma = 0;
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//List<WebElement> eles1 = driver.findElements(By.xpath("//table//tr[*]/td[2][@class='table-body__cell u-center-text' and text()>30]"));
	//	List<WebElement> eles = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3][@class='table-body__cell u-center-text'and text()>30]"));
		List<WebElement> eles1 = driver.findElements(By.xpath("//table//tr[*]/td[@class='table-body__cell u-center-text' and text()>30]"));
			List<WebElement> eles = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3][@class='table-body__cell u-center-text'and text()>30]"));
			
		
		
		
		int count = eles1.size();
		for (int i = 0; i <count; i++) {
			System.out.println(eles1.get(i).getText()+"----->"+eles.get(i).getText());
		}
		
			
	}
}