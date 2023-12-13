package com.hms.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"----->TestScrpt ExecutionStarted");
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"----->Passed");
		Reporter.log(MethodName+"----->TestScrpt Passed");
		
	}

	public void onTestFailure(ITestResult result) 
	{
//		String FScript = result.getMethod().getMethodName();
//		
//		String res = result.getName();
//		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		File dst = new File("./Screenshot/"+res+".png");
//		try {
//			FileUtils.copyFile(src, dst);
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		test.log(Status.FAIL, FScript+"---->Failed");
		test.log(Status.FAIL, result.getThrowable());
	//	Reporter.log(FScript+"----->TestScriptFailed");
		
		WebDriverutility wUtil=new WebDriverutility();
		try {
			String FailedScript = wUtil.getScreenshot(BaseClass.sdriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(FailedScript);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"------>TestScript Skipped");
			}

	public void onStart(ITestContext context) {
	ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
	htmlreport.config().setDocumentTitle("HMS-TYSS");
	htmlreport.config().setTheme(Theme.STANDARD);
	htmlreport.config().setReportName("HMS");
	
	report=new ExtentReports();
	report.attachReporter(htmlreport);
	report.setSystemInfo("os", "Windows");
	report.setSystemInfo("Base-Browser", "Chrome");
	report.setSystemInfo("Base_url", "http://rmgtestingserver/domain/Hospital_Management_System/");
	report.setSystemInfo("reporter-Name", "Shivamma");
	
	
		
	}

	public void onFinish(ITestContext context) {
		
		report.flush();
			}

	
	

}
