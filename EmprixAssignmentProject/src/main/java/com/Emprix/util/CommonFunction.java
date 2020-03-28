package com.Emprix.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
	
	
}
