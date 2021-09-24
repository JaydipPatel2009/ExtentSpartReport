package runner;


import java.io.IOException;


import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/main/resources/features",
glue = {"stepDefinitions"},
plugin = {"pretty","json:target/cucumber-reports/CucumberTestReport.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},monochrome = true)

public class TestRunner extends BaseTest{
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass(){
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws IOException {

    	testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
	
	@DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        return testNGCucumberRunner.provideScenarios();
    }
	
	@AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }
}
