package test.testCases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import pages.SearchPageObject;

public class SearchPageTestCasesOne extends BaseTest {

	@Test(groups= {"regression","smoke"})
	public void test1() {
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		SearchPageObject searchPage = new SearchPageObject(driver);
		searchPage.enterTextInSearchBox("Death Count in CoronaVirus");
		searchPage.clickSearch();
	}

	@Test(groups= {"smoke"})
	public void test2() {
		String URL = "http://www.google.com";
		String SearchText = "Death Count in CoronaVirus in India";
		logger.info("typing url --> " + URL);
		logger.info("This is driver Instance --> " + driver.toString());
		driver.get(URL);
		driver.manage().window().maximize();
		SearchPageObject searchPage = new SearchPageObject(driver);
		logger.warn("Entering Text in Goole Search --> " + SearchText);
		searchPage.enterTextInSearchBox(SearchText);
		searchPage.clickSearch();
		logger.error("Clicked Search");

	}
	
	@Ignore //this annotation is to ignore this test
	@Test(groups= {"smoke"})
	public void test3() {
		logger.info("I am ingnored test");

	}
}
