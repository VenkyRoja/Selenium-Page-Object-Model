package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.TestBase;

public class TasksPage extends TestBase {

	//--------Page Factory-------------Object Repository------------
	
	@FindBy(xpath="//div[contains(@class, 'ui headerxxxxxxx')]")
	WebElement tasksLabel;	
	
	//------------1-------------Constructor---------
	public TasksPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//------------2-------------Action--------------
	public String fetchURL() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}	
	
	//------------3-------------Action--------------
	public boolean isTasksLabelDisplayed() {
		
		boolean b = tasksLabel.isDisplayed();
		return b;
	}
	
	
}

