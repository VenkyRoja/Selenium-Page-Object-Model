package crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.base.TestBase;

import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.pages.TasksPage;

public class TasksPageTest extends TestBase  {
	
	LoginPage loginpage;
	HomePage  homepage;
	TasksPage taskspage;
	
	//--------1--------------------
	public TasksPageTest() {
		
		super();
	}		
	
	//--------2--------------------
	@BeforeMethod
	public void setUp() {
		
		initialize();
		
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		
		taskspage = new TasksPage();

		loginpage = new LoginPage();
		
		homepage = loginpage.login(uname, pwd);
		
		taskspage = homepage.clickOnTasksMenuOption();
		
	}

	
	//--------3.1--------------------
	@Test(priority=1)
	public void dealsPageURLTest() {
		
		String currentURL = taskspage.fetchURL();
		String expectedURL= prop.getProperty("ExpectedTasksPageURL");
		
		Assert.assertEquals(currentURL, expectedURL, "Tasks Page URL did not match!");
	}	

	//--------3.2--------------------
	@Test(priority=2)
	public void dealsLabelDisplayTest() {
		
		boolean b = taskspage.isTasksLabelDisplayed();
		
		Assert.assertTrue(b,"Tasks label on Tasks page is NOT displayed!");
	}		
	

	
	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		
		driver.quit();

	}	
	
	//------------------------------

}