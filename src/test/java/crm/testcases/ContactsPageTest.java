package crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crm.base.TestBase;
import crm.pages.ContactsPage;
import crm.pages.HomePage;
import crm.pages.LoginPage;
import crm.util.TestUtil;

public class ContactsPageTest extends TestBase   {

	LoginPage       loginpage;
	HomePage        homepage;
	ContactsPage    contactspage;
	String          contactsheet = "Contacts";
	
	//--------1--------------------
	public ContactsPageTest() {
		
		super();
	}		
	
	//--------2--------------------
	@BeforeMethod
	public void setUp() {
		
		initialize();
		
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");

		loginpage = new LoginPage();
		
		homepage = loginpage.login(uname, pwd);
		
		contactspage = homepage.clickOnContactsMenuOption();
		
	}

	
	//--------3.1--------------------
	@Test(priority=1)
	public void contactPageURLTest() {
		
		String currentURL = contactspage.fetchURL();
		String expectedURL= prop.getProperty("ExpectedContactsPageURL");
		
		Assert.assertEquals(currentURL, expectedURL, "Contact Page URL did not match!");
	}	


	//--------3.2--------------------
	@Test(priority=2)
	public void contactsPageContactsLabelTest() {
		
		boolean b = contactspage.isContactsLabeleDisplayed();
		
		Assert.assertTrue(b,"Contacts label on Contacts page is NOT displayed!");
	}		
	


	//--------3.3--------------------
	@Test(priority=3)
	public void contactsPageCheckBoxTest() throws InterruptedException {
		
		String cname = prop.getProperty("ContactName2");
		
		boolean b = contactspage.istheContactChecked(cname);
		
		Assert.assertTrue(b,"Contact name" + cname + "on Contacts page is NOT selected!");
	}		
		

	
	//--------3.4--------------------
	@Test(priority=4)
	public void contactsPageCheckBoxesTest() throws InterruptedException {
		
		String cname1 = prop.getProperty("ContactName1");
		String cname2 = prop.getProperty("ContactName2");
		String cname3 = prop.getProperty("ContactName3");
		
		boolean b1 = contactspage.istheContactChecked(cname1);
		boolean b2 = contactspage.istheContactChecked(cname2);
		boolean b3 = contactspage.istheContactChecked(cname3);
		
		Assert.assertTrue(b1,"Contact name " + cname1 + "on Contacts page is NOT selected!");
		Assert.assertTrue(b2,"Contact name " + cname2 + "on Contacts page is NOT selected!");
		Assert.assertTrue(b3,"Contact name " + cname3 + "on Contacts page is NOT selected!");
	}		
			
	
	//--------3.5.1--------------------
	@DataProvider
	public Object[][] getContactsData() {
		
		Object data[][] = TestUtil.getDataFromExcel(contactsheet);
		return data;
	}
	

	//--------3.5.2--------------------
	@Test(priority=5, dataProvider="getContactsData")
	public void addContactsTest(String fname, String lname, String company )  {

		contactspage = homepage.clickOnNewContactOption();
		contactspage.addContact(fname, lname, company);
		TestUtil.waitforPageLoad(driver, TestUtil.PAGE_LOAD_TIMEOUT_MILLISECONDS);
		
		//String labelName = contactspage.fetchLabelName();
		//System.out.println(labelName);
		//Assert.assertEquals(labelName, fname + " " + lname);
	}		
	

	
	
	//--------4--------------------
	@AfterMethod
	public void tearDown() {
		
		driver.quit();

	}		
	
}
