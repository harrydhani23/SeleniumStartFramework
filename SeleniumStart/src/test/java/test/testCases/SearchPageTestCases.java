package test.testCases;

import org.testng.annotations.Test;

import pages.SearchPageObject;

@Test(groups = "classOneTests")
public class SearchPageTestCases extends BaseTest {

	@Test(groups = { "sanity", "regression" })
	public void test1() {
		String URL = "http://www.google.com";
		String SearchText = "CoronaVirus";
		logger.info("typing url --> " + URL);
		driver.get(URL);
		driver.manage().window().maximize();
		SearchPageObject searchPage = new SearchPageObject(driver);
		logger.warn("Entering Text in Goole Search --> " + SearchText);
		searchPage.enterTextInSearchBox(SearchText);
		searchPage.clickSearch();
		logger.error("Clicked Search");
	}

}
