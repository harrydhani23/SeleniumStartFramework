package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPageObject extends BasePageObject {

	By search_TextBox = By.name("q");
	By search_Button = By.name("btnK");

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterTextInSearchBox(String text) {
		explicitWait(driver, search_TextBox, 10);
		driver.findElement(search_TextBox).sendKeys(text);

	}

	public void clickSearch() {
	//	explicitWait(driver, search_Button, 10);
		fluentWait(driver, search_Button, 20, 3);
		driver.findElement(search_Button).click();
	}

}
