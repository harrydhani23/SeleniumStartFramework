package test.testCases;

import org.testng.annotations.Test;

import utils.FailedTestRetry;

public class retryFailedDemo extends BaseTest {

	@Test(retryAnalyzer = FailedTestRetry.class)
	public void testF1() {
		System.out.println("I am pass test case F1");

	}

	@Test
	public void testF2() {
		String URL = "http://www.google.com";
		logger.info("typing url --> " + URL);
		driver.get(URL);
		driver.manage().window().maximize();
		System.out.println("I am failed test case F2");
		int i = 1 / 0;
	}

	@Test
	public void testF3() {
		System.out.println("I am pass test case F3");

	}

}
