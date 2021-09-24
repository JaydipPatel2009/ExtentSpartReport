package stepDefinitions;

import io.cucumber.java.en.*;
import runner.TestRunner;

public class StepDef_LoginPage extends TestRunner{
	
	@Given("User launches the Google")
	public void testStep() throws Throwable{
		driver.get("https://www.google.com");
	}
	
	@Given("User launches the FaceBook")
	public void testStep2() throws Throwable{
		driver.get("https://www.facebook.com");
	}
}
