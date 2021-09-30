package runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	public static WebDriver driver;
	static ExtentReports extent;
	@BeforeTest
	public static void setUp() throws IOException {
//		System.out.println(System.getProperty("user.dir"));
// 		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		System.out.println("Driver successfully started...");
//		String reportPath = System.getProperty("user.dir")+"/target/test-output/Spark/Spark.html";
//		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
//		String reportConfigPath = System.getProperty("user.dir")+"/src/test/resources/extent-config.xml";
//		reporter.loadXMLConfig(reportConfigPath);
//		
//		//report for attachment
//		extent = new ExtentReports();
//		extent.setAnalysisStrategy(AnalysisStrategy.TEST);
//		extent.attachReporter(reporter);
		
	}
	@AfterTest
	public static void after() {
		driver.close();
	}
}
