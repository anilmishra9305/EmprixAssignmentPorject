package com.Emprix.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogReporter {
	
	
	public Logger logger=Logger.getLogger(LogReporter.class);
	public LogReporter()
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\Emprix\\logger\\log4j.properties";
		PropertyConfigurator.configure(path);
	}
	
	
	public void debug(String message)
	{
		
		logger.info(message);
		
	}

}
