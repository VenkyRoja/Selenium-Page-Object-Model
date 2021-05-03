package crm.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.TestBase;
import crm.util.TestUtil;


public class ContactsPage extends TestBase  {
	
	//--------Page Factory-------------Object Repository------------
	
	@FindBy(xpath="//div[contains(@class, 'ui header item')]")
	WebElement contactslabel;	
	
	@FindBy(xpath="//th[text()='Address']")
	WebElement addresslabel;	
	
	//--new contact---
	@FindBy(name="first_name")
	WebElement firstnameInput;

	@FindBy(name="last_name")
	WebElement lastnameInput;

	@FindBy(xpath="//input[@class='search'][@type='text']")
	WebElement companyInput;	
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;	
	
	@FindBy(xpath="//div[contains(@class, 'ui header item')]")
	WebElement namelabel;	
	
	
	
	//------------1-------------Constructor---------
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//------------2-------------Action--------------
	public String fetchURL() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}
	
	
	//------------3-------------Action--------------
	public boolean isContactsLabeleDisplayed() {
		
		boolean b = contactslabel.isDisplayed();
		return b;
	}

	//------------4-------------Action--------------
	public boolean istheContactChecked(String contactName) throws InterruptedException {
		
		WebElement contactsCheckBox = driver.findElement(By.xpath("//a[text()='" + contactName + "']"
			                                                    + "//parent::td"
				                                                + "//preceding-sibling::td"
			                                                    + "//input[@name='id']"));
	

		TestUtil.clickElementByJs(driver,contactsCheckBox);
		
		boolean b = contactsCheckBox.isSelected();
		return b;
		
	}	
	
	//------------5-------------Action--------------
	public void addContact(String fn, String ln, String company) {
		
		firstnameInput.sendKeys(fn);
		lastnameInput.sendKeys(ln);
		companyInput.sendKeys(company);
		
		saveButton.click();

	}
	
	//------------6-------------Action--------------
	public String fetchLabelName() {
		String labelName = namelabel.getAttribute("innerText");
		return labelName;
	}	

	
	//----------------------------------------------
}
