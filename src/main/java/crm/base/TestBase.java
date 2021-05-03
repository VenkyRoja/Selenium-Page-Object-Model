package crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import crm.util.TestUtil;
import crm.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	public static EventFiringWebDriver edriver;
	public static WebEventListener eventListener;	
	
	//---------1-----------
	public TestBase() {

		try {
			
			prop = new Properties();		
			FileInputStream fip;			
		
			String mainpath = System.getProperty("user.dir");
			String subpath = "/src/main/java/crm/config/config.properties";
					
			fip = new FileInputStream(mainpath + subpath);
		
			prop.load(fip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//---------2-----------
	public static void initialize() {
		
		String wd = prop.getProperty("WD");
		String wdpath = prop.getProperty("WDpath");
		String url = prop.getProperty("url");
		
		System.setProperty(wd, wdpath);
        
        FirefoxOptions opts = new FirefoxOptions();
        opts.addArguments("-private");
        driver = new FirefoxDriver(opts);

		edriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		edriver.register(eventListener);
		driver = edriver;
        
        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(url);
		
	}

	//----------------------
}
