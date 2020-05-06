package test.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test.testCases.DataProviderPack.DataProvidersClass;

public class DataProviderTests {

	@Test(dataProvider = "data-provider", dependsOnGroups = "sanity")
	public void test(String data) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Data is = " + data+"-"+Thread.currentThread().getId());
	}

	@Test(dataProvider = "data-provider-one", dataProviderClass = DataProvidersClass.class, priority = 1, groups = "sanity")
	public void test1(String data) {
		System.out.println("Data is = " + data);
	}

	@Test(dataProvider = "data-provider-two", priority = 2)
	public void test2(String userName, String passWord, String message) {
		System.out.println("UserName is = " + userName);
		System.out.println("PassWord is = " + passWord);
		System.out.println("Message is = " + message);
	}
	
	
	

	@DataProvider(name = "data-provider", parallel = true)
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "data one" }, { "data two" }, { "data three" } ,  { "data four" }, { "data five" }, { "data six" }};
	}

	@DataProvider(name = "data-provider-two")
	public Object[][] dataProviderMethodTwo() {
		return new Object[][] { 
			{ "harrydhani", "pass","" },
			{ "indiaDhani", "nass", "jaiHarry" } };
	}
}
