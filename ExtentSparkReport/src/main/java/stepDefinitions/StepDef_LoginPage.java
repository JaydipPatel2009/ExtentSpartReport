package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
//import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import runner.TestRunner;
import org.apache.commons.io.FileUtils;

public class StepDef_LoginPage extends TestRunner{
	@Given("User launches the Google")
	public void testStep() throws Throwable{
		driver.get("https://www.google.com");
	}
	
	@Given("User launches the FaceBook")
	public void testStep2() throws Throwable{
		driver.get("https://www.facebook.com");
	}
	
	@AfterStep
	public void tearDown(Scenario scenario) throws Throwable{
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "");
	}
}
