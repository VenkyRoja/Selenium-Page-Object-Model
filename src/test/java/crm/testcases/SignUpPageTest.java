package crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crm.base.TestBase;
import crm.pages.LoginPage;
import crm.pages.SignUpPage;
import crm.util.TestUtil;

public class SignUpPageTest extends TestBase  {
	
	SignUpPage signuppage;
	LoginPage  loginpage;
	String     signupsheet = "SignUp";
	
	//--------1--------------------
	public SignUpPageTest() {
		
		super();
	}		
	
	//--------2--------------------
	@BeforeMethod
	public void setUp() {
		
		initialize();
		
		loginpage = new LoginPage();
		signuppage = loginpage.clickOnSignUpLink();
		
	}

	
	//--------3.1--------------------
	@Test(priority=1)
	public void signupPageURLTest() {
		
		String currentURL = signuppage.fetchURL();
		String expectedURL= prop.getProperty("ExpectedSignUpPageURL");
		
		Assert.assertEquals(currentURL, expectedURL, "Signup Page URL did not match!");
	}	
	
	//--------3.2.1--------------------
	@DataProvider
	public Object[][] getSignUpData() {
		
		Object data[][] = TestUtil.getDataFromExcel(signupsheet);
		return data;
	}
	
	
	//--------3.2.2--------------------
	@Test(priority=2, dataProvider="getSignUpData")
	public void registrationTest(String email, String countrycode, String phonenumber) {
	
		String returnMsg = signuppage.registerUser(email, countrycode, phonenumber);
		
		String expectedUreturnMsg= prop.getProperty("ExpectedSignUpMessage");
		
		Assert.assertEquals(returnMsg, expectedUreturnMsg);	
		
	}	

	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		
		driver.quit();

	}	
	
	//------------------------------
	

}
