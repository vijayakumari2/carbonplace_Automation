package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		// features = "@rerun/failed_scenarios.txt",
		features = "src/test/resources/features", glue = { "teststeps" }, plugin = {
				"html:target/cucumber-reports.html", "rerun:rerun/failed_scenarios.txt"},tags="not @skip")
				
public class CPRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
