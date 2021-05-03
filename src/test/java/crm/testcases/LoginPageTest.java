package crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.base.TestBase;
import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.pages.SignUpPage;

public class LoginPageTest extends TestBase {
	
	LoginPage  loginpage;
	HomePage   homepage;
	SignUpPage signuppage;

	//--------1--------------------
	public LoginPageTest() {
		
		super();
	}
	
	//--------2--------------------
	@BeforeMethod
	public void setUp() {
		
		initialize();
		loginpage = new LoginPage();
	}

	//--------3.1--------------------
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title = loginpage.fetchTitle();
		String expectedTitle = prop.getProperty("ExpectedLoginPageTitle");
		
		Assert.assertEquals(title, expectedTitle, "Title of Login Page did not match!");
	}
	
	//--------3.2--------------------
	@Test(priority=2)
	public void loginTest() {
		
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		
		homepage = loginpage.login(uname, pwd);
		
	}

	
	//--------3.3--------------------
	@Test(priority=3)
	public void signuplinkTest() {
		
		signuppage = loginpage.clickOnSignUpLink();
		
	}	
	
	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		
		driver.quit();

	}
	
	//-----------------------------

}
