package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import test.testCases.BaseTest;

public class ItestListener implements ITestListener {
	Logger logger;
	
	public ItestListener() {
		logger = LogManager.getLogger(this);
	}

	public void onTestStart(ITestResult result) {
		logger.info("I came here onTestStart of test --> " + result.getTestClass()+ "." + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("I came here onTestSuccess of test --> " + result.getTestClass()+ "." + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		logger.error("I came here onTestFailure of test --> "  + result.getTestClass()+ "." + result.getName());
		logger.error("failureReason --> "  + result.getThrowable());
		BaseTest base = new BaseTest();
		base.takeScreenShot(result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.error("I came here onTestSkipped of test --> " + result.getTestClass()+ "." + result.getName());
		logger.error("skipReason --> "  + result.getThrowable());
	}
}