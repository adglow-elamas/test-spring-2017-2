package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyPojo {
	
	private final static Logger logger = LogManager.getLogger(MyPojo.class);
	
	private String theString;
	
	public MyPojo() {
		logger.info("[m:empty constructor]");
	}

	public String getTheString() {
		logger.info("[m:getTheString]");
		return theString;
	}

	public void setTheString(String theString) {
		logger.info("[m:setTheString]");
		this.theString = theString;
	}

	public static Logger getLogger() {
		return logger;
	}
	
	

}