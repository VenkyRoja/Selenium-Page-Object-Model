package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.TestBase;

public class HomePage extends TestBase  {

	//--------Page Factory-------------Object Repository------------
		
	@FindBy(xpath="//span[@class='user-display']")
	WebElement usernamedisplay;	

	@FindBy(xpath="//span[@class='item-text'][text()='Contacts']")
	WebElement contactsMenuOption;		
	
	@FindBy(xpath="//span[@class='item-text'][text()='Deals']")
	WebElement dealsMenuOption;		

	@FindBy(xpath="//span[@class='item-text'][text()='Tasks']")
	WebElement tasksMenuOption;		

	@FindBy(xpath="//a[contains(@href, 'contacts')][@class='item']//following-sibling::button")
	WebElement addContactsLink;		
	
	

	//------------1-------------Constructor---------
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//------------2-------------Action--------------
	public String fetchURL() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}
	

	//------------3-------------Action--------------
	public ContactsPage clickOnContactsMenuOption() {

		contactsMenuOption.click();
		
		return new ContactsPage();
		
	}	
	
	//------------4-------------Action--------------
	public DealsPage clickOnDealsMenuOption() {

		dealsMenuOption.click();
		
		return new DealsPage();
		
	}	

	
	//------------5-------------Action--------------
	public TasksPage clickOnTasksMenuOption() {

		tasksMenuOption.click();
		
		return new TasksPage();
		
	}		

	//------------2-------------Action--------------
	public String fetchUsernameDisplay() {
		String unamedisplay = usernamedisplay.getText();
		return unamedisplay;
	}
	

	//------------5-------------Action--------------
	public ContactsPage clickOnNewContactOption() {

		addContactsLink.click();
		
		return new ContactsPage();
		
	}		
	
	
	//-----------------------------------------------
	
}
