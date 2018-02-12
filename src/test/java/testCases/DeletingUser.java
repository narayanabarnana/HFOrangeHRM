package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dataProvider.ExcelDataConfig;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;
import pages.OrangeHRMHomePage;
import pages.OrangeHRMLogin;
import utility.BaseExtentTest;
import utility.Highlight;

public class DeletingUser extends BaseExtentTest{
	
	 static WebDriver driver;
	static OrangeHRMHomePage homepage;
	
	static ExcelDataConfig excel = new ExcelDataConfig("F:\\Selenium Framework\\com.hybridFramework\\ApplicationTestData\\TestData.xlsx");
	
	
	@BeforeMethod
	public static void AppOrangeHRMLogin(){
		
		
		logger = extent.createTest("AppOrangeHRMLogin");
		//this will automatically opens the browser, maximize the browser
		driver = BrowserFactory.getBrowser("Chrome");
										
		//this will provide the URL from the config.properties file
		driver.get(DataProviderFactory.getConfig().getApplicationurl());
								
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		OrangeHRMLogin PageLogin=PageFactory.initElements(driver, OrangeHRMLogin.class);
		PageLogin.OrangeLogin(DataProviderFactory.getConfig().getusername(), DataProviderFactory.getConfig().getpassword());
		
		
	}
	
	@Test
	public void deleteUser() throws Exception
	{
		logger = extent.createTest("deleteUser");
		//homepage=PageFactory.initElements(driver,OrangeHRMHomePage.class);
		
		//homepage.AdminLink.click();
		Thread.sleep(5000);
			
		
		//List<WebElement> RowWebElement = homepage.ResultsTable;
		//int RC=RowWebElement.size();
		
		//System.out.println("Row count for PF is " + RC);
			
			
		SoftAssert ass=new SoftAssert();
		ass.assertEquals("Welcome", "Wel");
		//Assert.assertEquals("Welcome", "Wec");
		ass.assertAll();
		
				
		homepage.Logout();
		BrowserFactory.closeBrowser(driver);
		//extent.flush();
		
		
	}

}
