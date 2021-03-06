package com.Emprix.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.Emprix.driver.TestBase;

public class CommonFunction extends TestBase {
	
	/**
	 * @author ANIL
	 * @throws IOException
	 */
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	/**
	 * @author ANIL
	 * @param key
	 * @return
	 */
	
	public static String readPropertyFile(String key)
	{
		String value="";
		try {
			String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\Emprix\\properties\\config.properties";
			FileInputStream file=new FileInputStream(path);
			Properties prop=new Properties();
			prop.load(file);
			value=prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
		
	}
	
	
	/**
	 * @author ANIL
	 * @param element
	 * @return
	 */
	public boolean checkElementPresence(WebElement element)
	{
		boolean actual = false;
		try {
			
			 actual= element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return actual;
		
	}
	
	/**
	 * @author ANIL
	 */
	public static void alertAccept()
	{
		try {
			Alert  alert=driver.switchTo().alert();
			alert.accept();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author ANIL
	 * @param urlLink
	 */
	public static void verifyLinkAccessibilty(String urlLink) {
		
     try {
    	 
      URL link = new URL(urlLink);
      HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
      httpConn.setConnectTimeout(2000);
      httpConn.connect();
      if(httpConn.getResponseCode()== 200) { 
      System.out.println(urlLink+" ==> is accessible == And Response Code ==> "+httpConn.getResponseMessage());
      }
      else {
      System.out.println(urlLink+" ==> is Not accessible == And Response Code ==> "+httpConn.getResponseMessage());
      }
    }
   catch (Exception e) {
   e.printStackTrace();
   }
  } 
}
