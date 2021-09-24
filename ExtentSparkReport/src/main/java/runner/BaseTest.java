package runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
	public static WebDriver driver;
	@BeforeTest
	public static void setUp() throws IOException {
//		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
		driver = new ChromeDriver();
		System.out.println("Driver successfully started...");
	}
	@AfterTest
	public static void after() {
		driver.close();
	}
}
