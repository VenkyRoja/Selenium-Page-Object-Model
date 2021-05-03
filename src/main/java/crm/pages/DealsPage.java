package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.TestBase;

public class DealsPage extends TestBase  {

	//--------Page Factory-------------Object Repository------------
	
	@FindBy(xpath="//div[contains(@class, 'ui header')]")
	WebElement dealsLabel;	
	
	//------------1-------------Constructor---------
	public DealsPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//------------2-------------Action--------------
	public String fetchURL() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}	
	
	//------------3-------------Action--------------
	public boolean isDealsLabelDisplayed() {
		
		boolean b = dealsLabel.isDisplayed();
		return b;
	}
	
	
}
