package com.hms.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverutility {
	
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void waitforpageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
//	public void waitforElementtovisible(WebDriver driver,  WebElement element)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}
	public void select (WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	}
	
	public void select (String Text,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(Text);
	}
	public void select (WebElement element,String Value)
	{
		Select sel = new Select(element);
		sel.selectByValue(Value);
	}
	public void Mousehover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void rightClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
		
	}
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void enterKeyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	public void swithToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void swithToFrame(WebDriver driver,String nameorID)
	{
		driver.switchTo().frame(nameorID);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void accepAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void switchToWindow(WebDriver driver,String PartialTitle)
	{
		//step1:use getwindowhandles to cature all window id's
		Set<String> windows = driver.getWindowHandles();
		//step2:iterate through the windows
		Iterator<String> it = windows.iterator();
		//step3:check whether there is next window
		while(it.hasNext())
		{
			//step4:capture the current window id
			String winid = it.next();
			//step5:switch to current window and capture title
			String currentwindowTtitle = driver.switchTo().window(winid).getTitle();
			//step5:check whether current window is expected
			if( currentwindowTtitle.contains(PartialTitle))
			{
				break;
			}
			
		}
	}
		public static  String getScreenshot(WebDriver driver,String Screenshotname) throws Throwable
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = ".screenshot"+Screenshotname+".png";
			File dst = new File(path);
			FileUtils.copyFile(src, dst);
			return path;	
			
//			File Scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(Scr, new File("./image1.png"));
		//	
//			Take element screenshot
//			WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
//			File scrFile1 = element.getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(scrFile1, new File("./image1.png"));
		}
		public void scrollBarAction(WebDriver driver)
		{
			JavascriptExecutor jse= (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)","");
		}
		public void scrollAction(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			Point loc = element.getLocation();
			int x = loc.getX();
			int y = loc.getY();
			jse.executeScript("window.scrollBy("+x+","+y+")");
			//jse.executeScript("argument[0].scrollIntoView()", element);
		}
		
		public void scrollDownThePage() throws AWTException
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
	
	
}
