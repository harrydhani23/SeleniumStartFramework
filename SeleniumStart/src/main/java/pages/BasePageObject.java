package pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	WebDriver driver = null;

	public WebElement explicitWait(WebDriver driver, By locator, int timeOutnSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutnSeconds);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement fluentWait(WebDriver driver, By locator, int timeOutnSeconds, int pollingFrequency) {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeOutnSeconds, TimeUnit.SECONDS)
				.pollingEvery(pollingFrequency, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver t) {
				return t.findElement(locator);
			}
		});
		
		return element;
	}
	
	public boolean waitForElement(WebDriver driver,By locator, String text, int wait) {
		
		for(int i=0; i<=wait;i++) {
		if(driver.findElement(locator).getText().equalsIgnoreCase(text)) {
			return true;
		} else {
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		return false;
	}

}
