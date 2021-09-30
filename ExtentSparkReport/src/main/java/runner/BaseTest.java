package runner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.*;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
		public static WebDriver driver;
// 	static Wait<WebDriver> wait;
	@BeforeTest
	public static void setUp() throws IOException {
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
//		driver = new ChromeDriver();
		
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.managed_default_content_settings.notifications", 1);
		
		//Create chrome options to set this prefs
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
// 		wait = new FluentWait<WebDriver>(driver)
// 			       .withTimeout(30, TimeUnit.SECONDS)
// 			       .pollingEvery(5, TimeUnit.SECONDS)
// 			       .ignoring(NoSuchElementException.class);
		
		
		System.out.println("Driver successfully started...");
	}
	@AfterTest
	public static void after() {
		driver.close();
	}
}
