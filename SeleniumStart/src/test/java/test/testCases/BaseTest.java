package test.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver = null;
	Logger logger;
	static String browser;

	@BeforeSuite
	public void setupBrowser() {
		logger = LogManager.getLogger(this);
		Properties prop = loadPropertiesFromAFile("src/config/config.properties");
		browser = prop.getProperty("browser");
	}

	@BeforeClass
	public void SetupClassPreRequisite() {
		logger = LogManager.getLogger(this);
	}

	@Parameters("browserName") //To take parameter from testNG.xml
	@BeforeMethod
	public void createDriverInstance(String browserName) {
		logger.info("Thread is -->" + Thread.currentThread());
	//	switch (browser) { //To take browser parameter from property file
		switch (browserName) { //To take browser parameter from testNG.xml
		case "firefox":
			logger.info("Initializing firefox browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //Implicit wait
			break;
		case "chrome":
			logger.info("Initializing chrome browser");
			WebDriverManager.chromedriver().setup();
			/*Below mentioned commented code is for headless chrome browser
			 * 
			 */
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("headless");
//			driver = new ChromeDriver(options);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			break;
		case "ie":
			logger.info("Initializing ie browser");
			WebDriverManager.iedriver().setup();;
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			break;
		default:
			logger.warn("Initializing default browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	public Properties loadPropertiesFromAFile(String file) {
		Properties prop = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(file);
			prop.load(input);
		} catch (FileNotFoundException e) {
			logger.error(file + " --> properties file not found");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(file + " --> Unable to load properties file/inputStream");
			e.printStackTrace();
		}
		return prop;
	}

}
