package E2ETesting.FirstMavenProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class Base {
	public WebDriver driver;
	public LoginPage loginPage;
	
	public Properties getProperties() throws IOException {
		File dataFile = new File("data/data.properties");
		String absolutePathToData = dataFile.getAbsolutePath();
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(absolutePathToData);
		properties.load(fis);
		return properties;
	}
	public void login() throws IOException {
		loginPage.validLogin(getProperties().getProperty("invalidU"), getProperties().getProperty("invalidP"));
		//test 
	}
	public WebDriver initializeDriver() throws IOException {
		String browserName = getProperties().getProperty("browser");
	//	properties.load(fis);
	//	String browserName = properties.getProperty("browser");
		// web pages
		
		// selects browser from data.properties
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		return driver;
	}
	@AfterClass
	public void closeAll() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
