package context;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.Scenario;
import managers.PageObjectManager;
import reports.ExtentManager;

public class TestContext {
	private final PageObjectManager pageObjectManager;
	private ExtentReports report;
	private ExtentTest test;

	public TestContext() {
		report = ExtentManager.getReports();// initialize the reports
		this.pageObjectManager = new PageObjectManager();
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public void createScenario(String scenarioName) {
		test = report.createTest(scenarioName);
		this.pageObjectManager.getWebDriverManager().init(test);
	}

	public void endScenario() {
		this.pageObjectManager.getWebDriverManager().quit();
		report.flush();
	}

	public void log(String msg) {
		this.pageObjectManager.getWebDriverManager().log(msg);
	}
}

