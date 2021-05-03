package crm.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import crm.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
    
	//--------1-----------
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}
	
	//--------2-----------
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	//--------3-----------
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}
    
	//--------4-----------
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}

	//--------5-----------
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}

	//--------6-----------
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	//--------7-----------
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}

	//--------8-----------
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	//--------9-----------
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	//--------10-----------
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	//--------11-----------
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		//String currentdir = System.getProperty("user.dir");
		String thefilename =  "/screenshots/" + TestUtil.getCurrentTimestampString() + "_auto.jpg";
		TestUtil.takeScreenshot(driver, thefilename);;
	}

	//--------12-----------
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	//--------13-----------
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	
	// Non overridden methods of WebListener class
	
	public void beforeScript(String script, WebDriver driver) { }

	public void afterScript(String script, WebDriver driver) { }

	public void beforeAlertAccept(WebDriver driver) { }

	public void afterAlertAccept(WebDriver driver) { }

	public void afterAlertDismiss(WebDriver driver) { }

	public void beforeAlertDismiss(WebDriver driver) { }

	public void beforeNavigateRefresh(WebDriver driver) { }

	public void afterNavigateRefresh(WebDriver driver) { }

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) { }

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) { }

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) { }

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) { }

	public void afterSwitchToWindow(String arg0, WebDriver arg1) { }

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) { }

	public void beforeGetText(WebElement arg0, WebDriver arg1) { }

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) { }

}