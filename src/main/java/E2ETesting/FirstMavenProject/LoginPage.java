package E2ETesting.FirstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[text()='Login']");
	By errorMsg = By.xpath("//*[contains(text(),'wrong password')]");
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getUsername() {
		return driver.findElement(By.name("username"));
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginBtn() {
		return  driver.findElement(loginBtn);
	}

	public WebElement getErrorMsg() {
		return  driver.findElement(errorMsg);
	}
	
	public void validLogin(String username, String password) {
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);		
		getLoginBtn().click();
		
	}
	public boolean loginErrorAssert() throws InterruptedException {
            try {
            	getErrorMsg();  
            	Thread.sleep(2000);
                return true;	// if is displayed
            } catch (org.openqa.selenium.NoSuchElementException e) {
                return false;
            }
		
	}

}
