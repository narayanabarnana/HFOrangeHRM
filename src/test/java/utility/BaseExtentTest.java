package utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import factory.BrowserFactory;

public class BaseExtentTest {
	
	WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;
	
	
	
	@BeforeSuite
	public void setUp()
	{
		htmlReporter = new ExtentHtmlReporter("./Reports/LoginPage.html");
		extent = new ExtentReports();
		extent.config();
		extent.attachReporter(htmlReporter);
		
		htmlReporter.config().setReportName("Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshotPath=GetScreenshot.capture(driver, result.getName());
			//logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "test case failed due to below issues", ExtentColor.RED));
			logger.fail(MarkupHelper.createLabel(result.getName() + "test case failed due to below issues", ExtentColor.RED));
			logger.fail(result.getThrowable());
			logger.fail("Screenshot below" + logger.addScreenCaptureFromPath(screenshotPath));
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass(MarkupHelper.createLabel(result.getName() + "test case Passed", ExtentColor.GREEN));
		}
		else
		{
			//logger.skip(Status.SKIP, MarkupHelper.createLabel(result.getName() + "test case Passed", ExtentColor.YELLOW));
			logger.skip(MarkupHelper.createLabel(result.getName() + "test case Skipped", ExtentColor.YELLOW));
			logger.skip(result.getThrowable());
		}
		extent.flush();
		
	}
	
	
	@AfterSuite
	public void teardown()
	{
		extent.flush();
	}
	
	
	

}
