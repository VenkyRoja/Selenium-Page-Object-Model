package crm.pages;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.TestBase;
import crm.util.TestUtil;

public class SignUpPage extends TestBase  {
	
	//--------Page Factory-------------Object Repository------------
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailTextBox;	
	
	@FindBy(xpath="//input[@class='search']")
	WebElement countrycodeInput;	
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement phoneTextBox;		
	
	@FindBy(xpath="//input[@id='terms']")
	WebElement termsCheckBox;		

	@FindBy(xpath="//div[@class='recaptcha-checkbox-checkmark']")
	WebElement capCheckBox;		
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SignUpButton;		
	
	
	//------------1-------------Constructor---------
	public SignUpPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//------------2-------------Action--------------
	public String fetchURL() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}
	

	//------------2-------------Action--------------
	public String registerUser(String email, String countrycode, String phone) {
		
		emailTextBox.sendKeys(email);
		
		countrycodeInput.sendKeys(countrycode);
		
		phoneTextBox.sendKeys(phone);
	
		
		//List<WebElement> cOptions = driver.findElements(By.xpath("//div[@class='item']"));
		
		//for (WebElement s : cOptions) {

			//System.out.println(s.getAttribute("innerText"));
		//}	
		
		//termsCheckBox.click();
		TestUtil.clickElementByJs(driver,termsCheckBox);
		
		//SignUpButton.click();
		TestUtil.clickElementByJs(driver,SignUpButton);
		
		WebElement returnMsg = driver.findElement(By.xpath("//ul[@class='list']//li"));
		
		String msg = returnMsg.getText();
		
		return msg;
	}	
	
	
	

}
