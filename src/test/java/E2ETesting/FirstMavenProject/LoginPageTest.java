package E2ETesting.FirstMavenProject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

public class LoginPageTest extends Base{

	@Test
	public void validLoginTest() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get("http://partsapp.rs");
		login();
		System.out.println(loginPage.getErrorMsg().getText());
		assertTrue(loginPage.loginErrorAssert());
	}
}
