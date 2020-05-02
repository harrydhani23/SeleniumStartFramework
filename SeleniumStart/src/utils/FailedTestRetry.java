package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailedTestRetry implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetyrCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetyrCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
