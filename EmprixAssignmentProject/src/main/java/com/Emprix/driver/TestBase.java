package com.Emprix.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Emprix.listener.WebEventListener;
import com.Emprix.util.CommonFunction;
import com.Emprix.util.TestUtil;


public class TestBase  {

	
	public static WebDriver driver;
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	/**
	 * this method is used to initialize the driver 
	 * And naviagte the url
	 */
	
	@BeforeTest
	@Parameters("browser")
	public void initialization(String browser) {
		
		  String driverPath=System.getProperty("user.dir")+"\\driver\\";
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
				driver=new ChromeDriver(options);
				Reporter.log("Chrome Browser Opened");

				
			} else if (browser.equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
				driver=new FirefoxDriver();
				Reporter.log("Firefox Browser Opened");

			}
			else if (browser.equalsIgnoreCase("edge"))
			{
				System.setProperty("webdriver.edge.driver","C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
				 driver = new EdgeDriver();
					Reporter.log("IE Browser Opened");

				
			}
			else
			{
				
			}
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(CommonFunction.readPropertyFile("url"));
			Reporter.log("URL Navigated "+CommonFunction.readPropertyFile("url"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	
	
}
