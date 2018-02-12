package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrangeHRMLogin {
	
	WebDriver driver;
	
	public OrangeHRMLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how = How.ID, using = "txtUsername")
	public static WebElement txtbx_UserName;
	
	@FindBy(how = How.ID, using = "txtPassword")
	public static WebElement txtbx_Password;
	
	@FindBy(how = How.ID, using = "btnLogin")
	public static WebElement LoginButton;
	
	public static void OrangeLogin(String user, String Password){
		
		txtbx_UserName.sendKeys(user);
		txtbx_Password.sendKeys(Password);
		LoginButton.click();
	}

}
