package test.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.FailedTestRetry;

public class retryFailedDemo extends BaseTest {

	@Test(retryAnalyzer = FailedTestRetry.class)
	public void testF1() {
		System.out.println("I am failed test case F1");
		Assert.assertFalse(true);

	}

	@Test
	public void testF2() {
		System.out.println("I am failed test case F2");
		int i = 1 / 0;
		System.out.println(i);

	}

	@Test
	public void testF3() {
		System.out.println("I am failed test case F3");
		Assert.assertFalse(true);

	}

}
