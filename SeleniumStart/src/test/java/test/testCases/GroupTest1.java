package test.testCases;

import org.testng.annotations.Test;

import utils.FailedTestRetry;

public class GroupTest1 {
	
	@Test(groups = "sanity")
	public void test1() {
		System.out.println("testCase1");

	}
	@Test(groups = "sanity")
	public void test2() {
		System.out.println("testCase2");

	}
	@Test(groups = "smoke")
	public void test3() {
		System.out.println("testCase3");

	}
	@Test(groups = {"regression","sanity"})
	public void test4() {
		System.out.println("testCase4");
	}
	

}
