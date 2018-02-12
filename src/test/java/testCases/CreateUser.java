package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataProvider.ExcelDataConfig;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.OrangeHRMHomePage;
import pages.OrangeHRMLogin;
import utility.BaseExtentTest;

public class CreateUser extends BaseExtentTest{
	
	
	
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
		
		//logger.info("Web Page loaded");
		OrangeHRMLogin PageLogin=PageFactory.initElements(driver, OrangeHRMLogin.class);
		PageLogin.OrangeLogin(DataProviderFactory.getConfig().getusername(), DataProviderFactory.getConfig().getpassword());
		
		//logger.info("Entered UseName and Password");
	}
	
	@Test
	public static void createUser() throws Exception
	{
		
		logger = extent.createTest("createUser");
		homepage=PageFactory.initElements(driver, OrangeHRMHomePage.class);
		
		homepage.AdminLink.click();
		Thread.sleep(5000);
		
		//homepage.UserManagement.click();
		//Thread.sleep(5000);
		
		//homepage.users.click();
		
		homepage.addbutton.click();
		
		WebDriverWait waitst = new WebDriverWait(driver, 20);
        waitst.until(ExpectedConditions.visibilityOfElementLocated(By.id("systemUser_userType")));
        
        WebElement useroledd=homepage.UserRole;
        
        Select urdd=new Select(useroledd);
        
        urdd.selectByVisibleText("Admin");
        
        //Entering the Employee name
        homepage.EmployeeName.sendKeys("selenium");
        homepage.EmployeeName.sendKeys(Keys.ENTER);
        
        //Entering the username
        homepage.username.sendKeys("Admin Narayana");
        
        //Selecting the status from the drop down
        WebElement statusd=homepage.status;
        Select statusdd=new Select(statusd);
        statusdd.selectByVisibleText("Enabled");
        
        //Enter the Password in the password box
        homepage.password.sendKeys("Narayana@9");
        
        //Enter the confirm password
        homepage.confirmpassword.sendKeys("Narayana@9");
        
        //Clicking on Save button
        homepage.savebutton.click();
        
        homepage.Logout();
        
        BrowserFactory.closeBrowser(driver);
        
        extent.flush();
        
    }
	
	
	
	

}
