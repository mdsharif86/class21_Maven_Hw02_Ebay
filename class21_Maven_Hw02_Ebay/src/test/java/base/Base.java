package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {

	public static WebDriver driver;
	static FileInputStream fis;
	public static Properties locatorProp;
	public static Properties configProp;

	@BeforeSuite
	public void setupWebDriver() throws IOException {

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path: " + projectPath);

		fis = new FileInputStream(projectPath + "\\src\\test\\resources\\properties\\locators.properties");
		locatorProp = new Properties();
		locatorProp.load(fis);

		configProp = new Properties();

		fis = new FileInputStream(projectPath + "\\src\\test\\resources\\properties\\config.properties");
		configProp.load(fis);

		if (configProp.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\src\\test\\resources\\executable\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (configProp.getProperty("browser").contains("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					projectPath + "\\src\\test\\resources\\executable\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

	}// setupWebDriver()

	public void navigateURL(String url) {

		driver.get(url);
	}

	public void click(By by) {

		driver.findElement(by).click();

	}

	public void sendKeys(By by, String keyvalue) {

		driver.findElement(by).sendKeys(keyvalue);
	}

	public String getText(By by) {

		return driver.findElement(by).getText();

	}

	@AfterSuite
	public void tearDown() {

		driver.close();
	}

}// class
