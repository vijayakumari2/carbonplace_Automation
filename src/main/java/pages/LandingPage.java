package pages;

import managers.WebDriverManager;

public class LandingPage {

	private WebDriverManager app;

	public LandingPage(WebDriverManager app) {
		this.app=app;
	}

	public void load(String browser) {
		app.log("Openning the Browser");
		app.openBrowser(browser);
	}
	
	public void url() {
		app.navigateURL("appURl");
	}
	
	public void verifyingPageTitle() {
		app.validateTitle("landingpageactualtitle", false);	
	}

	public void verifyingLandingPage(String text) {	
		app.log("Verifying whether" +text+ "is present in CP landing Page");
		app.verifyTextinPage(text, true);
	}

	public void clickingLoginButton() {
		app.log("Clicking on Log In button on CP landing Page");
		app.click("loginbutton_xpath", true);
	}

}
