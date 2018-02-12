package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrangeHRMHomePage {
	
WebDriver driver;
	
	public OrangeHRMHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how = How.XPATH, using = "//a[@href='/index.php/admin/viewAdminModule']")
	public static WebElement AdminLink;
	
	@FindBy(how = How.LINK_TEXT, using = "User Management")
	public static WebElement UserManagement;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/index.php/admin/viewSystemUsers']")
	public static WebElement users;
	
	@FindBy(how = How.ID, using = "btnAdd")
	public static WebElement addbutton;
	
	@FindBy(how = How.ID, using = "systemUser_userType")
	public static WebElement UserRole;
	
	@FindBy(how = How.ID, using = "systemUser_employeeName_empName")
	public static WebElement EmployeeName;
	
	@FindBy(how = How.ID, using = "systemUser_userName")
	public static WebElement username;
	
	@FindBy(how = How.ID, using = "systemUser_status")
	public static WebElement status;
	
	@FindBy(how = How.ID, using = "systemUser_password")
	public static WebElement password;
	
	@FindBy(how = How.ID, using = "systemUser_confirmPassword")
	public static WebElement confirmpassword;
	
	@FindBy(how = How.ID, using = "btnSave")
	public static WebElement savebutton;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Welcome Admin']")
	public static WebElement WelcomeAdmin;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	public static WebElement LogoutButton;
	
	@FindBy(how = How.XPATH, using = "//table[@id='resultTable']//tbody//tr")
	public static List<WebElement> ResultsTable;
	
	@FindBy(how = How.TAG_NAME, using = "td")
	public static List<WebElement> ResultsTDTable;
	
	@FindBy(how = How.ID, using = "btnDelete")
	public static WebElement deletebutton;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Ok']")
	public static WebElement UserdelOk;
	
	public static void Logout() throws Exception
	{
		WelcomeAdmin.click();
		Thread.sleep(5000);
		LogoutButton.click();
	}

}
