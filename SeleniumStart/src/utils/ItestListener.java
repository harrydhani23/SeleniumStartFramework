package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListener implements ITestListener {
	Logger logger;
	
	public ItestListener() {
		logger = LogManager.getLogger(this);
	}

	public void onTestStart(ITestResult result) {
	//	System.out.println("I came here onTestStart of test --> " + result.getTestName());
		logger.info("I came here onTestStart of test --> " + result.getTestClass()+ "." + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
	//	System.out.println("I came here onTestSuccess of test --> " + result.getTestName());
		logger.info("I came here onTestSuccess of test --> " + result.getTestClass()+ "." + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		//System.out.println("I came here onTestFailure of test --> " + result.getTestName());
		logger.error("I came here onTestFailure of test --> "  + result.getTestClass()+ "." + result.getName());
		logger.error("failureReason --> "  + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
	//	System.out.println("I came here onTestSkipped of test --> " + result.getTestName());
		logger.error("I came here onTestSkipped of test --> " + result.getTestClass()+ "." + result.getName());
		logger.error("skipReason --> "  + result.getThrowable());
	}
}